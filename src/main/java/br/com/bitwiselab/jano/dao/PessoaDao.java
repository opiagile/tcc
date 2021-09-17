package br.com.bitwiselab.jano.dao;

import br.com.bitwiselab.jano.model.Pessoa;

public interface PessoaDao extends Dao<Pessoa> {

	public Pessoa buscarPorIdentificacao(String identificador);

}
