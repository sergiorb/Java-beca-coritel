/**
*	@file DoWhile.java
*	@author Sergio Romero Barra
*
*	The application uses a do while loop to display 
*	the numbers from 1 through 10.
*/

package com.sergiorb.java_beca_coritel.dowhile;

// Main class
public class DoWhile {
	
	// Main method
	public static void main(String[] args) {
		
		int control = 1; // Control variable initialized to 1.
		
		System.out.println("Do While loop:");
		
		do {
			
			System.out.printf("%d ", control); // Prints number
			++control; // increase counter
			
		} while (control <= 10); // While control is smaller or equal to 10
	}
}