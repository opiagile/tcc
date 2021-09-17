package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.henry.primmeAcesso.model.EntradaDigital;

@Convert(EntradaDigital.class)
@ApplicationScoped
public class EntradaDigitalConverter implements Converter<EntradaDigital> {
	public EntradaDigital convert(String value,
			Class<? extends EntradaDigital> type, ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return EntradaDigital.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(I18nUtil
					.getText("entradaDigitalConverter.entradaDigitalInvalido"),
					value));
		}
	}
}
