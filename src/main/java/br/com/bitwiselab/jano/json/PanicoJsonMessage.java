package br.com.bitwiselab.jano.json;

import br.com.bitwiselab.jano.dto.PanicoJson;
import br.com.henry.primmeAcesso.server.PanicoState;

public class PanicoJsonMessage extends JsonMessage<PanicoJson> {
	private static final String TYPE_PARCIAL = "PanicoIncluir_Parcial";
	private static final String TYPE_ATUALIZAR = "PanicoIncluir_Atualizar";

	public PanicoJsonMessage(boolean atualizar, PanicoState payload) {
		super((atualizar ? TYPE_ATUALIZAR : TYPE_PARCIAL), PanicoJson
				.toJSON(payload));
	}
}
