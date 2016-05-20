/**
*	@file ForCounter.java
*	@author Sergio Romero Barra
*
*	The application uses a for to display 
*	the numbers from 1 through 10.
*/

package com.sergiorb.java_beca_coritel.forcounter;

// Main class
class ForCounter {

	// Main method
	public static void main(String[] args) {
		
		System.out.println("For counter:");
		
		// From 1 to 10, prints x
		for(int x = 1; x <= 10; x++) {
			System.out.printf("%d ", x);
		}
	}
}
