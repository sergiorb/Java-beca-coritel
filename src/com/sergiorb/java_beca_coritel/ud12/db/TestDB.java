/**
 * 	@file TestDB.java
 *	@author Sergio Romero Barra
 *
 */

package com.sergiorb.java_beca_coritel.ud12.db;

import java.sql.SQLException;

/** Main class */
public class TestDB {

	/** Main method */
	public static void main (String[] args) throws InstantiationException, 
	IllegalAccessException, ClassNotFoundException, SQLException {
		
		// Instantiate a db object for the given parameters.
		DB db = new DB("127.0.0.1", "test", "root", "dai2");
		
		// Defines a variable from Students class.
		Students students;
		
		// Connect to db.
		db.Connect();
		
		// Instantiates a Student object for accessing them. 
		students = new Students(db);
		
		// Calls show all method from student class.
		students.showAll();
		
		// Disconnects db.
		db.Disconnect();
	}
}
