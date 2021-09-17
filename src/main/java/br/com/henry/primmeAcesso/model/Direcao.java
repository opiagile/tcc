package br.com.henry.primmeAcesso.model;

public enum Direcao {

	BLOQUEADO(1, 'B', "Bloqueado"), //
	AMBOS(2, 'A', "Ambos"), //
	ENTRADA(3, 'E', "Entrada"), //
	SAIDA(4, 'S', "Saída"), //
	AUTOMATICO(5, 'U', "Automatico");

	private int id;
	private char valor;
	private String descricao;

	private Direcao(int id, char valor, String descricao) {
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

	public static Direcao fromId(int value) {
		Direcao[] tipos = Direcao.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
