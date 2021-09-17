package br.com.bitwiselab.jano.model;

public enum TipoLiberacaoAcesso implements AbstractType {
	COMANDO(1, "Liberado por Comando"), //
	PANICO(2, "Pânico"), //
	PERMISSAO(3, "Liberado com Permissão");

	private int id;
	private String descricao;

	private TipoLiberacaoAcesso(int id, String descricao) {
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

	public static TipoLiberacaoAcesso fromId(int value) {
		TipoLiberacaoAcesso[] tipos = TipoLiberacaoAcesso.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
