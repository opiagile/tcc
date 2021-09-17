package br.com.bitwiselab.jano.json;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Component;

@Component
public class JacksonObjectMapper extends ObjectMapper {
	public JacksonObjectMapper() {
		configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		configure(SerializationConfig.Feature.INDENT_OUTPUT, false);
		configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
		configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING,
				true);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		setDateFormat(sdf);
	}

	public <T> String toJson(String type, T payload) {
		return toJson(new JsonMessage<T>(type, payload));
	}

	public String toJson(Object message) {
		try {
			return writeValueAsString(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
