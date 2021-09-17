package br.com.bitwiselab.jano.interceptor;

import org.apache.log4j.Logger;

import br.com.bitwiselab.jano.annotation.Public;
import br.com.bitwiselab.jano.annotation.Seguranca;
import br.com.bitwiselab.jano.controller.SegurancaController;
import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.bitwiselab.jano.session.Session;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;

@Intercepts
@RequestScoped
public class SegurancaInterceptor implements Interceptor {
	private static final Logger LOGGER = Logger
			.getLogger(SegurancaInterceptor.class);

	private static class AutenticacaoException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	private static class AutorizacaoException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	private final Result result;
	private final Session session;

	public SegurancaInterceptor(Result result, Session session) {
		this.result = result;
		this.session = session;
	}

	private Usuario getUsuario() {
		return session.getUsuario();
	}

	private Seguranca getPermissaoMethod(ResourceMethod method) {
		return method.getMethod().getAnnotation(Seguranca.class);
	}

	private Seguranca getPermissaoResource(ResourceMethod method) {
		return method.getResource().getType().getAnnotation(Seguranca.class);
	}

	private Seguranca getPermissao(ResourceMethod method) {
		Seguranca permissao = getPermissaoMethod(method);
		if (permissao == null) {
			permissao = getPermissaoResource(method);
		}
		return permissao;
	}

	private Permissao getAcao(ResourceMethod method) {
		Seguranca permissao = getPermissao(method);
		return ((permissao != null) ? permissao.value() : null);
	}

	private void validarPermissao(Usuario usuario, Permissao acao)
			throws AutenticacaoException, AutorizacaoException {
		LOGGER.debug(String.format("Validar permissão: %s, %s", usuario, acao));
		if (usuario == null) {
			throw new AutenticacaoException();
		} else if (!usuario.temPermissao(acao)) {
			throw new AutorizacaoException();
		}
		LOGGER.debug("Permitido");
	}

	private boolean isPublic(ResourceMethod method) {
		Public publico = method.getMethod().getAnnotation(Public.class);
		if (publico == null) {
			publico = method.getResource().getType()
					.getAnnotation(Public.class);
		}
		return (publico != null);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		Usuario usuario = getUsuario();
		Permissao acao = getAcao(method);
		try {
			validarPermissao(usuario, acao);
			stack.next(method, resourceInstance);
		} catch (AutenticacaoException e) {
			result.use(Results.logic()).redirectTo(SegurancaController.class)
					.login();
		} catch (AutorizacaoException e) {
			result.use(Results.page()).of(SegurancaController.class)
					.acessoNegado();
		}
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return (getAcao(method) != null || isPublic(method));
	}
}
