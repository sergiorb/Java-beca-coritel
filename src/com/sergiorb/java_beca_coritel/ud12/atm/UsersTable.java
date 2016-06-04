/**
 * 
 * @file Students.java
 * @author Sergio Romero Barra
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
	private PreparedStatement filterByName;

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
		
		this.filterByName = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("SELECT * FROM %s WHERE name = '%?%'", this.getTableName()));
	}
	
	public ArrayList<User> all() {
		
		
		ArrayList<User> users  = new ArrayList<User>();
		
		if(this.getAll() != null) {
			
			try {
				
				ResultSet result = this.getAll().executeQuery();
			
			
				users = new ArrayList<User>();
				
				while(result.next()) {
					users.add(new User(result.getInt(1), result.getString(2), 
							result.getString(3), result.getString(4)));
				}
				
				return users;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return users; 
	}
		
	public User get(int id) {
			
		User user;
			
		if(this.getGet() != null) {
				
			try {
				
				this.getGet().setInt(1, id);
			
				ResultSet result = this.getGet().executeQuery();
				
				if(result.next()) {
				
					user = new User(result.getInt(1), result.getString(2), 
							result.getString(3), result.getString(4));
						
					return user;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public ArrayList<User> filterByName() throws SQLException {
		
		
		ArrayList<User> users = new ArrayList<User>();
		
		if(this.getAll() != null) {
			
			ResultSet result = this.getAll().executeQuery();
						
			while(result.next()) {
				users.add(new User(result.getInt(1), result.getString(2), 
						result.getString(3), result.getString(4)));
			}
			
			return users;
		}
		
		return users;
	}
}
