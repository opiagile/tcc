package br.com.henry.primmeAcesso.model;

public enum TamperExterno {

	DESABILITADO(1, 'D', "Desabilitado"), //
	ALERTA(2, 'A', "Alerta"), //
	BLOQUEIO(3, 'B', "Bloqueio"), //
	ALERTA_BLOQUEIO(4, 'S', "Alerta + Bloqueio");

	private int id;
	private char valor;
	private String descricao;

	private TamperExterno(int id, char valor, String descricao) {
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

	public static TamperExterno fromId(int value) {
		TamperExterno[] tipos = TamperExterno.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}

}
