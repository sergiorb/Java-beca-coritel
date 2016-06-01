/**
*	@file PlayerVsPlayerTicTacToe.java
*	@author Sergio Romero Barra
*
*	Defines a TicTacToe game mode: Player Vs Player. 
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.util.Scanner;

/** Class */
public class PlayerVsPlayerTicTacToe extends BaseTicTacToe {
	
	/** @constructor Main */
	public PlayerVsPlayerTicTacToe() {
		super();
	}
	
	/** @constructor with AI */
	public PlayerVsPlayerTicTacToe(BaseAI ai) {
		super(ai);
	}
	
	/*
	public PlayerVsPlayerTicTacToe(int x, int y) {
		super(x, y);
	}
	
	public PlayerVsPlayerTicTacToe(Grid grid) {
		super(grid);
	}*/

	@Override
	protected void gameEngine() {
		
		boolean win = false; // Stores if game is wined.
		boolean added = false; // Stores if last move were added.
		
		int userRow, userColumn; // Stores user input.
		int sentinel = 0; // Helps with player turns
		
		Scanner input = new Scanner(System.in); // Input object.
		SquareState squareState = SquareState.BLANK; // Default state
		
		// While grid is not full and game not wined...
		while(!this.grid.isGridFull() && !win) {
			
			this.printBoard();
			
			// If sentinel is pair, player 1 turn
			if(sentinel%2 == 0) {
				
				System.out.printf("Player one turn:\n");
				squareState = SquareState.CROSS;
				
			// If sentinel is odd, player 2 turn
			} else {
				
				System.out.printf("Player two turn:\n");
				squareState = SquareState.CIRCLE;
			}
			
			// Asks user row and column.
			System.out.printf("Introduce row (1 - %d):\n", this.grid.getxMatrixLength());
			userRow = input.nextInt() -1;
			System.out.printf("Introduce column (1 - %d):\n", this.grid.getyMatrixLength());
			userColumn = input.nextInt() -1;
			
			// Try to add new move to grid.
			added = this.grid.setSquareState(userRow, userColumn, squareState);
			
			// If it can't be added
			if(added == false) {
				
				// Informs user and ask again.
				System.out.printf("\nThat square  is not availabe.\n");
				continue;
			}
			
			// Checks win conditions.
			win = this.grid.checkWinConditions();
			
			// Increments sentinel to let next player play.
			sentinel++;
		}
		
		input.close(); // Close input object
		
		this.printBoard();
		
		// Shows who wins
		System.out.printf("\nWinned by %s\n", this.grid.getWinedBy() != null ? this.grid.getWinedBy():"No One");
	}

}
