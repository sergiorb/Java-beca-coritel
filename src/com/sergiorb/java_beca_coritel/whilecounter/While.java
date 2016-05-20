/**
*	@file While.java
*	@author Sergio Romero Barra
*
*	The application uses a while loop to display 
*	the numbers from 1 through 10.
*/

package com.sergiorb.java_beca_coritel.whilecounter;

// Main class
public class While {
	
	// Main method
	public static void main(String[] args) {
		
		int control = 1; // Control variable initialized to 1.
		
		System.out.println("While loop:");
		
		while (control <= 10) { // While control is smaller or equal to 10
			
			System.out.printf("%d ", control); // Prints number
			++control; // increase counter
		}

	}

}
