package br.com.bitwiselab.jano.controller;

import br.com.bitwiselab.jano.annotation.Public;
import br.com.bitwiselab.jano.dao.LogLoginDao;
import br.com.bitwiselab.jano.dao.UsuarioDao;
import br.com.bitwiselab.jano.model.LogLogin;
import br.com.bitwiselab.jano.model.TipoLogLogin;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.bitwiselab.jano.session.Session;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Path("/seguranca")
@Resource
@Public
public class SegurancaController extends AbstractController {

	private final UsuarioDao usuarioDao;
	private final LogLoginDao logLoginDao;

	public SegurancaController(Validator validator, Result result,
			Session session, LogLoginDao logLoginDao, UsuarioDao usuarioDao) {
		super(validator, result, session, false);
		this.logLoginDao = logLoginDao;
		this.usuarioDao = usuarioDao;
	}

	@Post
	public void login(String login, String senha) {
		Usuario usuario = usuarioDao.buscarAcesso(login, senha);
		if (usuario == null) {
			validator.add(new ValidationMessage(
					"Usuário e/ou senha inválidos!", ""));
		} else {
			logLoginDao.salvar(new LogLogin(TipoLogLogin.LOGIN, usuario));
			session.setUsuario(usuario.getId());
		}
		validator.onErrorRedirectTo(SegurancaController.class).login();
		result.redirectTo(IndexController.class).index();
	}

	private void validarUsuarioNaoAutenticado() {
		if (session.isAutenticado()) {
			result.redirectTo(IndexController.class).index();
		}
	}

	@Get
	public void login() {
		validarUsuarioNaoAutenticado();
	}

	public void logout() {
		if (session.isAutenticado()) {
			logLoginDao.salvar(new LogLogin(TipoLogLogin.LOGOUT, session
					.getUsuario()));
			session.invalidar();
		}
		result.redirectTo(SegurancaController.class).login();
	}

	public void acessoNegado() {
	}
}