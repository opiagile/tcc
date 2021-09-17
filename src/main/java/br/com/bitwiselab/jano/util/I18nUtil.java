package br.com.bitwiselab.jano.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18nUtil {
	private static final String FORMAT = "???%s???";

	@SuppressWarnings("finally")
	public static String getText(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages");
		String value = "";
		try {
			value = bundle.getString(key);
		} catch (MissingResourceException e) {
			value = String.format(FORMAT, key);
		} finally {
			return value;
		}
	}
}
