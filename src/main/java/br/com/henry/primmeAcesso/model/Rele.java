package br.com.henry.primmeAcesso.model;

public class Rele {
	public enum ConfiguracaoRele {
		DESATIVADO(1, 'D', "Desativado"), //
		ENTRADA(2, 'E', "Somente Entrada"), //
		SAIDA(3, 'S', "Somente Saída"), //
		AMBOS(4, 'A', "Ambos os Sentidos"), //
		LISTA(5, 'L', "Conforme Lista"), //
		ACIONAMENTO(6, 'T', "Acionamento");

		private int id;
		private char valor;
		private String descricao;

		private ConfiguracaoRele(int id, char valor, String descricao) {
			this.id = id;
			this.valor = valor;
			this.descricao = descricao;
		}

		public int getId() {
			return id;
		}

		public char getValor() {
			return valor;
		}

		public String getDescricao() {
			return descricao;
		}

		@Override
		public String toString() {
			return descricao;
		}

		public static ConfiguracaoRele fromId(int value) {
			ConfiguracaoRele[] tipos = ConfiguracaoRele.values();
			for (int i = 0; i < tipos.length; i++) {
				if (tipos[i].getId() == value) {
					return tipos[i];
				}
			}
			return null;
		}
	}

	private ConfiguracaoRele configuracao;
	private Integer tempo;

	public Rele() {
		this.configuracao = ConfiguracaoRele.DESATIVADO;
	}

	public ConfiguracaoRele getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(ConfiguracaoRele configuracao) {
		this.configuracao = configuracao;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public String format() {
		if (configuracao == ConfiguracaoRele.DESATIVADO) {
			return String.valueOf(configuracao.getValor());
		}
		return String.format("%s}%s", configuracao.getValor(), tempo);
	}
}
