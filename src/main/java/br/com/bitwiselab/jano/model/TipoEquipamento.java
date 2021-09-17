package br.com.bitwiselab.jano.model;

public enum TipoEquipamento {
	PRIMMEACESSO(1, "Primme Acesso");

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
