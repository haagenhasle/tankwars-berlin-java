package com.knowit.berlin.tankwars.dto.command;

public class Command {

	private String matchId;
	private int mapWidth;
	private int mapHeight;
	private int suddenDeath;
	private int wallDamage;
	private int tankDamage;
	private int weaponDamage;
	private int visibility;
	private int weaponRange;
	private Tank you;
	private Tank[] enemies;
	private Wall[] walls;
	private Field[] fire;

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	public int getSuddenDeath() {
		return suddenDeath;
	}

	public void setSuddenDeath(int suddenDeath) {
		this.suddenDeath = suddenDeath;
	}

	public int getWallDamage() {
		return wallDamage;
	}

	public void setWallDamage(int wallDamage) {
		this.wallDamage = wallDamage;
	}

	public int getTankDamage() {
		return tankDamage;
	}

	public void setTankDamage(int tankDamage) {
		this.tankDamage = tankDamage;
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public int getWeaponRange() {
		return weaponRange;
	}

	public void setWeaponRange(int weaponRange) {
		this.weaponRange = weaponRange;
	}

	public Tank getYou() {
		return you;
	}

	public void setYou(Tank you) {
		this.you = you;
	}

	public Tank[] getEnemies() {
		return enemies;
	}

	public void setEnemies(Tank[] enemies) {
		this.enemies = enemies;
	}

	public Wall[] getWalls() {
		return walls;
	}

	public void setWalls(Wall[] walls) {
		this.walls = walls;
	}

	public Field[] getFire() {
		return fire;
	}

	public void setFire(Field[] fire) {
		this.fire = fire;
	}

}
