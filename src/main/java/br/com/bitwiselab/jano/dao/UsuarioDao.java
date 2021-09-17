package br.com.bitwiselab.jano.dao;

import br.com.bitwiselab.jano.model.Usuario;

public interface UsuarioDao extends Dao<Usuario> {

	public Usuario buscarAcesso(String login, String senha);

}
