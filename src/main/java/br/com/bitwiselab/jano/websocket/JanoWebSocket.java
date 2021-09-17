package br.com.bitwiselab.jano.websocket;

import java.util.List;

import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.websocket.WebSocket;
import org.atmosphere.websocket.WebSocketEventListenerAdapter;
import org.atmosphere.websocket.WebSocketProcessor;
import org.atmosphere.websocket.WebSocketProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JanoWebSocket implements WebSocketProtocol {
	private static final Logger logger = LoggerFactory
			.getLogger(JanoWebSocket.class);

	@Override
	public void configure(AtmosphereConfig config) {
	}

	@Override
	public List<AtmosphereRequest> onMessage(WebSocket webSocket, String message) {
		AtmosphereResource r = webSocket.resource();
		Broadcaster b = lookupBroadcaster(r.getRequest().getPathInfo());

		if (message != null && message.indexOf("message") != -1) {
			b.broadcast(message.substring("message=".length()));
		}
		// Do not dispatch to another Container
		return null;
	}

	@Override
	public List<AtmosphereRequest> onMessage(WebSocket webSocket,
			byte[] message, int offset, int length) {
		return null;
	}

	@Override
	public void onOpen(WebSocket webSocket) {
		logger.debug("ON OPEN");
		// Accept the handshake by suspending the response.
		AtmosphereResource r = webSocket.resource();
		Broadcaster b = lookupBroadcaster(r.getRequest().getPathInfo());
		r.setBroadcaster(b);
		r.addEventListener(new WebSocketEventListenerAdapter());

		r.suspend(-1);
	}

	@Override
	public void onClose(WebSocket webSocket) {
		logger.debug("ON CLOSE");
		// Tell Atmosphere to
		webSocket.resource().resume();
	}

	public void onError(WebSocket webSocket,
			WebSocketProcessor.WebSocketException t) {
		logger.debug("ON ERROR");
		logger.debug(t.getMessage() + " Status {} Message {}", t.response()
				.getStatus(), t.response().getStatusMessage());
	}

	/**
	 * Retrieve the {@link Broadcaster} based on the request's path info.
	 * 
	 * @param pathInfo
	 * @return the {@link Broadcaster} based on the request's path info.
	 */
	public static Broadcaster lookupBroadcaster(String pathInfo) {
		logger.debug("ON LOOKUP");
		Broadcaster b = BroadcasterFactory.getDefault().lookup(pathInfo, true);
		return b;
	}
}
