/**
*	@file Sum.java
*	@author Sergio Romero Barra
*
*	The application sums even values from
*	2 to 20 and shows the sum.
*/

package com.sergiorb.java_beca_coritel.sum;

// Main class
public class Sum {
	
	// Main method
	public static void main(String[] args) {
		
		int sum = 0; // stores sum
		
		// From 2 to 20...
		for(int x = 2; x <= 20; x++) {
			
			// If x is even (because it's remainder equals to 0)
			if(x%2 == 0) {
				
				sum += x; // Sums x to sum variable.
			}
		}
		
		// Prints sum result
		System.out.printf("Sum is %d\n",  sum);
	}
}
