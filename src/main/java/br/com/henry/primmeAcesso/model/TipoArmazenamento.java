package br.com.henry.primmeAcesso.model;

public enum TipoArmazenamento {

	TODOS(1, 'T', "Todos"), //
	NENHUM(2, 'N', "Nenhum"), //
	NEGADOS(3, 'G', "Negados"), //
	LIBERADOS(4, 'L', "Liberados");

	private int id;
	private char valor;
	private String descricao;

	private TipoArmazenamento(int id, char valor, String descricao) {
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

	public static TipoArmazenamento fromId(int value) {
		TipoArmazenamento[] tipos = TipoArmazenamento.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
