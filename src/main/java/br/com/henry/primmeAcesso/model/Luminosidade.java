package br.com.henry.primmeAcesso.model;

public enum Luminosidade {

	INTERNO(1, 'I', "Interno"), //
	EXTERNO(2, 'E', "Externo");

	private int id;
	private char valor;
	private String descricao;

	private Luminosidade(int id, char valor, String descricao) {
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

	public static Luminosidade fromId(int value) {
		Luminosidade[] tipos = Luminosidade.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
