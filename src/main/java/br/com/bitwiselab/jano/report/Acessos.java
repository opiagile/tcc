package br.com.bitwiselab.jano.report;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.bitwiselab.jano.componentes.Periodo;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.bitwiselab.jano.model.TipoLiberacaoAcesso;
import br.com.bitwiselab.jano.report.result.GroupBy;
import br.com.bitwiselab.jano.report.result.Report;
import br.com.bitwiselab.jano.util.DateUtil;
import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.bitwiselab.jano.util.ObjectUtil;

public class Acessos extends ReportAdapter {
	public static class FiltroAcessos implements ReportFilter {
		private Periodo periodo;
		private Pessoa pessoa;
		private Equipamento equipamento;
		private TipoLiberacaoAcesso tipo;
		private String nomeRelatorio = I18nUtil
				.getText("relatorio.acessos.title");
		private Date dataAtual = new Date();
		private String urlHelp = "/relatorio/acessosHelp";

		public FiltroAcessos() {
			periodo = new Periodo(true);
		}

		public Periodo getPeriodo() {
			return periodo;
		}

		public void setPeriodo(Periodo periodo) {
			this.periodo = periodo;
		}

		public Pessoa getPessoa() {
			return pessoa;
		}

		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}

		public Equipamento getEquipamento() {
			return equipamento;
		}

		public void setEquipamento(Equipamento equipamento) {
			this.equipamento = equipamento;
		}

		public TipoLiberacaoAcesso getTipo() {
			return tipo;
		}

		public void setTipo(TipoLiberacaoAcesso tipo) {
			this.tipo = tipo;
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
			params.put("idPessoa", ObjectUtil.nullSafe(getPessoa()));
			params.put("idEquipamento", ObjectUtil.nullSafe(getEquipamento()));
			params.put("idTipoLiberacaoAcesso", ObjectUtil.nullSafe(getTipo()));
			params.put("dataInicio", getPeriodo().getInicioString());
			params.put("dataFim", getPeriodo().getFimString());
			return params;
		}

		@Override
		public Map<String, Object> toStrings() {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("usuario", null);
			params.put("dataInicial",
					DateUtil.formatarData(getPeriodo().getInicio()));
			params.put("dataFinal",
					DateUtil.formatarData(getPeriodo().getFim()));
			return null;
		}
	}

	private static final String QUERY = "acessos.ftl";

	public Acessos() {
		super(QUERY);
	}

	@Override
	protected void posProcessarRelatorio(Report report) throws SQLException {
		super.posProcessarRelatorio(report);
		GroupBy groupBy = new GroupBy(new String[] { "Pessoa" }, "outros");
		groupBy.agrupar(report);
	}
}
