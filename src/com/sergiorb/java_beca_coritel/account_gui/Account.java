/**
*	@file Account.java
*	@author Sergio Romero Barra
*
*	Defines an Account class that store the account name and
*	its balance. You can set the account name, add money, subtract it
*	and print its status.
*/

package com.sergiorb.java_beca_coritel.account_gui;

// Main class
public class Account {
	
	private String name; // private account name var
	private double balance; // Stores account money

	// Default constructor
	public Account() {
		this.name = null;
		this.balance = 0.0;
	}

	// Constructor with name param
	public Account(String name) {
		this.name = name;
	}

	// name getter
	public String getName() {
		return name;
	} // end getter

	// name setter
	public void setName(String name) {
		this.name = name;
	} // end setter
	
	// balance getter
	public double getBalance() {
		return balance;
	} // end getter
	
	// Adds desired quantity to the account balance If quantity
	// is greater than 0.0€ and returns true.
	public boolean addMoney(double quantity) {
		
		if(quantity > 0.0) {
			
			this.balance += quantity;
			return true;
		} else {
			
			System.out.printf("You have to add a value greater than 0.0€!!!\n");
			return false;
		}
	} // end addMoney
	
	// Subtracts desired quantity from account balance, if 
	// the value is greater than 0.0€
	// Returns true if OK, return false if NOT.
	public boolean subtractMoney(double quantity) {
		
		if (quantity > 0.0) {
				
			this.balance -= quantity;
			return true;
		} else {
				
			System.out.printf("You have to add a value greater than 0.0€!!!\n");
			return false;
		}
	} // end subtractMoney
	
	// Prints the account status. Name and balance.
	public void printStatus() {
		System.out.printf("%s account has a "
				+ "balance of %+,.2f€\n", getName(), getBalance());
	} // end printStatus
}
