/**
*	@file Exercise01.java
*	@author Sergio Romero Barra
*
*	Second exercise from Coritel Java Course.
*
*	This class reads data from the user and shows the product
*	of three integer numbers.
*/


package com.sergiorb.java_beca_coritel.welcome;

import java.util.Scanner;

public class Excercise01 {

	public static void main(String[] args) {
		
		// Vars declaration.
		int number1, number2, number3; // First and second number vars.
		int result; // Result var.
		
		// Scan object instanciation. This let us read from user input.
		Scanner scan = new Scanner(System.in);
		
		// Controls any general exception
		try {
			
			System.out.println("Introduce first integer number:");
			number1 = Integer.parseInt(scan.nextLine()); // Cast input string to int and stores in number1 var.
			System.out.printf("You entered: \"%,d\"\n", number1);
			
			System.out.println("Introduce second integer number:");
			number2 = Integer.parseInt(scan.nextLine()); // Cast input string to int and stores in number2 var.
			System.out.printf("You entered: \"%,d\"\n", number2);
			
			System.out.println("Introduce second integer number:");
			number3 = Integer.parseInt(scan.nextLine()); // Cast input string to int and stores in number3 var.
			System.out.printf("You entered: \"%,d\"\n", number3);
			
			result = number1 * number2 * number3; // Multiplies each number and store it on result.
			
			System.out.printf("The product of %,d, %,d and %,d is %,d\n", number1, number2, number3, result); 
			
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
