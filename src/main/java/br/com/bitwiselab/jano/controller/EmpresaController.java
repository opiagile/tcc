package br.com.bitwiselab.jano.controller;

import br.com.bitwiselab.jano.annotation.Seguranca;
import br.com.bitwiselab.jano.dao.EmpresaDao;
import br.com.bitwiselab.jano.dao.UfDao;
import br.com.bitwiselab.jano.model.Empresa;
import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.session.Session;
import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;

@Resource
@Path("/empresa")
public class EmpresaController extends AbstractController {

	private final EmpresaDao empresaDao;
	private final UfDao ufDao;

	public EmpresaController(Validator validator, Result result,
			Session session, EmpresaDao empresaDao, UfDao ufDao) {
		super(validator, result, session, true, true);
		this.empresaDao = empresaDao;
		this.ufDao = ufDao;
	}

	private void validarEmpresa(final Empresa empresa) {
		validator.validate(empresa);
		validator.onErrorSendBadRequest();
	}

	private Empresa preencherEmpresaDB(final Empresa empresa) {
		Empresa empresaDB = empresaDao.buscarOuCriar(empresa.getId());
		empresaDB.setNome(empresa.getNome());
		empresaDB.setCnpj(empresa.getCnpj());
		empresaDB.setContato(empresa.getContato());
		empresaDB.setEndereco(empresa.getEndereco());
		return empresaDB;
	}

	@Get
	@Path("/listar")
	@Seguranca(Permissao.EMPRESA_CADASTRAR)
	public void listar() {
		result.include("title", I18nUtil.getText("empresa.listar.titulo"));
		result.include("urlHelp", "/empresa/help");
		result.include("empresas", empresaDao.listarTodos());
	}

	@Get
	@Path("/cadastrar")
	@Seguranca(Permissao.EMPRESA_CADASTRAR)
	public void cadastrar() {
		Empresa empresa = new Empresa();
		result.redirectTo(EmpresaController.class).editar(empresa);
	}

	@Get
	@Path("/editar/{id}")
	@Seguranca(Permissao.EMPRESA_CADASTRAR)
	public void editar(Long id) {
		result.redirectTo(EmpresaController.class)
				.editar(empresaDao.buscar(id));

	}

	@Get
	@Seguranca(Permissao.EMPRESA_CADASTRAR)
	public void editar(Empresa empresa) {
		result.include("empresa", empresa);
		result.include("ufs", ufDao.listarTodos());
	}

	@Post
	public void salvar(Empresa empresa) {
		validarEmpresa(empresa);
		empresaDao.salvar(preencherEmpresaDB(empresa));
		result.use(Results.json()).withoutRoot()
				.from(I18nUtil.getText("empresaController.salvar.sucesso"))
				.serialize();
	}

}
