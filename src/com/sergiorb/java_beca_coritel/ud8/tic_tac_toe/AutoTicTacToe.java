/**
*	@file AutoRicTacToe.java
*	@author Sergio Romero Barra
*
*	Defines a TicTacToe game mode: AI Vs AI. 
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

/** Class */
public class AutoTicTacToe extends BaseTicTacToe {
	
	/** @constructor Main */
	public AutoTicTacToe() {
		super();
	}
	
	/*
	public AutoTicTacToe(int x, int y) {
		super(x, y);
	}
	
	public AutoTicTacToe(Grid grid) {
		super(grid);
	}*/

	
	@Override
	protected void gameEngine() {
		
		boolean win = false; // Stores if game is wined.
		int sentinel = 0; // Helps with player turns
		
		LowAI ia = new LowAI(); // Instantiates an AI object
		
		System.out.println("----------------------------------------------");
		System.out.println("\nAutoTicTacToe: an IA playing against itself.");
		
		// Game loop
		while(!this.grid.isGridFull() && !win) {
			
			// If turn is pair...
			if(sentinel%2 == 0) {
				ia.generateMove(grid, SquareState.CIRCLE);
			// If turn is odd...
			} else {
				ia.generateMove(grid, SquareState.CROSS);
			}
			
			win = this.grid.checkWinConditions(); // Checks win conditions
			sentinel++; // Increases sentinel.
		}
		
		this.printBoard();
		
		// Shows who wins.
		System.out.printf("\nWinned by %s\n", this.grid.getWinedBy() != null ? this.grid.getWinedBy():"No One");
	}
}
