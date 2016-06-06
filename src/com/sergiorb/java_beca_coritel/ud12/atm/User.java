/**
 * 
 * @file User.java
 * @author Sergio Romero Barra
 * 
 * Defines an User class.
 * 
 */

package com.sergiorb.java_beca_coritel.ud12.atm;

// Main class
public class User {
	
	private int id; // User id.
	private String uuid; // User uuid.
	private String name; // User name.
	private String lastName; // User lastName.
	
	/** @constructor main */
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
