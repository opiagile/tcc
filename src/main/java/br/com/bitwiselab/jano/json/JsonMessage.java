package br.com.bitwiselab.jano.json;

public class JsonMessage<V> {
	private static final String UNKNOWN_TYPE = "UNKNOWN";

	private String type = UNKNOWN_TYPE;
	private V payload;

	public JsonMessage() {
	}

	public JsonMessage(String type, V payload) {
		this.type = type;
		this.payload = payload;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public V getPayload() {
		return payload;
	}

	public void setPayload(V payload) {
		this.payload = payload;
	}
}