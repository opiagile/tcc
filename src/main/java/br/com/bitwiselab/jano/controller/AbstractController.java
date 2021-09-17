package br.com.bitwiselab.jano.controller;

import org.apache.log4j.Logger;

import br.com.bitwiselab.jano.menu.Menu;
import br.com.bitwiselab.jano.model.Panico;
import br.com.bitwiselab.jano.session.Session;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.henry.primmeAcesso.server.PrimmeAcessoManager;

public abstract class AbstractController {
	protected final Logger LOGGER = Logger.getLogger(this.getClass());
	protected final Validator validator;
	protected final Result result;
	protected final Session session;
	protected PrimmeAcessoManager manager;

	public AbstractController(Validator validator, Result result,
			Session session, boolean montarMenu, boolean temHelp) {
		this.validator = validator;
		this.result = result;
		this.session = session;
		this.manager = PrimmeAcessoManager.getInstance();
		if (montarMenu && session.isAutenticado()) {
			result.include("itensMenu", Menu.permitido(session.getUsuario()));
		}
		result.include("temHelp", temHelp);
		result.include("panico", new Panico(manager.getPanico().getEstado()));
	}

	public AbstractController(Validator validator, Result result,
			Session session, boolean montarMenu) {
		this(validator, result, session, montarMenu, false);
	}

	public void help() {
	}

}
