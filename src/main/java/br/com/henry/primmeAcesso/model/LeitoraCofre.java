package br.com.henry.primmeAcesso.model;

public enum LeitoraCofre {

	LEITOR1(1, "Leitor 1"), //
	LEITOR2(2, "Leitor 2");

	private int id;
	private String descricao;

	private LeitoraCofre(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public static LeitoraCofre fromId(int value) {
		LeitoraCofre[] tipos = LeitoraCofre.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
