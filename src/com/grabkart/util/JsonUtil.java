package com.grabkart.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class JsonUtil {

	private static ObjectMapper mapper;
	
	private JsonUtil() {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
	}

	public static ObjectMapper getObjectMapper() {
		synchronized (mapper) {
			if (mapper == null) {
				mapper = new ObjectMapper();
				mapper.setSerializationInclusion(Inclusion.NON_NULL);
			}
		}

		return mapper;
	}
}
