package br.com.henry.primmeAcesso.model;

public enum PadraoTemplate {

	SUPREMA(1, 'S', "Suprema"), //
	ISO(2, 'I', "ISO");

	private int id;
	private char valor;
	private String descricao;

	private PadraoTemplate(int id, char valor, String descricao) {
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

	public static PadraoTemplate fromId(int value) {
		PadraoTemplate[] tipos = PadraoTemplate.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
