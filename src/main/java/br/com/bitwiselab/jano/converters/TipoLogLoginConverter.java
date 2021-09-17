package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.model.TipoLogLogin;
import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;

@Convert(TipoLogLogin.class)
@ApplicationScoped
public class TipoLogLoginConverter implements Converter<TipoLogLogin> {
	public TipoLogLogin convert(String value,
			Class<? extends TipoLogLogin> type, ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return TipoLogLogin.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(I18nUtil
					.getText("tipoLogLoginConverter.tipoLogLoginInvalido"),
					value));
		}
	}
}
