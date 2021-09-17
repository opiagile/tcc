package br.com.bitwiselab.jano.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bitwiselab.jano.dao.AcessoDao;
import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.dao.PessoaDao;
import br.com.bitwiselab.jano.json.EquipamentoJsonMessage;
import br.com.bitwiselab.jano.json.PanicoJsonMessage;
import br.com.bitwiselab.jano.model.Acesso;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.bitwiselab.jano.service.EquipamentoService;
import br.com.bitwiselab.jano.websocket.EquipamentoWebSocket;
import br.com.bitwiselab.jano.websocket.PanicoWebSocket;
import br.com.henry.primmeAcesso.model.EstadoEquipamento;
import br.com.henry.primmeAcesso.server.PanicoState;
import br.com.henry.primmeAcesso.server.PanicoState.Panico;
import br.com.henry.primmeAcesso.server.PrimmeAcessoManager;
import br.com.henry.primmeAcesso.server.PrimmeAcessoProxy;

@Service("equipamentoService")
public class EquipamentoServiceImpl implements EquipamentoService {

	private AcessoDao acessoDao;
	private EquipamentoDao equipamentoDao;
	private EquipamentoWebSocket equipamentoWebSocket;
	private PanicoWebSocket panicoWebSocket;
	private PessoaDao pessoaDao;
	private PrimmeAcessoManager manager;

	@Autowired
	public EquipamentoServiceImpl(AcessoDao acessoDao,
			EquipamentoDao equipamentoDao,
			EquipamentoWebSocket equipamentoWebSocket,
			PanicoWebSocket panicoWebSocket, PessoaDao pessoaDao) {
		this.acessoDao = acessoDao;
		this.equipamentoDao = equipamentoDao;
		this.equipamentoWebSocket = equipamentoWebSocket;
		this.panicoWebSocket = panicoWebSocket;
		this.pessoaDao = pessoaDao;
		this.manager = PrimmeAcessoManager.getInstance();
	}

	@Override
	public void atualizarConfiguracoes(Equipamento equipamento) {
		PrimmeAcessoProxy proxy = manager.getProxy(equipamento.getId());
		proxy.atualizarConfiguracaoEquipamento(equipamento);
	}

	@Override
	public void alterarEstadoConexao(Long codigo, boolean conectado) {
		Equipamento equipamento = equipamentoDao.buscar(codigo);
		if (conectado) {
			equipamento.setEstado(EstadoEquipamento.ONLINE);
		} else {
			equipamento.setEstado(EstadoEquipamento.OFFLINE);
		}
		equipamentoWebSocket.broadcast(new EquipamentoJsonMessage(true,
				equipamento));
		equipamentoDao.salvar(equipamento);

	}

	@Override
	public List<Equipamento> carregarEquipamentos() {
		return equipamentoDao.listarTodos();
	}

	@Override
	public void liberarAcesso(Long codigo, int tempoLiberacao) {
		manager.getProxy(codigo).enviarLiberacaoPorClickParaEquipamento(
				tempoLiberacao);
	}

	@Override
	public Pessoa buscarPessoaPorIdentificador(String identificador) {
		return pessoaDao.buscarPorIdentificacao(identificador);
	}

	@Override
	public void gravarAcesso(Acesso acesso) {
		acessoDao.salvar(acesso);
	}

	@Override
	public void ativarPanico() {
		panicoWebSocket.broadcast(new PanicoJsonMessage(true, manager
				.getPanico()));
	}

	@Override
	public void desativarPanico() {
		PanicoState panico = manager.getPanico();
		panico.setEstado(Panico.INATIVO);
		panicoWebSocket.broadcast(new PanicoJsonMessage(true, panico));
	}
}
