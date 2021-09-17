package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.henry.primmeAcesso.model.Idioma;

@Convert(Idioma.class)
@ApplicationScoped
public class IdiomaConverter implements Converter<Idioma> {
	public Idioma convert(String value, Class<? extends Idioma> type,
			ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return Idioma.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(
					I18nUtil.getText("idiomaConverter.idiomaInvalido"), value));
		}
	}
}
