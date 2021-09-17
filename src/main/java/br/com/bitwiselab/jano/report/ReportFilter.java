package br.com.bitwiselab.jano.report;

import java.util.Map;

public interface ReportFilter {

	public Map<String, Object> toParams();

	public Map<String, Object> toStrings();
}
