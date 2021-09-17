package br.com.bitwiselab.jano.dao;

import br.com.bitwiselab.jano.model.Logradouro;

public interface LogradouroDao extends Dao<Logradouro> {

	public Logradouro buscarPorCep(String cep);

}
