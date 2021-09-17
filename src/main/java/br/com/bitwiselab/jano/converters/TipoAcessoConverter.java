package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.henry.primmeAcesso.model.TipoAcesso;

@Convert(TipoAcesso.class)
@ApplicationScoped
public class TipoAcessoConverter implements Converter<TipoAcesso> {
	public TipoAcesso convert(String value, Class<? extends TipoAcesso> type,
			ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return TipoAcesso.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(
					I18nUtil.getText("tipoAcessoConverter.tipoAcessoInvalido"),
					value));
		}
	}
}