package br.com.henry.primmeAcesso.model;

public enum VelocidadeSerial {

	V9600(1, 9600, "9600"), //
	V19200(2, 19200, "19200"), //
	V57600(3, 57600, "57600"), //
	V115600(4, 115200, "115600");

	private int id;
	private int valor;
	private String descricao;

	private VelocidadeSerial(int id, int valor, String descricao) {
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public static VelocidadeSerial fromId(int value) {
		VelocidadeSerial[] tipos = VelocidadeSerial.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
