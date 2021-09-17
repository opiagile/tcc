package br.com.bitwiselab.jano.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import br.com.bitwiselab.jano.annotation.Seguranca;
import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.dao.PessoaDao;
import br.com.bitwiselab.jano.dao.UsuarioDao;
import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.TipoLiberacaoAcesso;
import br.com.bitwiselab.jano.model.TipoLogLogin;
import br.com.bitwiselab.jano.report.Acessos;
import br.com.bitwiselab.jano.report.Login;
import br.com.bitwiselab.jano.report.Acessos.FiltroAcessos;
import br.com.bitwiselab.jano.report.Login.FiltroLogin;
import br.com.bitwiselab.jano.session.Session;
import br.com.bitwiselab.jano.util.DateUtil;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import freemarker.template.TemplateException;

@Resource
@Path("/relatorio")
public class RelatorioController extends AbstractController {

	private EquipamentoDao equipamentoDao;
	private PessoaDao pessoaDao;
	private UsuarioDao usuarioDao;

	public RelatorioController(Validator validator, Result result,
			Session session, EquipamentoDao equipamentoDao,
			PessoaDao pessoaDao, UsuarioDao usuarioDao) {
		super(validator, result, session, true, true);
		this.equipamentoDao = equipamentoDao;
		this.usuarioDao = usuarioDao;
		this.pessoaDao = pessoaDao;
	}

	private void validarLoginProcessar(final FiltroLogin filtro) {
		validator.checking(new Validations() {
			{
				that(DateUtil.periodoValido(filtro.getPeriodo()),
						"periodo.invalido",
						"relatorioController.validator.periodoInvalido");
			}
		});
		validator.onErrorRedirectTo(RelatorioController.class).loginFiltrar(
				filtro);
	}

	@Seguranca(Permissao.RELATORIO_LOGIN)
	public void loginFiltrar(FiltroLogin filtro) {
		if (filtro == null) {
			filtro = new FiltroLogin();
		}
		result.include("tipos", Arrays.asList(TipoLogLogin.values()));
		result.include("usuarios", usuarioDao.listarTodos());
		result.include("filtro", filtro);
		result.include("urlHelp", filtro.getUrlHelp());
	}

	@Seguranca(Permissao.RELATORIO_LOGIN)
	@Get
	public void loginProcessar(FiltroLogin filtro) throws IOException,
			TemplateException, SQLException {
		validarLoginProcessar(filtro);
		Login relatorio = new Login();
		result.include("relatorio", relatorio.processar(filtro));
		result.include("filtro", filtro);
		result.include("urlHelp", filtro.getUrlHelp());
	}

	@Seguranca(Permissao.RELATORIO_LOGIN)
	public void loginHelp() {
	}

	@Seguranca(Permissao.RELATORIO_LOGIN)
	public void acessosFiltrar(FiltroAcessos filtro) {
		if (filtro == null) {
			filtro = new FiltroAcessos();
		}
		result.include("pessoas", pessoaDao.listarTodos());
		result.include("equipamentos", equipamentoDao.listarTodos());
		result.include("tipos", Arrays.asList(TipoLiberacaoAcesso.values()));
		result.include("filtro", filtro);
		result.include("urlHelp", filtro.getUrlHelp());
	}

	private void validarAcessosProcessar(final FiltroAcessos filtro) {
		validator.checking(new Validations() {
			{
				that(DateUtil.periodoValido(filtro.getPeriodo()),
						"periodo.invalido",
						"relatorioController.validator.periodoInvalido");
			}
		});
		validator.onErrorUsePageOf(RelatorioController.class).acessosFiltrar(
				filtro);
	}

	@Seguranca(Permissao.RELATORIO_LOGIN)
	@Post
	public void acessosProcessar(FiltroAcessos filtro) throws IOException,
			TemplateException, SQLException {
		validarAcessosProcessar(filtro);
		Acessos relatorio = new Acessos();
		result.include("relatorio", relatorio.processar(filtro));
		result.include("filtro", filtro);
		result.include("urlHelp", filtro.getUrlHelp());
	}

	@Seguranca(Permissao.RELATORIO_LOGIN)
	public void acessosHelp() {
	}

}