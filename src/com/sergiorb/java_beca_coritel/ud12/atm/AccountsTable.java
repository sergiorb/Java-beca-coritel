/**
 * 
 * @file AccountsTable.java
 * @author Sergio Romero Barra
 *
 *	Defines Account Table access methods.
 */

package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** Main class */
public class AccountsTable extends Table {
	
	private final String tableName = "accounts"; // DB Table name
	private PreparedStatement getByUserId; // SQL prepared query.
	private PreparedStatement updateAmount; // SQL prepared query.

	/** @throws SQLException 
	 * @constructor Main */
	public AccountsTable(DB db) throws SQLException {
		super(db);
		try {
			this.setCRUDMethods();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** @throws SQLException 
	 * @constructor with verbose */
	public AccountsTable(DB db, int verboseLevel) throws SQLException {
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
	
	/** @method defines CRUD and additional DB methods*/
	@Override
	protected void setCRUDMethods() throws SQLException {
		
		this.all = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("SELECT * FROM %s", this.getTableName()));
		
		this.get = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("SELECT * FROM %s WHERE id = ?", this.getTableName()));
		
		this.post = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("INSERT INTO %s(uuid, amount) VALUES(?, ?)", this.getTableName()));
		
		this.put = null;
		
		this.delete = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("DELETE FROM %s WHERE id = ?", this.getTableName()));
		
		
		this.getByUserId = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("SELECT * FROM %s WHERE id_user = ?", this.getTableName()));
		
		this.updateAmount = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("UPDATE %s SET amount = ? WHERE id = ?", this.getTableName()));
	}

	/** @return all account objects within an arrayList */
	public ArrayList<Account> all() throws SQLException {
		
		ArrayList<Account> accounts;
		
		// If prepared statement is defined
		if(this.all != null) {
			
			ResultSet result = this.getAll().executeQuery(); // Execute query
			
			accounts = new ArrayList<Account>();
			
			// For every record in the set...
			while(result.next()) {
				
				// Creates a new Account object
				accounts.add(new Account(result.getInt(1), result.getString(2), result.getDouble(3)));
			}
			
			// Returns account list
			return accounts;
		} else {
			
			// Returns an empty list
			accounts = new ArrayList<Account>();
			return accounts; 
		}
	}
	
	/** @return an Account object by its id */
	public Account get(int id) {
		
		Account account;
		
		// If prepared statement is defined
		if(this.get != null) {
				
			try {
				
				this.get.setInt(1, id); // Sets prepared query value
			
				ResultSet result = this.get.executeQuery(); // Executes query
				
				// If there is a record...
				if(result.next()) {
				
					// Generates a new Account object
					account = new Account(result.getInt(1), result.getString(2), 
							result.getDouble(3));
						
					return account; // Returns account.
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null; // No user found.
	}

	/** @return an account object belonging to given user id */
	public Account getByUserId(int id) {
		
		Account account;
		
		// If prepared statement is defined
		if(this.get != null) {
				
			try {
				
				this.getByUserId.setInt(1, id); // Sets prepared query value
			
				ResultSet result = this.getByUserId.executeQuery(); // Executes query
				
				// If there is a record...
				if(result.next()) {
				
					// Generates new account object
					account = new Account(result.getInt(1), result.getString(2), 
							result.getDouble(3));
						
					return account; // Returns it.
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null; // Returns nothing.
	}
	
	/** @returns true if account amount was correctly updated */
	public boolean updateAmount(int id, double amount) {
		
		// If prepared statement is defined
		if (updateAmount!= null) {
			
			try {
				
				// Sets prepared query id value
				this.updateAmount.setInt(2, id); 
				// Sets prepared query amount value
				this.updateAmount.setDouble(1, amount);
				// Executes query.
				this.updateAmount.executeUpdate();
				
				return true; // Updated ok.
			} catch (SQLException e) {

				e.printStackTrace();
			}			
		}
		
		return false; // updated not ok.
	}
}