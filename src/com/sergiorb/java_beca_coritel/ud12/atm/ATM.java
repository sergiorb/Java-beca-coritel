package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.SQLException;

public class ATM {

	public static void main(String[] args) throws InstantiationException, 
	IllegalAccessException, ClassNotFoundException, SQLException {

		DB db = new DB("127.0.0.1", "bank", "root", "dai2", 0);
		
		db.Connect();
		
		UsersTable usersTable = new UsersTable(db, 0);
		AccountsTable accountTable = new AccountsTable(db, 0);
		
		for (User user : usersTable.all()) {
		
			System.out.format("ID: %s\n", user.getId());
			System.out.format("UUID: %s\n", user.getUuid());
			System.out.format("Name: %s\n", user.getName());
			System.out.format("Last name: %s\n\n", user.getLastName());
		}
		
		for (Account account : accountTable.all()) {
			
			System.out.format("ID: %s\n", account.getId());
			System.out.format("UUID: %s\n", account.getUuid());
			System.out.format("Amount: %+,.2f\n", account.getAmount());
		}
	}

}
