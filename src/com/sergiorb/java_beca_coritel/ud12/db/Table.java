/**
 * 
 * @file Table.java
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.java_beca_coritel.ud12.db;

import java.sql.SQLException;

/** Abstracts Table class */
public abstract class Table {

	private DB databaseConnection; // Stores a db connection object.
	private int verboseLevel;
	
	/** @constructor Main */
	public Table(DB databaseConnection) {
		this.setDatabaseConnection(databaseConnection);
		this.setVerboseLevel(3);
	}
	
	/** @constructor With verbose level */
	public Table(DB databaseConnection, int verboseLevel) {
		this.setDatabaseConnection(databaseConnection);
		this.setVerboseLevel(verboseLevel);
	}

	/** @return the databaseConnection */
	public DB getDatabaseConnection() {
		return databaseConnection;
	}

	/** @param databaseConnection the databaseConnection to set */
	public void setDatabaseConnection(DB databaseConnection) {
		this.databaseConnection = databaseConnection;
	}
	
	/** @return the verboseLevel */
	public int getVerboseLevel() {
		return verboseLevel;
	}

	/** @param verboseLevel the verboseLevel to set */
	public void setVerboseLevel(int verboseLevel) {
		this.verboseLevel = verboseLevel;
	}

	public boolean isDBConnected() throws SQLException{
		
		if(this.getDatabaseConnection().getConnection() == null || 
				this.getDatabaseConnection().getConnection().isClosed()) {
			
			if(this.getVerboseLevel()>=3){System.out.printf("\n[%s][Warning]: DB is not conected\n", 
					this.getClass().getSimpleName());}
			return false;
		} else {
			return true;
		}
	}
}
