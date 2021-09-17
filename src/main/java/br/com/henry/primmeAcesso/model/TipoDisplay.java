package br.com.henry.primmeAcesso.model;


public enum TipoDisplay {

	GRAFICO(1, 'G', "Gráfico"), //
	DIGITAL(2, 'D', "16x2");

	private int id;
	private char valor;
	private String descricao;

	private TipoDisplay(int id, char valor, String descricao) {
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

	public static TipoDisplay fromId(int value) {
		TipoDisplay[] tipos = TipoDisplay.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
