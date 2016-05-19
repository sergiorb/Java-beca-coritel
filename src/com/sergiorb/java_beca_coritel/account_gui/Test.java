/**
*	@file Test.java
*	@author Sergio Romero Barra
*
*	Tests Account class, adding and subtracting money from accounts with GUI
*	
*	TODO: Refactor with input function and loops.
*/

package com.sergiorb.java_beca_coritel.account_gui;

import javax.swing.JOptionPane;

// Main class
public class Test {
	
	// Main method
	public static void main(String[] args) {
		
		// Instance variables
		String appName = "JavaATM"; // App name.
		String message; // message to inform user.
		String accountName; // Stores user account name.
		double gift = 850.0; // Value of JavaATM special promotion.
		double amount = 0.0; // Stores money amount to work with.
		int operationNumber; // Stores operation selection
		boolean control = true; // While loop conditional
		Account account; // Defines an Account class variable.
		
		// In case of error...
		try {
		
			while(control){
				
				message = String.format("Welcome to %s", appName); // Create and format the message.
				JOptionPane.showMessageDialog(null, message, appName, 1); // Shows in a dialog.
				
				message = String.format("Lets create a new account! What is the account name?");
				accountName = JOptionPane.showInputDialog(message, 3); // Stores account name 
				
				// If user NOT enters a name and it is NOT greater that 0 chars...
				if(accountName == null || accountName.length() == 0) {
					message = String.format("You should set a name to create an account...", appName); // Create and format the message.
					JOptionPane.showMessageDialog(null, message, appName, 2); // Shows in a dialog.
					break; // Exits main while. Program finished.
				}
				
				// Creates a new account with user account name
				account = new Account(accountName);
				
				message = String.format("We have a special promotion; " // Create and format the message.
						+ "any new account is gifted with %+,.2f \nCongratulations!",  gift); 
				JOptionPane.showMessageDialog(null, message, appName, 1);
				
				account.addMoney(gift); // Adds gift to user account
				account.printStatus(); // Show through console user account status
	
				do { // Executes first time always
					
					message = String.format("Which operation do you want to "
							+ "perform on your account?\n[0] Add money\n[1] Subtract money\n[2] Check balance\n[3] Exit");
					
					operationNumber = Integer.parseInt(JOptionPane.showInputDialog(message)); // Stores operation option
					
					if(operationNumber == 0) { // If user want to add money
						
						message = String.format("What ammount of money do you want to add?");
						amount = Double.parseDouble(JOptionPane.showInputDialog(message));
						account.addMoney(amount); // Adds money to user account
						
						// Shows to user its account balance
						message = String.format("Your account balance is: %+.2f€", account.getBalance()); 
						JOptionPane.showMessageDialog(null, message, appName, 1);
						
					} else if (operationNumber == 1) { // If user want to subtract money
						
						message = String.format("What ammount of money do you want to subtract?");
						amount = Double.parseDouble(JOptionPane.showInputDialog(message));
						account.subtractMoney(amount); // Subtracts money from the user account
						
						// Shows to user its account balance
						message = String.format("Your account balance is: %+.2f€", account.getBalance()); 
						JOptionPane.showMessageDialog(null, message, appName, 1);
	
					} else if (operationNumber == 2) { // If user want to check balance
						
						message = String.format("Your account balance is: %+.2f€", account.getBalance()); 
						JOptionPane.showMessageDialog(null, message, appName, 1);
				
					} else if (operationNumber == 3) { // If user want to exits

						// Sets main while to false.
						control = false;
						
					} else { // If user enter an invalid option
						
						message = String.format("Invalid option!"); 
						JOptionPane.showMessageDialog(null, message, appName, 2);
						
					}
				} while(operationNumber !=3); // If option is not "Exit", ask again.
			}
		} catch(Exception e) { // In case of any error
			
			message = String.format("There were an error in the program!!");
			JOptionPane.showMessageDialog(null, message, appName, 2); // Shows in a dialog.
			
		} finally { // Always inform that program is finished
			
			message = String.format("%s finished!", appName); // Create and format the message.
			JOptionPane.showMessageDialog(null, message, appName, 2); // Shows in a dialog.
			
		}
	}
}
