package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.henry.primmeAcesso.model.LeitoraCofre;

@Convert(LeitoraCofre.class)
@ApplicationScoped
public class LeitoraCofreConverter implements Converter<LeitoraCofre> {
	public LeitoraCofre convert(String value,
			Class<? extends LeitoraCofre> type, ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return LeitoraCofre.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(I18nUtil
					.getText("leitoraCofreConverter.leitoraCofreInvalido"),
					value));
		}
	}
}
