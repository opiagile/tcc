package br.com.bitwiselab.jano.model;

import java.util.Set;

import br.com.henry.primmeAcesso.model.EstadoEquipamento;
import br.com.henry.primmeAcesso.model.configuracao.Configuracao;

public class Equipamento extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private Configuracao configuracao;
	private Set<Pessoa> pessoas;
	private EstadoEquipamento estado;

	public Equipamento() {
		configuracao = new Configuracao();
	}

	public Equipamento(Long id) {
		setId(id);
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public EstadoEquipamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoEquipamento estado) {
		this.estado = estado;
	}

	public String getNome() {
		return configuracao.getComunicacao().getTcp().getNome();
	}

}
