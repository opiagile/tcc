package br.com.henry.primmeAcesso.model;

public enum Automatico {

	AUTOMATICO(1, 'A', "Automático"), //
	NORMAL(2, 'N', "Normal");

	private int id;
	private char valor;
	private String descricao;

	private Automatico(int id, char valor, String descricao) {
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

	public static Automatico fromId(int value) {
		Automatico[] tipos = Automatico.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
