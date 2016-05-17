/**
*	@file Exercise00.java
*	@author Sergio Romero Barra
*
*	First exercise from Coritel Java Course.
*
*	This class reads data from the user and compares them.
*	Shows if they are grater, equal or lesser than the other.
*/


package com.sergiorb.java_beca_coritel.welcome;

import java.util.Scanner;

public class Excercise00 {

	public static void main(String[] args) {
		
		// Vars declaration.
		int number1, number2; // First and second number vars.
		
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
			
			// Compares if number1 is greater, equal or lesser than number2.
			if(number1 > number2) {
				System.out.printf("%d greater than %d\n", number1, number2);
			} else if (number1 == number2) {
				System.out.printf("%d is equal to %d\n", number1, number2);
			} else {
				System.out.printf("%d is lesser than %d\n", number1, number2);
			}
			
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
