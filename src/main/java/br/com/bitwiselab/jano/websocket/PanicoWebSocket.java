package br.com.bitwiselab.jano.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bitwiselab.jano.json.JacksonObjectMapper;

@Component
public class PanicoWebSocket extends WebSocketAdapter {
	@Autowired
	public PanicoWebSocket(JacksonObjectMapper mapper) {
		super("/panico", mapper);
	}
}
