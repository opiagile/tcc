package br.com.bitwiselab.jano.model;

public enum TipoLogLogin implements AbstractType {
	LOGIN(1, "Login"), //
	LOGOUT(2, "Logout");

	private int id;
	private String descricao;

	private TipoLogLogin(int id, String descricao) {
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

	public static TipoLogLogin fromId(int value) {
		TipoLogLogin[] tipos = TipoLogLogin.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
