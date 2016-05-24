/**
*	@file DiceArray.java
*	@author Sergio Romero Barra
*
*	Rolls a dice 6,000,000 times and stores in an array.
*/

package com.sergiorb.java_beca_coritel.ud7.dicearray;

public class DiceArray {

	/** Returns a random dice result **/
	public static int rollDice() {

		int result;

		// Multiplies the Math.random result (0.0 to 1.0) with 6 (six sides)
		// and round it to the upper integer
		result = (int) Math.ceil(Math.random() * 6);

		return result;
	}

	public static void main(String[] args) {
		
		int[] sideResult = new int[6]; // Stores side frequency.
		int result; // Stores roll result.
		
		// Roll the dice 6,000,000 times.
		for (int i = 0; i < 6000000; i++) {

			// Calls rollDice (1-6) and assigns to result-1 position in the array.
			// If rollDice produce 4, it will increase the value in the third 
			// array position (4-1 = 3).
			result = rollDice();
			sideResult[result-1] += 1;
		}
		
		// Prints results from looping over the array.
		System.out.printf("Side   Frecuency\n");
		for (int i = 0; i < sideResult.length; i++) {
			
			System.out.printf("[%d]:   %,d\n",i+1, sideResult[i]);
		}
	}
}
