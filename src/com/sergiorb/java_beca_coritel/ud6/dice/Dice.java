/**
*	@file Dice.java
*	@author Sergio Romero Barra
*
*	Rolls a dice 6,000,000 times and stores 
*/

package com.sergiorb.java_beca_coritel.ud6.dice;

/** Main class **/
public class Dice {

	/** Returns a random dice result **/
	public static int rollDice() {
		
		int result;
		
		// Multiplies the Math.random result (0.0 to 1.0) with 6 (six sides)
		// and round it to the upper integer 
		result = (int) Math.ceil(Math.random() * 6);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		// Variables to hold face frecuency
		int side1, side2, side3, side4, side5, side6;
		side1 = 0;
		side2 = 0;
		side3 = 0;
		side4 = 0;
		side5 = 0;
		side6 = 0;
		
		// Roll the dice 6,000,000 times.
		for (int i = 0; i < 6000000; i++) {
			
			/// Calls rollDice and assign the result to the switch statement.
			// For every generated result, increment its variable by one.
			switch (rollDice()) {
			case 1:
				side1++;
				break;
			case 2:
				side2++;
				break;
			case 3:
				side3++;
				break;
			case 4:
				side4++;
				break;
			case 5:
				side5++;
				break;
			default:
				side6++;
				break;
			}
		}
		
		
		// Prints result
		System.out.printf("Side   Frecuency\n");
		System.out.printf("[1]:   %,d\n", side1);
		System.out.printf("[2]:   %,d\n", side2);
		System.out.printf("[3]:   %,d\n", side3);
		System.out.printf("[4]:   %,d\n", side4);
		System.out.printf("[5]:   %,d\n", side5);
		System.out.printf("[6]:   %,d\n", side6);
	}
}
