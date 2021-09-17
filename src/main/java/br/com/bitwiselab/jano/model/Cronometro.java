package br.com.bitwiselab.jano.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import br.com.bitwiselab.jano.service.EquipamentoService;

public class Cronometro {

	private Timer cronometro;
	private DateFormat formato = new SimpleDateFormat("HH:mm:ss");
	private Calendar calendario = Calendar.getInstance();
	private EquipamentoService equipamentoService;
	private final byte contagem;
	// private static final byte PROGRESSIVA = 1;
	private static final byte REGRESSIVA = -1;

	public Cronometro() {
		this.cronometro = new Timer();
		calendario.set(0, 0, 0, 0, 1, 0);
		this.contagem = REGRESSIVA;
	}

	public void cronometro() {
		TimerTask tarefa = new TimerTask() {
			@Override
			public void run() {
				if (isZerado()) {
					desativarPanico();
				} else {
					equipamentoService.ativarPanico();
				}
			}
		};
		cronometro.scheduleAtFixedRate(tarefa, 0, 1000);
	}

	public void desativarPanico() {
		equipamentoService.desativarPanico();
		cronometro.cancel();
		cronometro.purge();
		cronometro = null;
	}

	private boolean isZerado() {
		return (calendario.get(Calendar.SECOND) == 0
				&& calendario.get(Calendar.MINUTE) == 0 && calendario
					.get(Calendar.HOUR) == 0);
	}

	public String getTime() {
		calendario.add(Calendar.SECOND, contagem);
		return formato.format(calendario.getTime());
	}

	public void setEquipamentoService(EquipamentoService equipamentoService) {
		this.equipamentoService = equipamentoService;
	}
}