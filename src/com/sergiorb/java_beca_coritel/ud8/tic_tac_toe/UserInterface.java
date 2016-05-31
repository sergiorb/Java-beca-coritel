/**
*	@file UserInterface.java
*	@author Sergio Romero Barra
*
*	Asks user which game type want to play.
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.util.Scanner;

/** Main class */
public class UserInterface {

	/** Main method */
	public static void main(String[] args) {
		
		// User input variables and objects.
		Scanner input = new Scanner(System.in);
		int option = -1;
		boolean sentinel = true;
		
		BaseTicTacToe game = null; // TicTacToe SuperClass definition.
		
		do { // Asks users which game wants to play.
			
			System.out.println("Select a game mode:");
			System.out.println("[1] Auto");
			System.out.println("[2] Player Vs IA");
			System.out.println("[3] Player Vs Player");
			System.out.println("[0] Exit");
			
			option = input.nextInt(); // Stores user input
			
			switch (option) {
			case 0: // Exits.
				System.out.println("Exiting...");
				sentinel = false;
				break;
			case 1: // Auto game.
				game = new AutoTicTacToe();
				game.gameEngine();
				sentinel = false;
				break;
			case 2: // Player Vs IA.
				game = new PlayerVsIaTicTacToe();
				game.gameEngine();
				sentinel = false;
				break;
			case 3: // Player Vs Player.
				game = new PlayerVsPlayerTicTacToe();
				game.gameEngine();
				sentinel = false;
				break;
			default: // No valid option.
				System.out.println("No valid option");
				break;
			}
	
		} while(sentinel);
		
		input.close(); // Close input object.
		
		System.out.println("Finished!");
	}
}
