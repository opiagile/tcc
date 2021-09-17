package br.com.bitwiselab.jano.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.bitwiselab.jano.dao.UsuarioDao;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	private final HttpSession session;
	private final UsuarioDao usuarioDao;
	private Long idUsuario;

	public Session(HttpServletRequest request, UsuarioDao usuarioDao) {
		this.session = request.getSession();
		this.usuarioDao = usuarioDao;

		request.setAttribute("usuario", this);
	}

	public void invalidar() {
		session.invalidate();
	}

	public Usuario getUsuario() {
		if (idUsuario == null) {
			return null;
		} else {
			return usuarioDao.buscar(idUsuario);
		}
	}

	public void setUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isAutenticado() {
		return (getUsuario() != null);
	}
}
