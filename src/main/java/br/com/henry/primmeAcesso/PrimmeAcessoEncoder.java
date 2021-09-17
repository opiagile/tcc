package br.com.henry.primmeAcesso;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class PrimmeAcessoEncoder implements ProtocolEncoder {

	@Override
	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		MensagemRequest request = new MensagemRequest((String) message);
		IoBuffer buffer = IoBuffer.allocate(request.getBytes().length, false);
		buffer.put(request.getBytes());
		buffer.flip();
		out.write(buffer);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
	}
}
