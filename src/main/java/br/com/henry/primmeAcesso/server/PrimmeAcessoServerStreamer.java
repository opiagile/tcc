package br.com.henry.primmeAcesso.server;

import java.net.InetSocketAddress;
import java.util.List;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import br.com.henry.primmeAcesso.PrimmeAcessoCodecFacotry;
import br.com.henry.primmeAcesso.PrimmeAcessoHandler;

public class PrimmeAcessoServerStreamer {
	private Long id;
	private NioSocketConnector connector;
	private IoSession session;
	private InetSocketAddress address;

	public PrimmeAcessoServerStreamer(Long id, InetSocketAddress address,
			int timeout) {
		this.address = address;
		this.id = id;
		createConnector(timeout);
	}

	private void createConnector(int timeout) {
		connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(timeout);
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new PrimmeAcessoCodecFacotry(id)));
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.setHandler(new PrimmeAcessoHandler());
	}

	public void connect() {
		try {
			ConnectFuture future = connector.connect(address);
			future.awaitUninterruptibly();
			session = future.getSession();
		} catch (RuntimeIoException e) {
			System.err.println("Failed to connect.");
			e.printStackTrace();
		}
	}

	public void disconnect() {
		session.close(true);
	}

	public void sendMessage(List<String> messages) {
		for (String message : messages) {
			System.out.println("Streamer send Message: " + message);
			session.write(message);
		}
	}

}
