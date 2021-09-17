package br.com.bitwiselab.jano.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.bitwiselab.jano.service.PessoaService;
import br.com.henry.primmeAcesso.server.PrimmeAcessoManager;
import br.com.henry.primmeAcesso.server.PrimmeAcessoProxy;

@Service("pessoaService")
public class PessoaServiceImpl implements PessoaService {

	private final EquipamentoDao equipamentoDao;
	private final PrimmeAcessoManager manager;

	@Autowired
	public PessoaServiceImpl(EquipamentoDao equipamentoDao) {
		this.equipamentoDao = equipamentoDao;
		this.manager = PrimmeAcessoManager.getInstance();
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa, List<Equipamento> equipamentos)
			throws InterruptedException {
		List<Equipamento> remover = equipamentoDao.listarTodos();
		for (Equipamento equipamento : remover) {
			PrimmeAcessoProxy proxy = manager.getProxy(equipamento.getId());
			proxy.removerPessoa(pessoa);
		}
		for (Equipamento equipamento : equipamentos) {
			PrimmeAcessoProxy proxy = manager.getProxy(equipamento.getId());
			proxy.incluirPessoa(pessoa);
		}
	}
}
