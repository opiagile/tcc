package br.com.henry.primmeAcesso.model;

public enum Idioma {

	PORTUGUES(1, "PT", "Português"), //
	ESPANHOL(2, "ES", "Espanhol"), //
	INGLES(3, "EN", "Inglês");

	private int id;
	private String valor;
	private String descricao;

	private Idioma(int id, String valor, String descricao) {
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public static Idioma fromId(int value) {
		Idioma[] tipos = Idioma.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
