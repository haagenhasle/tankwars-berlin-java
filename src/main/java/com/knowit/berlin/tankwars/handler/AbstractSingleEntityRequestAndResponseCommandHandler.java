package com.knowit.berlin.tankwars.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knowit.berlin.tankwars.helper.ApiGatewayResponse;
import com.knowit.berlin.tankwars.helper.Headers;

public abstract class AbstractSingleEntityRequestAndResponseCommandHandler<T>
		implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(AbstractSingleEntityRequestAndResponseCommandHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: " + input);

		ObjectMapper mapper = new ObjectMapper();
		T command;
		try {
			command = mapper.readValue((String) input.get("body"), getClazz());
		} catch (IOException ioe) {
			LOG.error("Error marshalling from json", ioe);
			return ApiGatewayResponse.builder().setStatusCode(500).setHeaders(Headers.generateDefaultHeaders()).build();
		}

		return ApiGatewayResponse.builder().setStatusCode(200).setObjectBody(process(command))
				.setHeaders(Headers.generateDefaultHeaders()).build();
	}

	// How do you do this elegantly without reified generics?
	protected abstract Class<T> getClazz();

	protected abstract Object process(T body);

}
