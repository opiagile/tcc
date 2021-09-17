package br.com.bitwiselab.jano.model;

import java.util.Date;

public class LogLogin extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private TipoLogLogin tipo;
	private Usuario usuario;
	private Date dataHora;

	public LogLogin() {
	}

	public LogLogin(Long id) {
		setId(id);
	}

	public LogLogin(TipoLogLogin tipo, Usuario usuario) {
		this.tipo = tipo;
		this.usuario = usuario;
		this.dataHora = new Date();
	}

	public TipoLogLogin getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogLogin tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
