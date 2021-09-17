package br.com.bitwiselab.jano.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.bitwiselab.jano.annotation.Seguranca;
import br.com.bitwiselab.jano.dao.PessoaDao;
import br.com.bitwiselab.jano.dao.UsuarioDao;
import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.bitwiselab.jano.session.Session;
import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Resource
@Path("/usuario")
public class UsuarioController extends AbstractController {

	private final UsuarioDao usuarioDao;
	private final PessoaDao pessoaDao;

	public UsuarioController(Validator validator, Result result,
			Session session, PessoaDao pessoaDao, UsuarioDao usuarioDao) {
		super(validator, result, session, true, true);
		this.pessoaDao = pessoaDao;
		this.usuarioDao = usuarioDao;
	}

	private void validarUsuario(final Usuario usuario) {
		validator.validate(usuario);
		validator.onErrorSendBadRequest();
	}

	private void validarAlterarSenha(final String senha,
			final String confirmarSenha) {
		validator.checking(new Validations() {
			{
				if (senha != null) {
					that(senha.equals(confirmarSenha), "erro",
							"usuarioController.alterarSenha.senhasNaoConferem");
					that((senha.length() >= 4 && senha.length() <= 15), "erro",
							"usuarioController.alterarSenha.senhasTamanhoInvalido");
				}
			}
		});

		validator.onErrorSendBadRequest();
	}

	private Usuario preencherUsuarioDB(final Usuario usuario, String senha,
			boolean alterarSenha, List<Permissao> permissoes) {
		Usuario usuarioDB = usuarioDao.buscarOuCriar(usuario.getId());
		usuarioDB.setPessoa(usuario.getPessoa());
		usuarioDB.setLogin(usuario.getLogin());
		if ((alterarSenha || usuario.getId() == null) && senha != null) {
			usuarioDB.setSenha(senha);
			usuarioDB.gerarSenhaCriptografada();
		}
		usuarioDB.setPermissoes(new HashSet<Permissao>(permissoes));
		return usuarioDB;
	}

	@Get
	@Seguranca(Permissao.USUARIO_CADASTRAR)
	@Path("/listar")
	public void listar() {
		result.include("title", I18nUtil.getText("usuario.listar.titulo"));
		result.include("urlHelp", "/usuario/help");
		result.include("usuarios", usuarioDao.listarTodos());
	}

	@Get
	@Path("/cadastrar")
	@Seguranca(Permissao.USUARIO_CADASTRAR)
	public void cadastrar() {
		Usuario usuario = new Usuario();
		Set<Permissao> permissao = new HashSet<Permissao>();
		permissao.add(Permissao.INDEX);
		usuario.setPermissoes(permissao);
		result.redirectTo(UsuarioController.class).editar(usuario, false);
	}

	@Get
	@Path("/editar/{id}")
	@Seguranca(Permissao.USUARIO_CADASTRAR)
	public void editar(Long id) {
		result.redirectTo(UsuarioController.class).editar(
				usuarioDao.buscar(id), true);
	}

	@Get
	@Seguranca(Permissao.USUARIO_CADASTRAR)
	public void editar(Usuario usuario, boolean editar) {
		result.include("pessoas", pessoaDao.listarTodos());
		result.include("permissoes", Arrays.asList(Permissao.values()));
		result.include("usuario", usuario);
		result.include("editar", editar);
	}

	@Post
	@Seguranca(Permissao.USUARIO_CADASTRAR)
	@Path("/salvar")
	public void salvar(Usuario usuario, String senha, String confirmarSenha,
			boolean alterarSenha, List<Permissao> permissoes) {
		validarUsuario(usuario);
		validarAlterarSenha(senha, confirmarSenha);
		usuarioDao.salvar(preencherUsuarioDB(usuario, senha, alterarSenha,
				permissoes));
		result.use(Results.json()).withoutRoot()
				.from(I18nUtil.getText("usuarioController.salvar.sucesso"))
				.serialize();
	}
}