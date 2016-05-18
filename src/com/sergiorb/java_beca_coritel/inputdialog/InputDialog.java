/**
*	@file InputDialog.java
*	@author Sergio Romero Barra
*
*	Uses JOptionPane to show a input dialog box.
*/


package com.sergiorb.java_beca_coritel.inputdialog;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class InputDialog {
	
	// Main method
	public static void main(String[] args) {
		
		String name; // Stores name
		
		Scanner scan = new Scanner(System.in); // Instantiate scanner object
		
		System.out.println("What is your name?"); // Ask user for its name.
		name = scan.nextLine();
		scan.close(); // Close scan
		
		String message = String.format("Your name is %s", name); // Create and format the message.
		
		JOptionPane.showMessageDialog(null, message, "Your name panel", 2); // Shows in a dialog.
	}
}
