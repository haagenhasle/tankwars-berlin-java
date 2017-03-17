package com.knowit.berlin.dto;

public class Info {

	private final String name;
	private final String owner;

	public Info(String name, String owner) {
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
