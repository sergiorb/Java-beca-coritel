/**
*	@file Addition.java
*	@author Sergio Romero Barra
*
*	Fourth example from Coritel Java Course.
*
*	This class reads data from the user and sums two numbers.
*/


package com.sergiorb.java_beca_coritel.welcome;

import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		
		// Vars declaration.
		int number1, number2; // First and second number vars.
		int result; // Store the sum result.
		
		// Scan object instanciation. This let us read from user input.
		Scanner scan = new Scanner(System.in);
		
		// Controls any general exception
		try {
			
			System.out.println("Introduce first number:");
			number1 = Integer.parseInt(scan.nextLine()); // Cast input string to int and stores in number1 var.
			System.out.printf("You entered: \"%d\"\n", number1);
			
			System.out.println("Introduce second number:");
			number2 = Integer.parseInt(scan.nextLine()); // Cast input string to int and stores in number2 var.
			System.out.printf("You entered: \"%d\"\n", number2);
			
			result = number1 + number2; // Sums number1 with number2
			
			System.out.printf("Addition result: %d\n", result); // Shows to user the result of the addition
			
		} catch (Exception e) {
			
			// In case of error, informs the user.
			System.out.println("There were an error reading your numbers.");
			System.out.print("Error: ");
			System.out.println(e);
			
		} finally {
			
			// In any case, we close the scanner object and inform the user.
			scan.close();
			System.out.println("Program exited.");
			
		} // end Try/Catch 
	} // end main method
} // end Addition class
