package br.com.bitwiselab.jano.report;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.bitwiselab.jano.componentes.Periodo;
import br.com.bitwiselab.jano.model.TipoLogLogin;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.bitwiselab.jano.report.result.GroupBy;
import br.com.bitwiselab.jano.report.result.Report;
import br.com.bitwiselab.jano.util.DateUtil;
import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.bitwiselab.jano.util.ObjectUtil;

public class Login extends ReportAdapter {
	public static class FiltroLogin implements ReportFilter {
		private Periodo periodo;
		private TipoLogLogin tipo;
		private Usuario usuario;
		private String nomeRelatorio = I18nUtil
				.getText("relatorio.login.title");
		private Date dataAtual = new Date();
		private String urlHelp = "/relatorio/loginHelp";

		public FiltroLogin() {
			periodo = new Periodo(true);
		}

		public Periodo getPeriodo() {
			return periodo;
		}

		public void setPeriodo(Periodo periodo) {
			this.periodo = periodo;
		}

		public TipoLogLogin getTipo() {
			return tipo;
		}

		public void setTipo(TipoLogLogin tipo) {
			this.tipo = tipo;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public String getNomeRelatorio() {
			return nomeRelatorio;
		}

		public void setNomeRelatorio(String nomeRelatorio) {
			this.nomeRelatorio = nomeRelatorio;
		}

		public Date getDataAtual() {
			return dataAtual;
		}

		public void setDataAtual(Date dataAtual) {
			this.dataAtual = dataAtual;
		}

		public String getUrlHelp() {
			return urlHelp;
		}

		@Override
		public Map<String, Object> toParams() {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("idUsuario", ObjectUtil.nullSafe(getUsuario()));
			params.put("idTipo", ObjectUtil.nullSafe(getTipo()));
			params.put("dataInicio", getPeriodo().getInicioString());
			params.put("dataFim", getPeriodo().getFimString());
			return params;
		}

		@Override
		public Map<String, Object> toStrings() {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("usuario", null);
			params.put("tipo", (getTipo() == null ? null : getTipo()
					.getDescricao()));
			params.put("dataInicial",
					DateUtil.formatarData(getPeriodo().getInicio()));
			params.put("dataFinal",
					DateUtil.formatarData(getPeriodo().getFim()));
			return null;
		}
	}

	private static final String QUERY = "login.ftl";

	public Login() {
		super(QUERY);
	}

	@Override
	protected void posProcessarRelatorio(Report report) throws SQLException {
		super.posProcessarRelatorio(report);
		GroupBy groupBy = new GroupBy(new String[] { "nome" }, "outros");
		groupBy.agrupar(report);
	}
}
