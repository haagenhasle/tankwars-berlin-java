package com.knowit.berlin.tankwars.dto.command.type;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CommandType {

	@JsonProperty("turn-left")
	turnleft, @JsonProperty("turn-right")
	turnright, forward, reverse, fire, pass;

}
