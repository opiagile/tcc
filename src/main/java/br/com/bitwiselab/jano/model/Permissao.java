package br.com.bitwiselab.jano.model;

public enum Permissao {
	USUARIO_CADASTRAR(1, "Cadastrar Usuário"), //
	RELATORIO_LOGIN(2, "Relatórios Login"), //
	EQUIPAMENTO_CADASTRAR(3, "Cadastrar Equipamento"), //
	PESSOA_CADASTRAR(4, "Cadastrar Pessoa"), //
	EMPRESA_CADASTRAR(5, "Cadastrar Empresa"), //
	EQUIPAMENTO_LIBERARACESSO(6, "Liberar Acesso"), //

	INDEX(1000, "Index");

	private int id;
	private String descricao;

	private Permissao(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public static Permissao fromId(int value) {
		Permissao[] tipos = Permissao.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
