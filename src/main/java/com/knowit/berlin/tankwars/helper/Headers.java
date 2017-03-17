package com.knowit.berlin.tankwars.helper;

import java.util.HashMap;
import java.util.Map;

public class Headers {

	private Headers() {
	}

	public static Map<String, String> generateDefaultHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");
		headers.put("Access-Control-Allow-Origin", "*");
		headers.put("Access-Control-Allow-Credentials", "true");
		return headers;
	}
}
