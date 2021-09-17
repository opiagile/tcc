package br.com.henry.primmeAcesso.model;

public enum EntradaDigital {

	DESABILITADO(1, 'D', "Desabilitado"), //
	BOTAO(2, 'B', "Botão"), //
	PORTA(3, 'P', "Porta"), //
	ALARME(4, 'A', "Alarme");

	private int id;
	private char valor;
	private String descricao;

	private EntradaDigital(int id, char valor, String descricao) {
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

	public static EntradaDigital fromId(int value) {
		EntradaDigital[] tipos = EntradaDigital.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
