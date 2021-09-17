package br.com.bitwiselab.jano.util;

import br.com.bitwiselab.jano.model.AbstractModel;
import br.com.bitwiselab.jano.model.AbstractType;

public class ObjectUtil {

	public static Long nullSafe(AbstractModel model) {
		if (model == null) {
			return null;
		}
		return model.getId();
	}

	public static Integer nullSafe(AbstractType type) {
		if (type == null) {
			return null;
		}
		return type.getId();
	}
}
