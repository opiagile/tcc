package br.com.bitwiselab.jano.report.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bitwiselab.jano.util.ConfigUtil;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(ConfigUtil.getJdbcUrl(),
					ConfigUtil.getJdbcUser(), ConfigUtil.getJdbcPass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}