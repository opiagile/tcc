package br.com.henry.primmeAcesso.model;

public enum TipoLiberacao {

	BLOQUEADO(1, 'B', "Bloqueado"), //
	ENTRADA(2, 'E', "Entrada"), //
	SAIDA(3, 'S', "Saída"), //
	AMBOS(4, 'A', "Ambos");

	private int id;
	private char valor;
	private String descricao;

	private TipoLiberacao(int id, char valor, String descricao) {
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

	public static TipoLiberacao fromId(int value) {
		TipoLiberacao[] tipos = TipoLiberacao.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
