package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.henry.primmeAcesso.model.Padrao2D;

@Convert(Padrao2D.class)
@ApplicationScoped
public class Padrao2DConverter implements Converter<Padrao2D> {
	public Padrao2D convert(String value, Class<? extends Padrao2D> type,
			ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return Padrao2D.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(
					I18nUtil.getText("padrao2DConverter.padrao2DInvalido"),
					value));
		}
	}
}