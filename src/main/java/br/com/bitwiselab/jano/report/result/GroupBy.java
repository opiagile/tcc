package br.com.bitwiselab.jano.report.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupBy {

	private String[] campos;
	private String outros;

	public GroupBy(String campos[], String outros) {
		this.campos = campos;
		this.outros = outros;
	}

	@SuppressWarnings("unchecked")
	public void agrupar(Report report) {
		List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
		Map<Object, Map<String, Object>> trecos = new HashMap<Object, Map<String, Object>>();

		for (Map<String, Object> dado : report.getDados()) {
			List<Map<String, Object>> groupBy = new ArrayList<Map<String, Object>>();
			Map<String, Object> dados = new HashMap<String, Object>();
			Object principal = dado.get(campos[0]);
			for (String campo : campos) {
				Object value = dado.get(campo);
				dado.remove(campo);
				dados.put(campo, value);
			}
			if (trecos.containsKey(principal)) {
				groupBy.addAll((ArrayList<Map<String, Object>>) trecos.get(
						principal).get(outros));
			}
			groupBy.add(dado);
			dados.put(outros, groupBy);
			trecos.put(principal, dados);
		}
		for (Object dado : trecos.keySet()) {
			lista.add(trecos.get(dado));
		}
		report.setDados(lista);
	}
}
