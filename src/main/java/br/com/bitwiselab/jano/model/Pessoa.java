package br.com.bitwiselab.jano.model;

import java.util.Date;
import java.util.Set;

import br.com.bitwiselab.jano.componentes.Documento;
import br.com.bitwiselab.jano.componentes.Periodo;
import br.com.bitwiselab.jano.util.DateUtil;

public class Pessoa extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private String identificador;
	private String nome;
	private Date nascimento;
	private Endereco endereco;
	private Contato contato;
	private Documento documento;
	private Empresa empresa;
	private Set<Equipamento> equipamentos;
	private String observacao;
	private Periodo periodoPermanencia;
	private byte[] foto;

	public Pessoa() {
	}

	public Pessoa(Long id) {
		setId(id);
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNascimentoString() {
		return DateUtil.formatarDataSemHora(nascimento);
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Set<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(Set<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Periodo getPeriodoPermanencia() {
		return periodoPermanencia;
	}

	public void setPeriodoPermanencia(Periodo periodoPermanencia) {
		this.periodoPermanencia = periodoPermanencia;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
