package br.com.bitwiselab.jano.model;

import java.io.Serializable;

public abstract class AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	public AbstractModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ((int) Math.random() * 10000) + "#"
				+ getClass().getCanonicalName();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(this.getClass().isInstance(other)))
			return false;
		final Long otherId = this.getClass().cast(other).getId();
		return this.getId().equals(otherId);
	}
}
