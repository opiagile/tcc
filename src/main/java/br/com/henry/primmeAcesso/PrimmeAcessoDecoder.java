package br.com.henry.primmeAcesso;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import br.com.henry.primmeAcesso.command.recebimento.ReceptionCommand;
import br.com.henry.primmeAcesso.command.recebimento.RegistroReceptionCommand;

public class PrimmeAcessoDecoder extends CumulativeProtocolDecoder {
	private static Map<String, ReceptionCommand> comandos;
	private Long id;

	public PrimmeAcessoDecoder(Long id) {
		this.id = id;
	}

	static {
		comandos = new HashMap<String, ReceptionCommand>();
		comandos.put("REON", new RegistroReceptionCommand());
	}

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		in.get();
		byte tamanho = in.get();
		in.get();
		byte[] stringzera = new byte[tamanho];
		for (short i = 0; i < tamanho; i++) {
			stringzera[i] = in.get();
		}
		in.getShort();
		String str = new String(stringzera);
		System.out.println("Chegou! " + str);
		String[] array = str.split("\\+");
		ReceptionCommand command = comandos.get(array[1]);
		command.setId(id);
		command.consultaBanco(array);
		return true;
	}
}
