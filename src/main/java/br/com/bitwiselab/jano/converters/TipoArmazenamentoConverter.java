package br.com.bitwiselab.jano.converters;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.henry.primmeAcesso.model.TipoArmazenamento;

@Convert(TipoArmazenamento.class)
@ApplicationScoped
public class TipoArmazenamentoConverter implements Converter<TipoArmazenamento> {
	public TipoArmazenamento convert(String value,
			Class<? extends TipoArmazenamento> type, ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return TipoArmazenamento.fromId(Integer.valueOf(value));
		} catch (NumberFormatException e) {
			throw new ConversionError(
					MessageFormat.format(
							I18nUtil.getText("tipoArmazenamentoConverter.tipoArmazenamentoInvalido"),
							value));
		}
	}
}