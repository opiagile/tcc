package br.com.henry.primmeAcesso.model;

public enum TipoEquipamento {

	PRIMMEACESSO(1, "Primme Acesso"), //
	PRIMME(2, "Primme"), //
	PRIMME2(3, "Primme 2"), //
	ARGUS(4, "Argus"), //
	PRISMA2(5, "Prisma 2");

	private int id;
	private String descricao;

	private TipoEquipamento(int id, String descricao) {
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

	public static TipoEquipamento fromId(int value) {
		TipoEquipamento[] tipos = TipoEquipamento.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
