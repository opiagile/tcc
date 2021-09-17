package br.com.henry.primmeAcesso.model;

public enum Padrao2D {

	QR_CODE(0, "QR Code"), //
	EAN13(1, "EAN 13"), //
	EAN8(2, "EAN 8"), //
	INTERLEAVED(3, "Interleaved 2 of 5"), //
	CODE128(4, "Code 128"), //
	CODE39(5, "Code 39"), //
	ISBN10(6, "ISBN 10"), //
	ISBN13(7, "ISBN 13");

	private int id;
	private String descricao;

	private Padrao2D(int id, String descricao) {
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

	public static Padrao2D fromId(int value) {
		Padrao2D[] tipos = Padrao2D.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
