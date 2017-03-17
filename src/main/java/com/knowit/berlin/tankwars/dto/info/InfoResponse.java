package com.knowit.berlin.tankwars.dto.info;

public class InfoResponse {

	private final String name;
	private final String owner;

	public InfoResponse(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}

	public String getName() {
		return this.name;
	}

	public String getOwner() {
		return this.owner;
	}
}
