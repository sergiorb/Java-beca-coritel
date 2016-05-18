/**
*	@file Test.java
*	@author Sergio Romero Barra
*
*	Tests Account class, adding and subtracting money from accounts.
*	
*	TODO: Refactor with input function and loops.
*/

package com.sergiorb.java_beca_coritel.account;

import java.util.Scanner;

// Main class
public class Test {

	public static void main(String[] args) {
		
		String[] operations = new String[2]; // Stores the operations you can perform
		
		// Operations
		operations[0] = "Add money";
		operations[1] = "Subtract money";
		
		Account[] accounts = new Account[2]; // Stores account objects
		
		// Creates two accounts...
		Account account00 = new Account();
		Account account01 = new Account();
		
		// ... and adds it to its array
		accounts[0] = account00;
		accounts[1] = account01;
		
		System.out.printf("%s account has a "
				+ "balance of %+,.2f€\n", account00.getName(), account00.getBalance());
		
		account00.setName("Groceries"); // Set the name account
		account00.addMoney(-245.45); // Try to add a negative quantity. Forbidden.
		account00.addMoney(1800.499); // Adds a valid quantity.
		account00.subtractMoney(2000); // Try to subtract more money than the account has.
		account00.subtractMoney(500.789); // Subtracts a valid quantity.
		
		System.out.printf("%s account has a "
				+ "balance of %+,.2f€\n", account00.getName(), account00.getBalance());
		
		System.out.println("---------------------------------------------------------");
		
		System.out.printf("%s account has a "
				+ "balance of %+,.2f€\n", account01.getName(), account01.getBalance());
		
		// Same procedure for account01
		account01.setName("House");
		account01.addMoney(145.45);
		account01.addMoney(20.499);
		account01.subtractMoney(400);
		account01.subtractMoney(10);
		
		System.out.printf("%s account has a "
				+ "balance of %+,.2f€\n", account01.getName(), account01.getBalance());
		
		System.out.println("---------------------------------------------------------");
		
		Scanner scanner = new Scanner(System.in); // Object instance to read input
		
		// Try/catch to control any error in user data input
		try {
			
			System.out.println("Introduce witch account you want to work with:");
			int controlAccount = 0; // stores loop number
			
			// Iterate over accounts array to let user select witch account he want to
			// work with
			for (Account account : accounts) {
				System.out.printf("[%d] %s\n", controlAccount, account.getName());
				controlAccount++;
			}
			
			int accountNumber = scanner.nextInt(); // Stores account number position
			
			if(accountNumber < accounts.length) { // If account number exists...
				
				System.out.printf("Introduce witch operation you want to "
						+ "perform on %s account: \n", accounts[accountNumber].getName());
				int controlOperations = 0; // stores loop number
				
				// Iterate over operations array to let user select witch operation he want to
				// perform
				for (String operation : operations) {
					System.out.printf("[%s] %s\n", controlOperations, operation);
					controlOperations++;
				}
				
				int operationNumber = scanner.nextInt(); // Stores operation number
				
				double quantity; // Stores operation quantity
				
				if(operationNumber == 0) { // If add money...
					
					System.out.println("Introduce the money quantity you want to add:");
					quantity = scanner.nextDouble();
					
					accounts[accountNumber].addMoney(quantity); // Adds money to current selected account
					accounts[accountNumber].printStatus(); // Prints account status
					
				} else if (operationNumber == 1) {
					
					System.out.println("Introduce the money quantity you want to subtract:");
					quantity = scanner.nextDouble();
					
					accounts[accountNumber].subtractMoney(quantity); // Adds money to current selected account
					accounts[accountNumber].printStatus(); // Prints account status
				
				} else { // If entered an invalid operation number...
					
					System.out.printf("There is no #%s operation.\n", operationNumber);
				}
				
			} else { // If entered an invalid account number...
				
				System.out.printf("There is no #%s account.\n", accountNumber);
			}
			
		} catch (Exception e) { // If there is any error...
			
			System.out.println("An error ocurred!. Existing...");
			System.out.println(e);
			
		} finally { // Always..
			
			scanner.close(); // Close scanner stream object.
			System.out.println("Program finished!");
		}

	}

}
