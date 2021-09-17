package br.com.bitwiselab.jano.dao;

import java.util.List;

import br.com.bitwiselab.jano.model.AbstractModel;

public interface Dao<M extends AbstractModel> {
	public void salvar(M model);

	public void remover(M model);

	public M buscar(Long id);

	public M buscarOuCriar(Long id);

	public List<M> listar(Integer offset, Integer limit);

	public List<M> listarTodos();
}
