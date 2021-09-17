package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.henry.primmeAcesso.model.TipoValidacao;

@Convert(TipoValidacao.class)
@ApplicationScoped
public class TipoValidacaoConverter implements Converter<TipoValidacao> {
	public TipoValidacao convert(String value,
			Class<? extends TipoValidacao> type, ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return TipoValidacao.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(MessageFormat.format(I18nUtil
					.getText("tipoValidacaoConverter.tipoValidacaoInvalido"),
					value));
		}
	}
}