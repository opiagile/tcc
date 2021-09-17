package br.com.bitwiselab.jano.model;

import java.util.Date;

public class Acesso extends AbstractModel {
	private static final long serialVersionUID = 3426748930899447340L;

	private Pessoa pessoa;
	private Date dataAcesso;
	private Equipamento equipamento;
	private TipoLiberacaoAcesso tipo;

	public Acesso(Pessoa pessoa, Equipamento equipamento,
			TipoLiberacaoAcesso tipo) {
		this.pessoa = pessoa;
		this.equipamento = equipamento;
		this.tipo = tipo;
		this.dataAcesso = new Date();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public TipoLiberacaoAcesso getTipo() {
		return tipo;
	}

	public void setTipo(TipoLiberacaoAcesso tipo) {
		this.tipo = tipo;
	}

}
