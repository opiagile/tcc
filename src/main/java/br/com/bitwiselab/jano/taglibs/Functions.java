package br.com.bitwiselab.jano.taglibs;

import java.util.Collection;

public class Functions {
	public static boolean contains(Collection<Object> collection, Object item) {
		if (collection == null) {
			return false;
		} else {
			return collection.contains(item);
		}
	}
}
