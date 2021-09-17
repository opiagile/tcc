package br.com.henry.primmeAcesso.model;

public enum TipoMensagem {

	DESATIVADA(0, "Desativada"), //
	MATRICULA(1, "Matricula"), //
	PERSONALIZADA(2, "Matricula"), //
	SAUDACAO(3, "Saudação"), //
	DATAHORA(4, "Data e Hora"), //
	NOME(5, "Nome da Pessoa");

	private int id;
	private String descricao;

	private TipoMensagem(int id, String descricao) {
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

	public static TipoMensagem fromId(int value) {
		TipoMensagem[] tipos = TipoMensagem.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
