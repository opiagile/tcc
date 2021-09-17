package br.com.bitwiselab.jano.componentes;

import java.util.Date;

import br.com.bitwiselab.jano.util.DateUtil;

public class Documento {
	private String numero;
	private String orgaoExpedidor;
	private Date dataExpedicao;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public String getDataExpedicaoFormatada() {
		return DateUtil.formatarData(dataExpedicao);
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

}
