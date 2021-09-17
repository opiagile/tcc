package br.com.bitwiselab.jano.json;

import java.util.Arrays;
import java.util.List;

import br.com.bitwiselab.jano.dto.EquipamentoJson;
import br.com.bitwiselab.jano.model.Equipamento;

public class EquipamentoJsonMessage extends JsonMessage<List<EquipamentoJson>> {
	private static final String TYPE_PARCIAL = "EquipamentoIncluir_Parcial";
	private static final String TYPE_ATUALIZAR = "EquipamentoIncluir_Atualizar";

	public EquipamentoJsonMessage(boolean atualizar, List<Equipamento> payload) {
		super((atualizar ? TYPE_ATUALIZAR : TYPE_PARCIAL), EquipamentoJson
				.toJSONList(payload));
	}

	public EquipamentoJsonMessage(boolean atualizar, Equipamento payload) {
		this(atualizar, Arrays.asList(payload));
	}
}
