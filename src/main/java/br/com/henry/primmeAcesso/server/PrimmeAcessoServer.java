package br.com.henry.primmeAcesso.server;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.service.EquipamentoService;
import br.com.henry.primmeAcesso.model.EstadoEquipamento;

public class PrimmeAcessoServer {
	private static final int TIMEOUT = 20000;
	private final PrimmeAcessoManager manager;
	private final ExecutorService executor;
	private final EquipamentoDao equipamentoDao;
	private final EquipamentoService equipamentoService;

	@Autowired
	public PrimmeAcessoServer(EquipamentoService equipamentoService,
			EquipamentoDao equipamentoDao) throws Exception {
		this.manager = PrimmeAcessoManager.getInstance();
		this.executor = Executors.newCachedThreadPool();
		this.equipamentoDao = equipamentoDao;
		this.equipamentoService = equipamentoService;
		inicializar();
	}

	public void inicializar() throws Exception {
		List<Equipamento> equipamentos = equipamentoDao.listarTodos();
		for (Equipamento equipamento : equipamentos) {
			equipamento.setEstado(EstadoEquipamento.OFFLINE);
			equipamentoDao.salvar(equipamento);
			String ip = equipamento.getConfiguracao().getComunicacao().getTcp()
					.getIp();
			int porta = equipamento.getConfiguracao().getComunicacao().getTcp()
					.getPorta();
			InetSocketAddress address = new InetSocketAddress(ip, porta);
			PrimmeAcessoServerStreamer streamer = new PrimmeAcessoServerStreamer(
					equipamento.getId(), address, TIMEOUT);
			PrimmeAcesso primme = new PrimmeAcesso(equipamento.getId(), ip,
					streamer, executor);
			PrimmeAcessoProxy proxy = new PrimmeAcessoProxy(
					equipamento.getId(), primme, equipamentoService);
			primme.addProxy(proxy);
			manager.add(proxy);
			primme.testarConexao();
		}
	}
}
