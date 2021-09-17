package br.com.henry.primmeAcesso.model;

import java.util.Set;

public class Digitos {

	private boolean ativo;
	private Integer quantidadeDigitos;
	private Set<Integer> digitosDescartados;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getQuantidadeDigitos() {
		return quantidadeDigitos;
	}

	public void setQuantidadeDigitos(Integer quantidadeDigitos) {
		this.quantidadeDigitos = quantidadeDigitos;
	}

	public Set<Integer> getDigitosDescartados() {
		return digitosDescartados;
	}

	public void setDigitosDescartados(Set<Integer> digitosDescartados) {
		this.digitosDescartados = digitosDescartados;
	}

	public String format() {
		if (!ativo) {
			return "D";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(quantidadeDigitos);
		int count = 0;
		for (Integer digito : digitosDescartados) {
			if (count == 0) {
				sb.append("}");
			} else {
				sb.append(",");
			}
			sb.append(digito);
			count++;
		}
		return sb.toString();
	}

}
