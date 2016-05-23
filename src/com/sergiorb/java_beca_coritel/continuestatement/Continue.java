/**
*	@file Continue.java
*	@author Sergio Romero Barra
*
*	Shows "continue" statement usage.
*/

package com.sergiorb.java_beca_coritel.continuestatement;

/** Main class **/
public class Continue {

	/** Main method **/
	public static void main(String[] args) {
		
		// Loop from 1 to 10
		for (int i = 1; i <= 10; i++) {
			
			// If equals 5, continue
			if(i == 5) {
				// Doesn't execute remaining code and goes directly to the next iteration.
				continue; 
			}
			
			System.out.printf("%d ", i); // Print loop value
		}

	}

}
