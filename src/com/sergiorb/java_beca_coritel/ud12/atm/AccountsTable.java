/**
 * 
 * @file AccountsTable.java
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** Main class */
public class AccountsTable extends Table {
	
	private final String tableName = "accounts"; // DB Table name
	private PreparedStatement updateAmount;

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
		
		this.updateAmount = this.getDatabaseConnection().getConnection().prepareStatement(
				String.format("UPDATE %s SET amount = ? WHERE id = ?", this.getTableName()));
	}
	
	public ArrayList<Account> all() throws SQLException {
		
		ArrayList<Account> accounts;
		
		if(this.all != null) {
			
			ResultSet result = this.getAll().executeQuery();
			
			accounts = new ArrayList<Account>();
			
			while(result.next()) {
				accounts.add(new Account(result.getInt(1), result.getString(2), result.getDouble(3)));
			}
			
			return accounts;
		} else {
			
			accounts = new ArrayList<Account>();
			return accounts; 
		}
	}
	
	public Account get(int id) {
		
		Account account;
			
		if(this.get != null) {
				
			try {
				
				this.getGet().setInt(1, id);
			
				ResultSet result = this.getGet().executeQuery();
				
				if(result.next()) {
				
					account = new Account(result.getInt(1), result.getString(2), 
							result.getDouble(3));
						
					return account;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public boolean updateAmount(int id, double amount) throws SQLException {
		
		if (updateAmount!= null) {
			
			this.updateAmount.setInt(2, id);
			this.updateAmount.setDouble(1, amount);
			this.updateAmount.executeUpdate();
			System.out.println(this.updateAmount.toString());

			return true;
		}
		
		return false;
	}
}