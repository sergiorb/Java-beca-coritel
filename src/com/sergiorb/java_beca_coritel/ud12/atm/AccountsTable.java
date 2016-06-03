/**
 * 
 * @file AccountsTable.java
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** Main class */
public class AccountsTable extends Table {
	
	private final String tableName = "accounts"; // DB Table name

	/** @throws SQLException 
	 * @constructor Main */
	public AccountsTable(DB db) throws SQLException {
		super(db);
		this.setCRUDMethods();
	}
	
	/** @throws SQLException 
	 * @constructor with verbose */
	public AccountsTable(DB db, int verboseLevel) throws SQLException {
		super(db, verboseLevel);
		this.setCRUDMethods();
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
	}
	
	public ArrayList<Account> all() throws SQLException {
		
		ResultSet result = this.getAll().executeQuery();
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		while(result.next()) {
			accounts.add(new Account(result.getInt(1), result.getString(2), result.getDouble(3)));
		}
		
		return accounts; 
	}
}