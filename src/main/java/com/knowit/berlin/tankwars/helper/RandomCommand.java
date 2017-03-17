package com.knowit.berlin.tankwars.helper;

import java.util.Random;

import com.knowit.berlin.tankwars.dto.command.type.CommandType;

public class RandomCommand {

	private RandomCommand() {
	}

	public static CommandType command() {
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
