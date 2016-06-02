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
	
	/** @return the tableName */
	public String getTableName() {
		return tableName;
	}

	/** @method */
	public void showAll() throws SQLException {
		
		System.out.println("Creating statement show all...");
		
		// Creates a statement object to execute queries.
		Statement statement = this.getDatabaseConnection().getDBConnection().createStatement();
		System.out.print("Executing Query...");
		
		// Executes query and return a result set object.
		ResultSet result = statement.executeQuery(String.format("SELECT * FROM %s;", this.getTableName()));
		System.out.println("Executed!");
		
		// Stores table columns values.
		String id, name, lastName;
		
		System.out.println("-------------------------------------");
		// Loops over the result set.
		while(result.next()){
			
			// Gets column(1, 2 and 3) values.
			id = result.getString(1);
			name = result.getString(2);
			lastName = result.getString(3);
			
			System.out.printf("%2s - %-6s - %-6s\n", id, name, lastName);
		}
		System.out.println("-------------------------------------");
	}
}
