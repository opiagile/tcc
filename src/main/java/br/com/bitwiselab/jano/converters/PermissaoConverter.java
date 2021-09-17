package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;

@Convert(Permissao.class)
@ApplicationScoped
public class PermissaoConverter implements Converter<Permissao> {
	public Permissao convert(String value, Class<? extends Permissao> type,
			ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return Permissao.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(
					I18nUtil.getText("permissaoConverter.permissaoInvalido"),
					value));
		}
	}
}
