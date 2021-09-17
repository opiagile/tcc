package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.lang.time.DateUtils;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;

@Convert(Date.class)
public class DateConverter implements Converter<Date> {
	private static final String[] FORMATS = { "dd/MM/yyyy HH:mm:ss",
			"dd/MM/yyyy HH:mm", "dd/MM/yyyy" };

	@Override
	public Date convert(String value, Class<? extends Date> type,
			ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return DateUtils.parseDate(value.trim(), FORMATS);
		} catch (Exception e) {
			throw new ConversionError(MessageFormat.format(
					I18nUtil.getText("automaticoConverter.automaticoInvalido"),
					value));
		}
	}

}
