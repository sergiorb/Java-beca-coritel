/**
*	@file Calculate.java
*	@author Sergio Romero Barra
*
*	Sum while.
*/

package com.sergiorb.java_beca_coritel.calculate;

// Main class
public class Calculate {

	// Main method
	public static void main(String[] args) {
		
		int result = 0; // Stores sum.
		int control = 0; // Controls the number of loops 
		
		while(control <= 10) {
			
			result += control; // result = result + control;
			
			control++; // Increments 
		}

		// Shows result
		System.out.format("The result is: %d", result);
	}

}
