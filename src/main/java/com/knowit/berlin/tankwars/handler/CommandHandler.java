package com.knowit.berlin.tankwars.handler;

import com.knowit.berlin.tankwars.dto.command.Command;
import com.knowit.berlin.tankwars.dto.command.CommandResponse;
import com.knowit.berlin.tankwars.helper.RandomCommand;

public class CommandHandler extends AbstractSingleEntityRequestAndResponseCommandHandler<Command> {

	@Override
	protected Class<Command> getClazz() {
		return Command.class;
	}

	@Override
	protected Object process(Command body) {

		// Calculate what to do!
		body.getEnemies();
		return new CommandResponse(RandomCommand.command());

	}
}
