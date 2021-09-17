package br.com.bitwiselab.jano.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bitwiselab.jano.json.JacksonObjectMapper;

@Component
public class EquipamentoWebSocket extends WebSocketAdapter {
	@Autowired
	public EquipamentoWebSocket(JacksonObjectMapper mapper) {
		super("/equipamento", mapper);
	}
}
