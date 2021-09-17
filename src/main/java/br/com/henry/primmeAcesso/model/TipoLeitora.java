package br.com.henry.primmeAcesso.model;

import java.util.ArrayList;
import java.util.List;

public enum TipoLeitora {
	NENHUM(1, 'N', "Nenhum", Leitoras.TODAS), //
	CODIGO_BARRAS(2, 'B', "Código de Barras", Leitoras.LEITORA1,
			Leitoras.LEITORA2, Leitoras.LEITOR2D), //
	WIEGAND(3, 'W', "Wiegand", Leitoras.LEITORA1, Leitoras.LEITORA2), //
	ABATRACK_II(4, 'A', "Abatrack II", Leitoras.LEITORA1, Leitoras.LEITORA2), //
	BIOMETRIA(5, 'M', "Biometria", Leitoras.LEITORA3, Leitoras.EXPANSAO_BIO), //
	MIFARE(6, 'F', "Mifare", Leitoras.LEITORA4, Leitoras.LEITORA5), //
	TECLADO(7, 'K', "Teclado", Leitoras.TECLADO, Leitoras.LEITORA_USB2);

	private int id;
	private char valor;
	private String descricao;
	private Leitoras[] leitoras;

	private TipoLeitora(int id, char valor, String descricao,
			Leitoras... leitoras) {
		this.id = id;
		this.valor = valor;
		this.descricao = descricao;
		this.leitoras = leitoras;
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

	public Leitoras[] getLeitoras() {
		return leitoras;
	}

	public static List<TipoLeitora> getTiposLeitoras(Leitoras leitora) {
		List<TipoLeitora> tipos = new ArrayList<TipoLeitora>();
		for (TipoLeitora tipo : values()) {
			for (Leitoras leitor : tipo.getLeitoras()) {
				if (leitor == leitora || leitor == Leitoras.TODAS) {
					tipos.add(tipo);
				}
			}
		}
		return tipos;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public static boolean isNenhum(TipoLeitora tipo) {
		return (tipo == NENHUM ? true : false);
	}

	public static TipoLeitora fromId(int value) {
		TipoLeitora[] tipos = TipoLeitora.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].getId() == value) {
				return tipos[i];
			}
		}
		return null;
	}
}
