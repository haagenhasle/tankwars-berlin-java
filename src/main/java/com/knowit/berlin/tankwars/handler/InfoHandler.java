package com.knowit.berlin.tankwars.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.knowit.berlin.tankwars.dto.info.InfoResponse;
import com.knowit.berlin.tankwars.helper.ApiGatewayResponse;

public class InfoHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(InfoHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: " + input);

		Map<String, String> headers = new HashMap<>();
		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");
		headers.put("Access-Control-Allow-Origin", "*");
		headers.put("Access-Control-Allow-Credentials", "true");

		InfoResponse infoResponse = new InfoResponse("Hågens tank", "Hågen");
		return ApiGatewayResponse.builder().setStatusCode(200).setObjectBody(infoResponse).setHeaders(headers).build();
	}
}
