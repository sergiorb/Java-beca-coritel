/**
 * 
 * @file UserTable.java
 * @author Sergio Romero Barra
 * 
 * Defines Users Table access methods.
 * 
 */

package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** Main class */
public class UsersTable extends Table {
	
	private final String tableName = "users"; // DB Table name
	private PreparedStatement filterByName; // SQL prepared query.

	/** @throws SQLException 
	 * @constructor Main */
	public UsersTable(DB db) throws SQLException {
		super(db);
		try {
			this.setCRUDMethods();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** @throws SQLException 
	 * @constructor with verbose */
	public UsersTable(DB db, int verboseLevel) throws SQLException {
		super(db, verboseLevel);
		try {
			this.setCRUDMethods();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** @return the tableName */
	public String getTableName() {
		return tableName;
	}
	
	/** @return the filterByName */
	public PreparedStatement getFilterByName() {
		return filterByName;
	}

	/** @param filterByName the filterByName to set */
	public void setFilterByName(PreparedStatement filterByName) {
		this.filterByName = filterByName;
	}

	/** @method defines CRUD and additional DB methods*/
	@Override
	protected void setCRUDMethods() throws SQLException {
		
		this.all = this.getDatabaseConnection().getConnection().prepareStatement(
					String.format("SELECT * FROM %s", this.getTableName()));
		this.get = this.getDatabaseConnection().getConnection().prepareStatement(
					String.format("SELECT * FROM %s WHERE id = ?", this.getTableName()));
		this.post = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("INSERT INTO %s(uuid, name, last_name) VALUES(?, ?, ?)", 
						this.getTableName()));
		this.put = null;
		this.delete = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("DELETE FROM %s WHERE id = ?", this.getTableName()));
		
		this.setFilterByName(this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("SELECT * FROM %s WHERE name = '%?%'", this.getTableName())));
	}
	
	/** @return all users objects within an arrayList */
	public ArrayList<User> all() {
		
		
		ArrayList<User> users  = new ArrayList<User>();
		
		// If prepared statement is defined
		if(this.getAll() != null) {
			
			try {
				
				// Executes query
				ResultSet result = this.getAll().executeQuery(); 
				
				users = new ArrayList<User>();
				
				// For every record in the set...
				while(result.next()) {
					
					// Creates and adds a new User object,
					users.add(new User(result.getInt(1), result.getString(2), 
							result.getString(3), result.getString(4)));
				}
				
				return users; // Returns arraylist
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return users; // Return void arrayList
	}
	
	/** @return an User object by its id */
	public User get(int id) {
			
		User user;
		
		// If prepared statement is defined
		if(this.get != null) {
				
			try {
				
				// Sets query id
				this.get.setInt(1, id);
			
				// Executes query
				ResultSet result = this.getGet().executeQuery();
				
				// If there is a record...
				if(result.next()) {
				
					// Creates and adds a new User object.
					user = new User(result.getInt(1), result.getString(2), 
							result.getString(3), result.getString(4));
						
					return user; // Returns it.
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null; // Returns void.
	}
	
	/** @return User object arrayList by name */
	public ArrayList<User> filterByName() throws SQLException {
		
		ArrayList<User> users = new ArrayList<User>();
		
		// If prepared statement is defined.
		if(this.getAll() != null) {
			
			// Executes query.
			ResultSet result = this.getAll().executeQuery();
		
			// For every record in set...
			while(result.next()) {
				
				// Creates and adds a new User object.
				users.add(new User(result.getInt(1), result.getString(2), 
						result.getString(3), result.getString(4)));
			}
			
			return users; // Returns it.
		}
		
		return users; // Returns void.
	}
}
