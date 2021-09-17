package br.com.bitwiselab.jano.dao.hibernate;

import org.hibernate.type.Type;

public class HibernateQueryParam {
	private String name;
	private Object value;
	private Type type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public HibernateQueryParam(String name, Object value, Type type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}

}