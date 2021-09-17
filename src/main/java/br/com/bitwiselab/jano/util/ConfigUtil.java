package br.com.bitwiselab.jano.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static final String CONFIG_FILE = "config.properties";
	private static final Properties properties = new Properties();

	static {
		try {
			InputStream inputStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream(CONFIG_FILE);
			properties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private ConfigUtil() {
	}

	public static String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static String getJdbcUrl() {
		return getProperty("jdbc.url", "");
	}

	public static String getJdbcUser() {
		return getProperty("jdbc.username", "");
	}

	public static String getJdbcPass() {
		return getProperty("jdbc.password", "");
	}
}