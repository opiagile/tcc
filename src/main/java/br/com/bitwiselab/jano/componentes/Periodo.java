package br.com.bitwiselab.jano.componentes;

import java.util.Date;

import br.com.bitwiselab.jano.util.DateUtil;

public class Periodo {
	private Date inicio;
	private Date fim;

	public Periodo() {
	}

	public Periodo(Date inicio, Date fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	public Periodo(boolean inicioFimDia) {
		if (inicioFimDia) {
			this.inicio = DateUtil.inicioDia(new Date());
			this.fim = DateUtil.fimDia(new Date());
		}
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getInicioString() {
		return DateUtil.formatarData(inicio);
	}

	public String getFimString() {
		return DateUtil.formatarData(fim);
	}

}
