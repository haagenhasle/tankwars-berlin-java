package com.knowit.berlin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knowit.berlin.dto.CommandInput;
import com.knowit.berlin.dto.CommandOutput;

public class CommandHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(CommandHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: " + input);

		Map<String, String> headers = new HashMap<>();
		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");
		headers.put("Access-Control-Allow-Origin", "*");
		headers.put("Access-Control-Allow-Credentials", "true");

		ObjectMapper mapper = new ObjectMapper();
		CommandInput commandInput;
		try {
			commandInput = mapper.readValue((String) input.get("body"), CommandInput.class);
		} catch (IOException ioe) {
			LOG.error("Det funka ikke..", ioe);
			return ApiGatewayResponse.builder().setStatusCode(500).setHeaders(headers).build();
		}
		// Calculate what to do!
		commandInput.getEnemies();

		CommandOutput responseBody = new CommandOutput("fire");
		return ApiGatewayResponse.builder().setStatusCode(200).setObjectBody(responseBody).setHeaders(headers).build();
	}
}
