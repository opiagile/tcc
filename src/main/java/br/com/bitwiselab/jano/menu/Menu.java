package br.com.bitwiselab.jano.menu;

import java.util.List;

import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.bitwiselab.jano.util.I18nUtil;

public class Menu {
	private Menu() {
	}

	public static List<MenuItem> permitido(Usuario usuario) {
		PrincipalDecorator principal = new PrincipalDecorator();
		// Index
		principal.addItem(new LinkDecorator(I18nUtil.getText("menu.home"), "/",
				Permissao.INDEX));

		// Cadastros
		DropdownDecorator cadastros = new DropdownDecorator(
				I18nUtil.getText("menu.cadastros"));

		cadastros.addItem(new LinkDecorator(I18nUtil
				.getText("menu.cadastros.empresa"), "/empresa/listar",
				Permissao.EMPRESA_CADASTRAR));
		principal.addItem(cadastros);
		cadastros.addItem(new LinkDecorator(I18nUtil
				.getText("menu.cadastros.equipamento"), "/equipamento/listar",
				Permissao.EQUIPAMENTO_CADASTRAR));
		cadastros.addItem(new LinkDecorator(I18nUtil
				.getText("menu.cadastros.pessoas"), "/pessoa/listar",
				Permissao.PESSOA_CADASTRAR));
		cadastros.addItem(new LinkDecorator(I18nUtil
				.getText("menu.cadastros.usuarios"), "/usuario/listar",
				Permissao.USUARIO_CADASTRAR));

		// Relatórios
		DropdownDecorator relatorios = new DropdownDecorator(
				I18nUtil.getText("menu.relatorios"));
		relatorios.addItem(new LinkDecorator(I18nUtil
				.getText("menu.relatorios.login"), "/relatorio/loginFiltrar",
				Permissao.RELATORIO_LOGIN));
		relatorios.addItem(new LinkDecorator(I18nUtil
				.getText("menu.relatorios.acessos"),
				"/relatorio/acessosFiltrar", Permissao.RELATORIO_LOGIN));
		principal.addItem(relatorios);

		// Sair
		principal.addItem(new LinkDecorator(I18nUtil.getText("menu.sair"),
				"/seguranca/logout", Permissao.INDEX));

		principal.isPermitido(usuario);
		return principal.getItens();
	}
}