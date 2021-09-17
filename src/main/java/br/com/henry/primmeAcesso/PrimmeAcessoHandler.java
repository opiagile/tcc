package br.com.henry.primmeAcesso;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class PrimmeAcessoHandler extends IoHandlerAdapter {
	@Override
	public void messageReceived(IoSession session, Object message) {
		String str = message.toString();
		System.out.println("Message received: " + str);
	}
}
