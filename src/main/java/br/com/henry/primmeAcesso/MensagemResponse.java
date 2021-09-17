package br.com.henry.primmeAcesso;

import java.io.UnsupportedEncodingException;

public class MensagemResponse {

	private String mensagem;

	public MensagemResponse() {
		this("");
	}

	public MensagemResponse(String mensagem) {
		this.setMensagem(textFormat(mensagem.toCharArray()));
	}

	public MensagemResponse(byte[] mensagem)
			throws UnsupportedEncodingException {
		this.setMensagem(new String(mensagem, "UTF-8"));
	}

	private String textFormat(char[] data) {
		String aux = "", aux2 = "", str = "";
		char BYTE_INIT, BYTE_END, BYTE_TAM[] = { 0, 0 }, BYTE_CKSUM;
		BYTE_INIT = (char) Integer.valueOf("2", 16).intValue();// conf. bit
																// inicial
		BYTE_END = (char) Integer.valueOf("3", 16).intValue();// conf. bit final
		BYTE_TAM[0] = (char) data.length;// conf. tamanho dos dados
		BYTE_TAM[1] = (char) Integer.valueOf("0", 16).intValue();
		aux2 += BYTE_INIT; // Inserindo byte inicial
		aux2 += BYTE_TAM[0]; // Inserindo byte do tamanho
		aux2 += BYTE_TAM[1];
		for (char chr : data) {
			str += chr;
		}
		aux = new String(aux2 + str); // concatenando com a informação

		BYTE_CKSUM = aux.charAt(1);// Calculo do Checksum
		for (int a = 2; a < aux.length(); a++) {
			BYTE_CKSUM = (char) (BYTE_CKSUM ^ aux.charAt(a));
		}
		aux += BYTE_CKSUM; // Inserindo Checksum
		aux += BYTE_END; // Inserindo byte Final
		return aux;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}