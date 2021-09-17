package br.com.bitwiselab.jano.service;

import java.util.List;

import br.com.bitwiselab.jano.model.Acesso;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Pessoa;

public interface EquipamentoService {

	public void atualizarConfiguracoes(Equipamento equipamento);

	public void alterarEstadoConexao(Long codigo, boolean conectado);

	public void liberarAcesso(Long codigo, int tempoLiberacao);

	public Pessoa buscarPessoaPorIdentificador(String identificador);

	public List<Equipamento> carregarEquipamentos();

	public void gravarAcesso(Acesso acesso);

	public void ativarPanico();

	public void desativarPanico();
}
