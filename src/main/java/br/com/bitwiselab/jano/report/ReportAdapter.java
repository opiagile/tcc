package br.com.bitwiselab.jano.report;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import br.com.bitwiselab.jano.report.connection.ConnectionFactory;
import br.com.bitwiselab.jano.report.result.Report;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public abstract class ReportAdapter {

	private String query;
	private Connection connection;
	private PreparedStatement stmt;
	protected Map<String, Object> params;

	public ReportAdapter() {
	}

	protected ReportAdapter(String query) {
		this.query = query;
		this.connection = ConnectionFactory.getConnection();
	}

	private String processarTemplate() throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), "/report");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		Template t = cfg.getTemplate(query);
		StringWriter writer = new StringWriter();

		t.process(params, writer);
		writer.flush();
		writer.close();

		return writer.toString();
	}

	public Report processar(ReportFilter filter) throws IOException,
			TemplateException, SQLException {
		this.params = filter.toParams();
		String preparedQuery = processarTemplate();
		stmt = connection.prepareStatement(preparedQuery);
		ResultSet result = stmt.executeQuery();
		Report report = new Report(result);
		posProcessarRelatorio(report);
		return report;
	}

	protected void posProcessarRelatorio(Report report) throws SQLException {
		stmt.close();
		connection.close();
	}

}
