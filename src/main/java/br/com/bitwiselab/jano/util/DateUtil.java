package br.com.bitwiselab.jano.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.bitwiselab.jano.componentes.Periodo;

public class DateUtil {

	public static Date inicioDia(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		return gc.getTime();
	}

	public static Date fimDia(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.set(Calendar.HOUR_OF_DAY, 23);
		gc.set(Calendar.MINUTE, 59);
		gc.set(Calendar.SECOND, 59);
		return gc.getTime();
	}

	public static Date adicionarSegundos(Date date, int segundos) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.SECOND, segundos);
		return gc.getTime();
	}

	public static Date adicionarMinutos(Date date, int minutos) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.MINUTE, minutos);
		return gc.getTime();
	}

	public static Date adicionarHoras(Date date, int horas) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.HOUR, horas);
		return gc.getTime();
	}

	public static Date adicionarMeses(Date date, int meses) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.MONTH, meses);
		return gc.getTime();
	}

	public static Date adicionarAnos(Date date, int anos) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(Calendar.YEAR, anos);
		return gc.getTime();
	}

	public static String formatarData(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return format.format(date);
	}

	public static String formatarDataSemHora(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(date);
	}

	public static boolean periodoValido(Periodo periodo) {
		long inicio = periodo.getInicio().getTime();
		long fim = periodo.getFim().getTime();
		return inicio <= fim;
	}

}
