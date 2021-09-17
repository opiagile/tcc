package br.com.bitwiselab.jano.dao;

import br.com.bitwiselab.jano.model.LogLogin;
import br.com.bitwiselab.jano.model.Usuario;

public interface LogLoginDao extends Dao<LogLogin> {

	public LogLogin buscarUltimoAcesso(Usuario usuario);

}
