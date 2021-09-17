package br.com.bitwiselab.jano.report.result;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

	private List<Map<String, Object>> dados;

	public Report() {
	}

	public Report(List<Map<String, Object>> dados) {
		this.dados = dados;
	}

	public Report(ResultSet result) throws SQLException {
		dados = new ArrayList<Map<String, Object>>();
		ResultSetMetaData metaData = result.getMetaData();
		while (result.next()) {
			Map<String, Object> data = new HashMap<String, Object>();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				data.put(metaData.getColumnName(i), result.getObject(i));
			}
			dados.add(data);
		}
	}

	public List<Map<String, Object>> getDados() {
		return dados;
	}

	public void setDados(List<Map<String, Object>> dados) {
		this.dados = dados;
	}
}
