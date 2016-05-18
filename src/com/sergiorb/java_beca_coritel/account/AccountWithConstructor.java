/**
*	@file AccountWithConstructor.java
*	@author Sergio Romero Barra
*
*	Defines an Account class with constructor that store the account name.
*/

package com.sergiorb.java_beca_coritel.account;

// Main class
public class AccountWithConstructor {
	
	private String accountName; // private account name var
	
	
	// Default constructor
	public AccountWithConstructor() {
		this("Default account name");
	}

	// Constructor with account name param
	public AccountWithConstructor(String accountName) {
		
		this.accountName = accountName; // Sets account name in the object
	}

	// account name getter
	public String getAccountName() {
		return accountName;
	} // end account getter

	// account name setter
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	} // end account setter
	
}
