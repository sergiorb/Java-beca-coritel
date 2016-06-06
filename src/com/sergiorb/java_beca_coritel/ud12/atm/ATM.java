package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.SQLException;
import java.util.Scanner;

public class ATM {
	
	public static final String name = "Virtual-ATM Company"; // ATM name.
	private DB db; // DataBase object.
	private UsersTable usersTable; // Users Table object.
	private AccountsTable accountsTable; // Accounts Table object.
	private User currentUser; // Current user;
	private Account currentAccount; // Current user's account.
	private Scanner input; // Input object.
	private double cashPerDay; // Everyday atm cash available.
	private double remainingcash; // Stores atm current cash.
	
	/** @constructor main */
	public ATM() {
		
		try {
			
			// Instantiate a new DB object. These params should not be here...
			this.db = new DB("127.0.0.1", "bank", "root", "12345", 0);
			this.db.connect();
			
			// Instantiates Tables with db object.
			this.usersTable = new UsersTable(db, 0);
			this.accountsTable = new AccountsTable(db, 0);
			
			// Scanner for user input
			this.input = new Scanner(System.in);
			
			// ATM values
			this.setCashPerDay(500.0);
			this.setRemainingcash(this.getCashPerDay());
			
		} catch (InstantiationException | IllegalAccessException | 
				ClassNotFoundException | SQLException e) {
					
			this.db.disconnect();	
			this.input.close();
				
			e.printStackTrace();
		}
	}
	
	/** Shows user list */
	private void displayUsers() {
		
		// Calls userTable all method and prints result
		for (User user : this.usersTable.all()) {
			
			String message = String.format("[%d]: %s %s\n", 
					user.getId(), user.getName(), user.getLastName());
			
			System.out.format(message);
		}	
	}
	
	/** @return currentUser */
	private User getCurrentUser() {
		return currentUser;
	}
	
	/** @param sets currentUser */
	private void setCurrentUserById(int id) {
		
		this.currentUser = this.usersTable.get(id);
	}
	
	/** @return currentAccount */
	private Account getCurentAccount() {
		return currentAccount;
	}
	
	/** @param sets currentAccount by user id */
	private void setCurrentAccountByUserId(int id) {
		this.currentAccount = this.accountsTable.getByUserId(id);
	}
	
	/** @return the cashPerDay */
	private double getCashPerDay() {
		return cashPerDay;
	}

	/** @return the remainingcash */
	private double getRemainingcash() {
		return remainingcash;
	}

	/** @param remainingcash the remainingcash to set */
	private void setRemainingcash(double remainingcash) {
		this.remainingcash = remainingcash;
	}

	/** @param cashPerDay the cashPerDay to set */
	private void setCashPerDay(double cashPerDay) {
		this.cashPerDay = cashPerDay;
	}

	/** @method update current user/account data */
	private void loadCurrentData(int id) {
		
		this.setCurrentUserById(id);
		this.setCurrentAccountByUserId(this.getCurrentUser().getId());
	}
	
	/** @method checks given amount number validity */
	private boolean checkWithdrawAmount(double amount) {
		
		String message = "";
		
		// If it is a positive number 
		if(amount > 0.0) {
			// And there is enough money in the account
			if(amount <= this.getCurentAccount().getAmount()) {
				// And ATM has enough money
				if(this.getRemainingcash() >= amount) {
					// And it can be splited in $20 bills
					if(amount%20.0 == 0) {
						
						return true; // Value is ok.
					} else {
						message = String.format("Only $20 bills.");
					}
					
				} else {
					message = String.format("This ATM has not enough cash");
				}
			} else {
				message = String.format("You have not enough funds in your account");
			}			
		} else {
			message = String.format("Introduce a positive number");
		}

		System.out.println(message);
		return false; // Value not ok.
	}
	
	/** @method shows currentAccount total amount */
	private void displayBalance() {
	
		String message = String.format("Your current balance is: %+,.2f\n\n", 
				this.getCurentAccount().getAmount());
		System.out.print(message);
	}
	
	/** @return withdraw given amount from current account */
	private boolean withdraw(double amount) {
				
		// If value it is ok...
		if(checkWithdrawAmount(amount)) {
					
			// Round value to two decimals.
			amount = Math.round(amount * 100.0) / 100.0; // Rounds to two decimals
				
			// Calls accounts table update amount (balance) method.
			this.accountsTable.updateAmount(this.getCurentAccount().getId(), 
					this.getCurentAccount().getAmount() - amount);
			
			// Updates ATM cash
			this.setRemainingcash(this.getCashPerDay() - amount);
			
			return true; // Task executed.
		}
		
		return false; // Task not executed.
	}
	
	/** @boolean deposit given amount to current account */
	private boolean deposit(double amount) {
		
		String message;
		
		// Id amount is a positive number
		if(amount > 0.0) {
				
			System.out.println("Depositing...");
			
			// Round amount.
			amount = Math.round(amount * 100.0) / 100.0; // Rounds to two decimals
			
			// Calls account table update amount method.
			this.accountsTable.updateAmount(this.getCurentAccount().getId(), 
					this.getCurentAccount().getAmount() + amount);
			
			return true; // Task executed.
			
		} else {
			message = String.format("Introduce a positive number");
		}
		
		System.out.println(message);
		return false; // Task not executed.
	}
	
	/** @method Shows user withdraw dialog */
	private void withdrawDialog() {
						
		double amount;
		
		String message = String.format("Which amount do you want withdraw?\n");
		System.out.print(message);
			
		try {
			amount = input.nextDouble();
		} catch(Exception e) {
			input.next();
			amount = -1.0;
		}
							
		if(this.withdraw(amount)) {
			this.loadCurrentData(this.getCurrentUser().getId());
		}
	}
	
	/** @method Shows user deposit dialog */
	private void depositDialog() {
				
		double amount;
			
		String message = String.format("Which amount do you want deposit?\n");
		System.out.print(message);
		
		try {
			amount = input.nextDouble();
		} catch(Exception e) {
			input.next();
			amount = -1.0;
		}
			
		// If tasks is executed, updates current data-
		if(this.deposit(amount)) {
			this.loadCurrentData(this.getCurrentUser().getId());
		}
	}

	/** @method Shows user users dialog */
	private void usersDialog() {
		
		// Dummy login method. Shows user a list of all bank users.
		String message = String.format("Please, select your name to login:\n");
		System.out.print(message);
		
		this.displayUsers(); // Shows a list of user.
		
		int id = input.nextInt(); // Get user id
		
		loadCurrentData(id); // Load from database the selected user and its account.
	}
	
	/** @method Shows user available operations dialog */
	private void operationsDialog() {
		
		boolean sentinel = true;
		
		String message = String.format("Welcome back Mr./Mrs. %s:\n", 
				this.getCurrentUser().getLastName());
		
		System.out.print(message);
				
		int operation; // Stores user operation selection.
		
		do {
			
			// Shows options
			System.out.print(String.format("[1]: Show account balance.\n"));
			System.out.print(String.format("[2]: Withdraw cash.\n"));
			System.out.print(String.format("[3]: Deposit cash.\n"));
			System.out.print(String.format("[0]: Exit.\n"));
			
			// Gets user selection
			try {
				operation = input.nextInt();
			} catch(Exception e) {
				input.next();
				operation = -1;
			}
			
			switch (operation) {
			case 1: // Calls show balance method.
				this.displayBalance(); 
				break;
			case 2: // Calls withdraw dialog.
				this.withdrawDialog(); 
				break;
			case 3:// Calls deposit dialog.
				this.depositDialog(); 
				break;
			case 0: // Exits program.
				System.out.println("Finished program!");
				sentinel = false;
				break;
			default: // Unkow option.
				System.out.println("Unknow option");
				break;
			}
		} while(sentinel);
	}
	
	/** @method Shows ATM name and start program */
	public void start() {
		
		String message = String.format("Welcome to %s\n\n", ATM.name);
		System.out.print(message);
		
		this.usersDialog();
		this.operationsDialog();
		
		this.input.close();
		this.db.disconnect();
	}
}
