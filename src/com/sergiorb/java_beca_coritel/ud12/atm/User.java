package com.sergiorb.java_beca_coritel.ud12.atm;

public class User {
	
	private int id;
	private String uuid;
	private String name;
	private String lastName;
	
	public User(int id, String uuid, String name, String lastName) {
		this.setId(id);
		this.setUuid(uuid);
		this.setName(name);
		this.setLastName(lastName);
	}
	
	/** @return the id */
	protected int getId() {
		return id;
	}

	/** @param id the id to set */
	protected void setId(int id) {
		this.id = id;
	}

	/** @return the uuid */
	public String getUuid() {
		return uuid;
	}

	/** @param uuid the uuid to set */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/** @return the name */
	public String getName() {
		return name;
	}
	
	/** @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}
	
	/** @return the lastName  */
	public String getLastName() {
		return lastName;
	}
	
	/** @param lastName the lastName to set */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
