package br.com.bitwiselab.jano.service;

import java.util.List;

import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;

public interface PessoaService {

	public void atualizarPessoa(Pessoa pessoa, List<Equipamento> equipamentos)
			throws InterruptedException;

}
