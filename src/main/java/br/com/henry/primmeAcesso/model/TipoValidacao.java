package br.com.henry.primmeAcesso.model;

public enum TipoValidacao {

	OFFLINE(1, 'F', "Offline"), //
	ONLINE(2, 'O', "Online"), //
	ONOFF(3, 'A', "Online/Offlne"), //
	PROXIMO(4, 'S', "Modo acesso Prox");

	private int id;
	private char valor;
	private String descricao;

	private TipoValidacao(int id, char valor, String descricao) {
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

	public static TipoValidacao fromId(int value) {
		TipoValidacao[] tipos = TipoValidacao.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
