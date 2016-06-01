/**
*	@file PlayerVsIaTicTacToe.java
*	@author Sergio Romero Barra
*
*	Defines a TicTacToe game mode: Player Vs AI.
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.util.Scanner;

/** Class */
public class PlayerVsIaTicTacToe extends BaseTicTacToe {
	
	/** @constructor main */
	public PlayerVsIaTicTacToe() {
		super();
	}
	
	/** @constructor with AI */
	public PlayerVsIaTicTacToe(BaseAI ai) {
		super(ai);
	}
	
	/*
	public PlayerVsIaTicTacToe(int x, int y) {
		super(x, y);
	}
	
	public PlayerVsIaTicTacToe(Grid grid) {
		super(grid);
	}*/

	@Override
	protected void gameEngine() {
		
		boolean win = false; // Controls if game is wined or not.
		boolean added = false; // Stores when a new move has been done or not.
		
		int userOption = -1; // Stores user input.
		int askUser = -1; // Allows player to play in first place or not.
		int userRow, userColumn; // Stores user input for select position.
		
		Scanner input = new Scanner(System.in); // User input object.
		SquareState userState = SquareState.BLANK; // Default user state.
		SquareState iaState = SquareState.BLANK; // Default ia state.
		
		BaseAI ia = this.getAi(); // IA object.
		
		System.out.println("------------------------------------------");
		System.out.println("\nPlayer Vs IA: play against the computer.");
		
		System.out.println("Do you want to play first?");
		System.out.println("Choose Yes[1] or No[0]:");
		askUser = input.nextInt(); // Stores user decision.
		
		// While not correct option...
		while(userOption != 0 || userOption != 1){
			
			System.out.println("Choose O[0] or X[1]:");
			userOption = input.nextInt(); // Stores user input
			
			if(userOption == 0) {
				// If user wants circle...
				userState = SquareState.CIRCLE;
				iaState = SquareState.CROSS;
				break;
			} else if(userOption == 1) {
				// If user wants cross...
				userState = SquareState.CROSS;
				iaState = SquareState.CIRCLE;
				break;
			} else {
				System.out.println("Wrong option");
			}
		}
		
		// Gaming loop
		while(!this.grid.isGridFull() && !win) {
			
			this.printBoard(); // Prints current board state
			
			// If user play first...
			if(askUser == 1) {
			
				System.out.printf("Introduce row (1 - %d):\n", this.grid.getxMatrixLength());
				userRow = input.nextInt() -1;
				System.out.printf("Introduce column (1 - %d):\n", this.grid.getyMatrixLength());
				userColumn = input.nextInt() -1;
			
				added = this.grid.setSquareState(userRow, userColumn, userState);
				
				if(added == false) {
					System.out.printf("\nThat square  is not availabe.\n");
					continue;
				}
				
				askUser = 1; // Sets variable to enter the following turns
			} else {
				
				askUser = 1; // Sets variable to enter the following turns
			}
			
			// Checks if there is a win condition.
			win = this.grid.checkWinConditions();
			
			// If there is not a win condition
			if(!win) {
				
				// IA play a turn with its state (Cross or Circle)
				ia.generateMove(grid, iaState);
			}
			
			// Checks if there is a win condition after IA move
			win = this.grid.checkWinConditions();
		}
		
		input.close(); // Close user input
		
		this.printBoard();
		
		// Shows witch state win
		System.out.printf("\nWinned by %s\n", this.grid.getWinedBy() != null ? this.grid.getWinedBy():"No One");
	}

}
