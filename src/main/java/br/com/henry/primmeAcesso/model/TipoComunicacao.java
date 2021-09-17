package br.com.henry.primmeAcesso.model;


public enum TipoComunicacao {

	SERIAL(1, 'S', "Serial"), //
	SERIAL485(2, 'Q', "Serial 485"), //
	TCP(3, 'T', "TCP/IP"), //
	WIFI(4, 'W', "WI-FI"), //
	GPRS(5, 'G', "GPRS");

	private int id;
	private char valor;
	private String descricao;

	private TipoComunicacao(int id, char valor, String descricao) {
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

	public static TipoComunicacao fromId(int value) {
		TipoComunicacao[] tipos = TipoComunicacao.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
