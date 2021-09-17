package br.com.bitwiselab.jano.controller;

import br.com.bitwiselab.jano.dao.LogradouroDao;
import br.com.bitwiselab.jano.session.Session;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;

@Resource
@Path("/logradouro")
public class LogradouroController extends AbstractController {

	private final LogradouroDao logradouroDao;

	public LogradouroController(Validator validator, Result result,
			Session session, LogradouroDao logradouroDao) {
		super(validator, result, session, true);
		this.logradouroDao = logradouroDao;
	}

	@Path("/buscarPorCep/{cep}")
	public void buscarPorCep(String cep) {
		result.use(Results.json())
				.from(logradouroDao.buscarPorCep(cep), "logradouro")
				.include("bairro", "bairro.cidade", "bairro.cidade.uf")
				.serialize();
	}
}