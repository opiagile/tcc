package br.com.bitwiselab.jano.websocket;

import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;

import br.com.bitwiselab.jano.json.JacksonObjectMapper;
import br.com.bitwiselab.jano.json.JsonMessage;

public abstract class WebSocketAdapter {
	private final String uri;
	private final JacksonObjectMapper mapper;

	public WebSocketAdapter(String uri, JacksonObjectMapper mapper) {
		this.uri = uri;
		this.mapper = mapper;
	}

	protected synchronized Broadcaster getBroadcaster() {
		final BroadcasterFactory factory = BroadcasterFactory.getDefault();
		if (factory != null) {
			return factory.lookup(uri, true);
		} else {
			throw new IllegalStateException();
		}
	}

	public <T> void broadcast(JsonMessage<T> message) {
		final String json = mapper.toJson(message);
		getBroadcaster().broadcast(json);
	}
}