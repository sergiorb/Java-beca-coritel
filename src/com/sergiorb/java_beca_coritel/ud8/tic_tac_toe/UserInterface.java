package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int option = -1;
		boolean sentinel = true;
		BaseTicTacToe game = null;
		
		do {
			
			System.out.println("Select a game mode:");
			System.out.println("[1] Auto");
			System.out.println("[2] Player Vs IA");
			System.out.println("[3] Player Vs Player");
			System.out.println("[0] Exit");
			
			option = input.nextInt();
			
			switch (option) {
			case 0:
				System.out.println("Exiting...");
				sentinel = false;
				break;
			case 1:
				game = new AutoTicTacToe();
				game.gameEngine();
				sentinel = false;
				break;
			case 2:
				game = new PlayerVsIaTicTacToe();
				game.gameEngine();
				sentinel = false;
				break;
			case 3:
				game = new PlayerVsPlayerTicTacToe();
				game.gameEngine();
				sentinel = false;
				break;
			default:
				System.out.println("No valid option");
				break;
			}
	
		} while(sentinel);
		
		input.close();
		
		
		
		System.out.println("Finished!");
	}
}
