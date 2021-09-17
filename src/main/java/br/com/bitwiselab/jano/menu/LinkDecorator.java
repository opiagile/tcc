package br.com.bitwiselab.jano.menu;

import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.Usuario;

public class LinkDecorator extends MenuItem {
	private static final String TO_STRING = "%s [%s]";
	private final Permissao permissao;

	public LinkDecorator(String descricao, String url, Permissao permissao,
			String classe) {
		this.descricao = descricao;
		this.url = url;
		this.permissao = permissao;
		this.classe = classe;
	}

	public LinkDecorator(String descricao, String url, Permissao permissao) {
		this(descricao, url, permissao, "");
	}

	public LinkDecorator(String descricao, String url) {
		this(descricao, url, null);
	}

	public String getUrl() {
		return url;
	}

	public boolean isPermitido(Usuario usuario) {
		if (permissao == null) {
			return true;
		} else {
			return usuario.temPermissao(permissao);
		}
	}

	@Override
	public String toString() {
		return String.format(TO_STRING, descricao, url);
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String getClasse() {
		return classe;
	}
}