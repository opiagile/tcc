package br.com.bitwiselab.jano.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.bitwiselab.jano.model.Equipamento;
import br.com.henry.primmeAcesso.model.EstadoEquipamento;

public class EquipamentoJson {

	private Long id;
	private String ip;
	private int porta;
	private EstadoEquipamento estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public EstadoEquipamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoEquipamento estado) {
		this.estado = estado;
	}

	protected static void popularEquipamentoJson(Equipamento equipamento,
			EquipamentoJson equipamentoJson) {
		if (equipamento == null || equipamentoJson == null) {
			return;
		}
		equipamentoJson.setId(equipamento.getId());
		equipamentoJson.setIp(equipamento.getConfiguracao().getComunicacao()
				.getTcp().getIp());
		equipamentoJson.setPorta(equipamento.getConfiguracao().getComunicacao()
				.getTcp().getPorta());
		equipamentoJson.setEstado(equipamento.getEstado());
	}

	public static EquipamentoJson toJSON(Equipamento equipamento) {
		if (equipamento == null) {
			return null;
		}

		EquipamentoJson equipamentoJson = new EquipamentoJson();
		popularEquipamentoJson(equipamento, equipamentoJson);

		return equipamentoJson;
	}

	public static List<EquipamentoJson> toJSONList(
			List<? extends Equipamento> lista) {
		if (lista == null) {
			return null;
		}

		List<EquipamentoJson> retorno = new ArrayList<EquipamentoJson>();
		for (Equipamento alarme : lista) {
			retorno.add(toJSON(alarme));
		}
		return retorno;
	}
}
