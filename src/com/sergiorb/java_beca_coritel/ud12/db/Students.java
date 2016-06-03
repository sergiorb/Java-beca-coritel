/**
 * 
 * @file Students.java
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.java_beca_coritel.ud12.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Main class */
public class Students extends Table {
	
	private final String tableName = "students"; // DB Table name

	/** @constructor Main */
	public Students(DB db) {
		super(db);
	}
	
	/** @constructor with verbose */
	public Students(DB db, int verboseLevel) {
		super(db, verboseLevel);
	}
	
	/** @return the tableName */
	public String getTableName() {
		return tableName;
	}

	/** @method */
	public void showAll() throws SQLException {
		
		// If db connection is not closed..
		if(this.isDBConnected()) {

			if(this.getVerboseLevel()>=3){System.out.println("Creating statement show all...");};
			// Creates a statement object to execute queries.
			Statement statement = this.getDatabaseConnection().getConnection().createStatement();
			if(this.getVerboseLevel()>=3){System.out.print("Executing Query...");};
			
			// Executes query and return a result set object.
			ResultSet result = statement.executeQuery(String.format("SELECT * FROM %s;", this.getTableName()));
			if(this.getVerboseLevel()>=3){System.out.println("Executed!");};
			
			// Stores table columns values.
			String id, name, lastName;
			
			// Loops over the result set.
			while(result.next()){
				
				// Gets column(1, 2 and 3) values.
				id = result.getString(1);
				name = result.getString(2);
				lastName = result.getString(3);
				
				System.out.printf("%2s - %-6s - %-6s\n", id, name, lastName);
			}
			
			if(this.getVerboseLevel()>=3){System.out.println("Closing result set...");};
			result.close();
			if(this.getVerboseLevel()>=3){System.out.println("Closing statement...");};
			statement.close();
		}
	}
}
