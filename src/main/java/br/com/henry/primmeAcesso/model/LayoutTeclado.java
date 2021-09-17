package br.com.henry.primmeAcesso.model;

public enum LayoutTeclado {

	ABNT2(1, 'A', "ABNT2"), //
	USA(2, 'U', "USA");

	private int id;
	private char valor;
	private String descricao;

	private LayoutTeclado(int id, char valor, String descricao) {
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

	public static LayoutTeclado fromId(int value) {
		LayoutTeclado[] tipos = LayoutTeclado.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
