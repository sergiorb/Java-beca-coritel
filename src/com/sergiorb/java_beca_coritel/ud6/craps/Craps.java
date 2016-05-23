/**
*	@file Craps.java
*	@author Sergio Romero Barra
*
*	Implements Craps gambling game.
*/

package com.sergiorb.java_beca_coritel.ud6.craps;


/** Main class **/
public class Craps {
	
	/** Returns a random dice result **/
	public static int rollDice() {
		
		int result;
		
		// Multiplies the Math.random result (0.0 to 1.0) with 6 (six sides)
		// and round it to the upper integer 
		result = (int) Math.ceil(Math.random() * 6);
		
		return result;
	}

	/** Main method **/
	public static void main(String[] args) {
		
		// Program variables
		boolean firstThrow = true;
		boolean playerWins = false;
		boolean bankWins = false;
		int sum, playerNumber;
		playerNumber = 0;
		int loop = 0;
		
		while(true) {
			
			System.out.printf("\nLoop #%d --------------%s"
					+ "--------------------\n", loop, firstThrow?" first throw ":"");
			
			sum = rollDice() + rollDice(); // Rolls two dice and sums the results
			
			System.out.printf("Rolling dice... %d!!\n", sum);
			
			// If it's the first throw...
			if(firstThrow) {
				
				firstThrow = false; // No first throw anymore
				
				System.out.printf("Player number is %d\n", sum);
				
				// If the dices result is 7 or 11, player wins
				if(sum == 7 || sum == 11) {
					
					playerWins = true; // finish
					break; // Exits loop
					
				// If the dices result 2, 3 or 12, bank wins	
				} else if( sum == 2 || sum == 3 || sum == 12) {
					
					bankWins = true; // Finish
					break; // Exits loop
					
				// If any other number, continue with next throw
				} else {
					
					System.out.print("Nothing Happens\n");
				}
				
				playerNumber = sum; // Sets player number to check in the incoming throws
				
			// If it's not the first throw
			} else {
				
				// If the new number equals player first number, player wins
				if(sum == playerNumber) {
					
					playerWins = true;
					break;// Exits loop
				
				// If the new number equals 7, bank wins 
				} else if (sum == 7) {
					
					bankWins = true;
					break;// Exits loop
					
					// If any other number, continue with next throw
				} else {
					System.out.print("Nothing Happens\n");
				}
			}
			
			loop++;
		}
		
		// Prints who gain
		System.out.printf("Player %s\n", playerWins?"wins!!":"not wins");
		System.out.printf("Bank %s\n", bankWins?"wins!!":"not wins");

	}
}
