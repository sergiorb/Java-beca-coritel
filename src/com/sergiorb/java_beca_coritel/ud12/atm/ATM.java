package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.SQLException;
import java.util.Scanner;

public class ATM {
	
	public static final String name = "Virtual-ATM Company";
	private DB db;
	private UsersTable usersTable;
	private AccountsTable accountsTable;
	private User currentUser;
	private Account currentAccount;
	private Scanner input;
	
	public ATM() {
		
		try {
			
			this.db = new DB("127.0.0.1", "bank", "root", "dai2", 0);
			this.db.connect();
			this.usersTable = new UsersTable(db, 0);
			this.accountsTable = new AccountsTable(db, 0);
			
			input = new Scanner(System.in);
			
		} catch (InstantiationException | IllegalAccessException | 
				ClassNotFoundException | SQLException e) {
			
			try {
				
				this.db.disconnect();
				
			} catch (SQLException e1) {

				e1.printStackTrace();
			} finally {
				
				input.close();
			}
			
			e.printStackTrace();
		}
	}

	
	private void displayUsers() {
		
		for (User user : this.usersTable.all()) {
			
			String message = String.format("[%d]: %s %s\n", 
					user.getId(), user.getName(), user.getLastName());
			
			System.out.format(message);
		}	
	}
	
	private User getCurrentUser() {
		return currentUser;
	}
	
	private void setCurrentUserById(int id) {
		
		this.currentUser = this.usersTable.get(id);
	}
	
	private Account getCurentAccount() {
		return currentAccount;
	}
	
	private void setCurrentAccount(int id) {
		this.currentAccount = this.accountsTable.get(id);
	}
	
	private void displayBalance() {
	
		String message = String.format("Your current balance is: %+,.2f\n\n", 
				this.getCurentAccount().getAmount());
		System.out.print(message);
	}
	
	private void usersDialog() {
		
		String message = String.format("Please, select your name to login:\n");
		System.out.print(message);
		this.displayUsers();
		
		int id = input.nextInt();
		
		this.setCurrentUserById(id);
		this.setCurrentAccount(this.getCurrentUser().getId());
	}
	
	private void operationsDialog() {
		
		boolean sentinel = true;
		
		String message = String.format("Welcome back Mr./Mrs. %s\n", 
				this.getCurrentUser().getLastName());
		
		System.out.print(message);
				
		do {
			
			System.out.print(String.format("[1]: Show account balance.\n"));
			System.out.print(String.format("[2]: Withdraw cash.\n"));
			System.out.print(String.format("[3]: Deposit cash.\n"));
			System.out.print(String.format("[0]: Exit.\n"));
			
			int operation = input.nextInt();
			
			switch (operation) {
			case 1:
				this.displayBalance();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 0:
				sentinel = false;
				break;
			default:
				System.out.println("Unknow option");
				break;
			}
		} while(sentinel);
	}
	
	public void start() {
		
		String message = String.format("Welcome to %s\n\n", ATM.name);
		System.out.print(message);
		
		this.usersDialog();
		this.operationsDialog();
	}
	
	/*
	public static void main(String[] args) throws InstantiationException, 
	IllegalAccessException, ClassNotFoundException, SQLException {

		
		for (User user : usersTable.all()) {
		
			System.out.format("ID: %s\n", user.getId());
			System.out.format("UUID: %s\n", user.getUuid());
			System.out.format("Name: %s\n", user.getName());
			System.out.format("Last name: %s\n\n", user.getLastName());
		}
		
		User user = usersTable.get(2);
		
		System.out.format("ID: %s\n", user.getId());
		System.out.format("UUID: %s\n", user.getUuid());
		System.out.format("Name: %s\n", user.getName());
		System.out.format("Last name: %s\n\n", user.getLastName());
		
		
		for (Account account : accountTable.all()) {
			
			System.out.format("ID: %s\n", account.getId());
			System.out.format("UUID: %s\n", account.getUuid());
			System.out.format("Amount: %+,.2f\n\n", account.getAmount());
		}
		
		Account account = accountTable.get(2);
		
		System.out.format("ID: %s\n", account.getId());
		System.out.format("UUID: %s\n", account.getUuid());
		System.out.format("Amount: %+,.2f\n\n", account.getAmount());
	
		accountTable.updateAmount(account.getId(), account.getAmount() - 1500.0);
		
		account = accountTable.get(2);
		
		System.out.format("ID: %s\n", account.getId());
		System.out.format("UUID: %s\n", account.getUuid());
		System.out.format("Amount: %+,.2f\n\n", account.getAmount());
		
		db.disconnect();
	}*/

}
