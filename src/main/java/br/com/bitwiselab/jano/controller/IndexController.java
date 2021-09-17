package br.com.bitwiselab.jano.controller;

import br.com.bitwiselab.jano.annotation.Seguranca;
import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.dao.LogLoginDao;
import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.bitwiselab.jano.session.Session;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
@Seguranca(Permissao.INDEX)
public class IndexController extends AbstractController {

	private LogLoginDao logLoginDao;
	private EquipamentoDao equipamentoDao;

	public IndexController(Validator validator, Result result, Session session,
			EquipamentoDao equipamentoDao, LogLoginDao logLoginDao) {
		super(validator, result, session, true, true);
		this.logLoginDao = logLoginDao;
		this.equipamentoDao = equipamentoDao;
	}

	@Get
	@Path("/")
	public void index() {
		Usuario usuario = session.getUsuario();
		result.include("usuario", usuario);
		result.include("equipamentos", equipamentoDao.listarTodos());
		result.include("ultimoAcesso", logLoginDao.buscarUltimoAcesso(usuario));
		result.include("urlHelp", "/index/help");
	}
}