/**
*	@file TestAccount.java
*	@author Sergio Romero Barra
*
*	Instanciate an Account and AccountWithConstructor object. First, calls 
*	AccountWithConstructor without param and then, with it. Secondly, retrieves Account 
*	object name, asks user to introduce a new one and finally, shows it.
*
*/

package com.sergiorb.java_beca_coritel.account_example;

import java.util.Scanner;

// Main test class for account classes
public class TestAccount {

	// Main method
	public static void main(String[] args) {
		
		// Instanciates two tyoes of account classes, one without constructor and other with it.
		Account account = new Account(); // account object without constructor
		AccountWithConstructor accountWithConstructor = new AccountWithConstructor(); // account object with constructor
		AccountWithConstructor accountWithConstructorWithParam = 
				new AccountWithConstructor("My personal account"); // Acount object with constructor and param
		
		System.out.printf("[accountWithConstructor] "
				+ "Initial name is: %s\n\n", accountWithConstructor.getAccountName());
		System.out.printf("[accountWithConstructorWithParam] "
				+ "Initial name is: %s\n\n", accountWithConstructorWithParam.getAccountName());
		
		System.out.printf("[account] Initial name is: %s\n\n", account.getAccountName());
		
		Scanner scan = new Scanner(System.in); // Scanner object instanciation
		
		// Try/Catch for getting data from user
		try {
			
			System.out.println("[account] Please, enter the name:");
			
			String accountName = scan.nextLine(); // reads course name from user
			
			account.setAccountName(accountName); // Sets account name in the account object
			
			System.out.println();
			
			System.out.printf("[account] Name in object acount is: \n%s\n\n", account.getAccountName());
			
		} catch (Exception e) { // If there was an error getting data from user...
			
			System.out.println("An error ocurred!. Existing...");
			
		} finally { // Executes always
			
			scan.close(); // Close scan stream object.
			System.out.println("Program finished!");
			
		}		
	}
}
