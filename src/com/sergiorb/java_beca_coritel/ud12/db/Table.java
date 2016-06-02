/**
 * 
 * @file Table.java
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.java_beca_coritel.ud12.db;

/** Abstracts Table class */
public abstract class Table {

	private DB databaseConnection; // Stores a db connection object.
	
	/** @constructor Main */
	public Table(DB databaseConnection) {
		this.setDatabaseConnection(databaseConnection);
	}

	/** @return the databaseConnection */
	public DB getDatabaseConnection() {
		return databaseConnection;
	}

	/** @param databaseConnection the databaseConnection to set */
	public void setDatabaseConnection(DB databaseConnection) {
		this.databaseConnection = databaseConnection;
	}
}
