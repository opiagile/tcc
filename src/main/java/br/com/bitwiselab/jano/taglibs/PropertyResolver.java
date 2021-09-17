package br.com.bitwiselab.jano.taglibs;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyResolver {
	private static final String REGEX = "^([a-zA-Z_\\$])([a-zA-Z_0-9\\$]*)$";
	private static final Pattern PATTERN = Pattern.compile(REGEX);
	private static final String FMT_METHOD = "%s%S%s";
	private static final String ERR_INVALID_PROPERTY_NAME = "'%s' não é um nome de propriedade válido";
	private static final String PREFFIX_GETTER = "get";
	private static final String PREFFIX_SETTER = "set";

	private static String resolveMethodName(String preffix, String property) {
		Matcher matcher = PATTERN.matcher(property);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(String.format(
					ERR_INVALID_PROPERTY_NAME, property));
		} else {
			return String.format(FMT_METHOD, preffix, matcher.group(1),
					matcher.group(2));
		}
	}

	public static String resolveGetterMethodName(String property) {
		return resolveMethodName(PREFFIX_GETTER, property);
	}

	public static String resolveSetterMethodName(String property) {
		return resolveMethodName(PREFFIX_SETTER, property);
	}

	private static Method getMethod(Object target, String methodName,
			Class<?>... parametersType) {
		try {
			return target.getClass().getMethod(methodName, parametersType);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Method getGetterMethod(Object target, String property,
			Class<?>... parametersType) {
		String methodName = resolveGetterMethodName(property);
		return getMethod(target, methodName, parametersType);
	}

	public static Method getSetterMethod(Object target, String property,
			Class<?>... parametersType) {
		String methodName = resolveSetterMethodName(property);
		return getMethod(target, methodName, parametersType);
	}

	private static Object invokeMethod(Object target, Method method,
			Object... args) {
		try {
			return method.invoke(target, args);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Object getValue(Object target, String property) {
		Method method = getGetterMethod(target, property);
		return invokeMethod(target, method);
	}
}