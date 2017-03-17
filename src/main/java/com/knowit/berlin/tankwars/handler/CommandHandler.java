package com.knowit.berlin.tankwars.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knowit.berlin.tankwars.dto.command.Command;
import com.knowit.berlin.tankwars.dto.command.CommandResponse;
import com.knowit.berlin.tankwars.dto.command.type.CommandType;
import com.knowit.berlin.tankwars.helper.ApiGatewayResponse;

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
		Command command;
		try {
			command = mapper.readValue((String) input.get("body"), Command.class);
		} catch (IOException ioe) {
			LOG.error("Det funka ikke..", ioe);
			return ApiGatewayResponse.builder().setStatusCode(500).setHeaders(headers).build();
		}
		// Calculate what to do!
		command.getEnemies();

		CommandResponse commandResponse = new CommandResponse(randomCommand());
		return ApiGatewayResponse.builder().setStatusCode(200).setObjectBody(commandResponse).setHeaders(headers)
				.build();
	}

	private CommandType randomCommand() {
		CommandType cmd;
		Random random = new Random();
		int randomInt = random.nextInt(6);
		switch (randomInt) {
		case 0:
			cmd = CommandType.fire;
			break;
		case 1:
			cmd = CommandType.forward;
			break;
		case 2:
			cmd = CommandType.turnleft;
			break;
		case 3:
			cmd = CommandType.turnright;
			break;
		case 4:
			cmd = CommandType.reverse;
			break;
		case 5:
			// We prefer firing! :)
			cmd = CommandType.fire;
			break;
		default:
			cmd = CommandType.pass;
			break;
		}
		return cmd;
	}
}
