package br.com.henry.primmeAcesso.model;

public enum TipoAcesso {

	BLOQUEAR_NAO_CADASTRADOS(1, 'B', "Bloquear não cadastrados"), //
	LIVRE_NAO_CADASTRADOS(2, 'V', "Livre para não cadastrados"), //
	LIVRE_CADASTRADOS(3, 'L', "Livre para todos");

	private int id;
	private char valor;
	private String descricao;

	private TipoAcesso(int id, char valor, String descricao) {
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public char getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public static TipoAcesso fromId(int value) {
		TipoAcesso[] tipos = TipoAcesso.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
