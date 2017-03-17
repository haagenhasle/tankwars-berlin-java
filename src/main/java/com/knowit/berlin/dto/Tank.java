package com.knowit.berlin.dto;

public class Tank {

	private int x;
	private int y;
	private int strength;
	private String direction; // left, right, top, bottom - kan det være en
								// enum?
	private int ammo;
	private String status;
	private int targetRange;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTargetRange() {
		return targetRange;
	}

	public void setTargetRange(int targetRange) {
		this.targetRange = targetRange;
	}

}
