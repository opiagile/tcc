package br.com.bitwiselab.jano.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.bitwiselab.jano.annotation.Seguranca;
import br.com.bitwiselab.jano.componentes.Periodo;
import br.com.bitwiselab.jano.dao.EmpresaDao;
import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.dao.PessoaDao;
import br.com.bitwiselab.jano.dao.UfDao;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.bitwiselab.jano.service.PessoaService;
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
@Path("/pessoa")
public class PessoaController extends AbstractController {

	private final PessoaDao pessoaDao;
	private final EmpresaDao empresaDao;
	private final EquipamentoDao equipamentoDao;
	private final UfDao ufDao;
	private final PessoaService pessoaService;

	public PessoaController(Validator validator, Result result,
			Session session, PessoaDao pessoaDao, EmpresaDao empresaDao,
			EquipamentoDao equipamentoDao, UfDao ufDao,
			PessoaService pessoaService) {
		super(validator, result, session, true, true);
		this.pessoaDao = pessoaDao;
		this.empresaDao = empresaDao;
		this.equipamentoDao = equipamentoDao;
		this.ufDao = ufDao;
		this.pessoaService = pessoaService;
	}

	private Pessoa preencherPessoaDB(final Pessoa pessoa,
			Set<Equipamento> equipamentos) {
		Pessoa pessoaDB = pessoaDao.buscarOuCriar(pessoa.getId());
		pessoaDB.setContato(pessoa.getContato());
		pessoaDB.setDocumento(pessoa.getDocumento());
		pessoaDB.setEmpresa(pessoa.getEmpresa());
		pessoaDB.setEndereco(pessoa.getEndereco());
		pessoaDB.setEquipamentos(equipamentos);
		pessoaDB.setNascimento(pessoa.getNascimento());
		pessoaDB.setNome(pessoa.getNome());
		pessoaDB.setIdentificador(pessoa.getIdentificador());
		pessoaDB.setPeriodoPermanencia(pessoa.getPeriodoPermanencia());
		pessoaDB.setObservacao(pessoa.getObservacao());
		return pessoaDB;
	}

	@Get
	@Path("/listar")
	@Seguranca(Permissao.PESSOA_CADASTRAR)
	public void listar() {
		result.include("title", I18nUtil.getText("pessoa.listar.titulo"));
		result.include("urlHelp", "/pessoa/help");
		result.include("pessoas", pessoaDao.listarTodos());
	}

	@Get
	@Path("/cadastrar")
	@Seguranca(Permissao.PESSOA_CADASTRAR)
	public void cadastrar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setPeriodoPermanencia(new Periodo(new Date(), null));
		result.redirectTo(PessoaController.class).editar(pessoa);
	}

	@Get
	@Path("/editar/{id}")
	@Seguranca(Permissao.PESSOA_CADASTRAR)
	public void editar(Long id) {
		result.redirectTo(PessoaController.class).editar(pessoaDao.buscar(id));
	}

	@Get
	@Seguranca(Permissao.PESSOA_CADASTRAR)
	public void editar(Pessoa pessoa) {
		result.include("pessoa", pessoa);
		result.include("empresas", empresaDao.listarTodos());
		result.include("equipamentos", equipamentoDao.listarTodos());
		result.include("ufs", ufDao.listarTodos());
	}

	@Post
	@Seguranca(Permissao.PESSOA_CADASTRAR)
	public void salvar(Pessoa pessoa, List<Equipamento> equipamentos)
			throws InterruptedException, UnsupportedEncodingException {
		Pessoa pessoaDB = preencherPessoaDB(pessoa, new HashSet<Equipamento>(
				equipamentos));
		pessoaDao.salvar(pessoaDB);
		pessoaService.atualizarPessoa(pessoaDB, equipamentos);
		result.use(Results.json()).withoutRoot()
				.from(I18nUtil.getText("pessoaController.salvar.sucesso"))
				.serialize();
	}

}