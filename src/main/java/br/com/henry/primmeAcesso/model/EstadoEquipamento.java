package br.com.henry.primmeAcesso.model;

public enum EstadoEquipamento {

	ONLINE(1, "online"), //
	OFFLINE(2, "offline"), //
	CONECTANDO(3, "conectando");

	private int id;
	private String descricao;

	private EstadoEquipamento(int id, String descricao) {
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

	public static EstadoEquipamento fromId(int value) {
		EstadoEquipamento[] tipos = EstadoEquipamento.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}