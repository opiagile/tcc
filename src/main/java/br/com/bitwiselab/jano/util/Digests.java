package br.com.bitwiselab.jano.util;

import java.security.MessageDigest;

public final class Digests {
	private Digests() {
	}

	public static String digest(String message) {
		return digest("SHA-256", message);
	}

	private static String digest(String type, String message) {
		try {
			MessageDigest md = MessageDigest.getInstance(type);
			byte[] digest = md.digest(message.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < digest.length; i++) {
				hexString.append(byteToHexString(digest[i]));
			}
			return hexString.toString();
		} catch (Exception e) {
			return null;
		}
	}

	private static String byteToHexString(byte b) {
		return String.format("%02X", 0xFF & b);
	}
}