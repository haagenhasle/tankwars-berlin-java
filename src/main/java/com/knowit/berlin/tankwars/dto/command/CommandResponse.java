package com.knowit.berlin.tankwars.dto.command;

import com.knowit.berlin.tankwars.dto.command.type.CommandType;

public class CommandResponse {

	private final CommandType command;

	public CommandResponse(CommandType command) {
		this.command = command;
	}

	public CommandType getCommand() {
		return this.command;
	}
}