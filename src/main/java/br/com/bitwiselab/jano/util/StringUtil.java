package br.com.bitwiselab.jano.util;


public class StringUtil {

	public static boolean isVazio(String string) {
		return (string == null || string.isEmpty());
	}

	public static String concatenar(String... args) {
		StringBuilder sb = new StringBuilder();
		for (String string : args) {
			sb.append(string);
		}
		return sb.toString();
	}
}
