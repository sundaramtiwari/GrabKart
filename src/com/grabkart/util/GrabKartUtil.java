package com.grabkart.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.grabkart.entity.User;

public class GrabKartUtil {

	public static Map<String, String> getUserMap(User user) {
		ObjectMapper mapper = JsonUtil.getObjectMapper();
		Map<String, String> userMap = new HashMap<String, String>();
		String userStr = null;

		try {
			userStr = mapper.writeValueAsString(user);
			userMap.put("user", userStr);
		} catch (IOException e) {
			System.out.println("Exception in parsing getUserMap: " + user.toString());
		}
		
		return userMap;
	}

	
}
