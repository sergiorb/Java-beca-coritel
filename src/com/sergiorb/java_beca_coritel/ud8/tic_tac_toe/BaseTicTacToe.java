/**
*	@file BaseTicTacToe.java
*	@author Sergio Romero Barra
*
*	Defines a basic TicTacToe game.
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.security.InvalidParameterException;

/** Class */
public abstract class BaseTicTacToe {

	// Class Variables
	protected Grid grid; // Stores a grid to play
	protected int winNumber; // Stores the consecutive number of X or O to win.
	protected BaseAI ai;
	
	/** @constructor Main */
	public BaseTicTacToe() {
		//this.setGrid(new Grid(3,3));
		this.setGrid(new Grid());
		this.setWinNumber(3);
		this.setAi(new LowAI());
	}
	
	/** @constructor with AI*/
	public BaseTicTacToe(BaseAI ai) {
		//this.setGrid(new Grid(3,3));
		this.setGrid(new Grid());
		this.setWinNumber(3);
		this.setAi(ai);
	}
	
	/*
	public BaseTicTacToe(int x, int y) {
		
		if (x < 2 || y < 2) {
			String message = String.format("Rows and Columns have to be 2 length at least\n");
			throw new InvalidParameterException(message);
		}
		
		this.setGrid(new Grid(x, y));
		this.setWinNumber(3);
	}
	
	public BaseTicTacToe(Grid grid) {
		this.setGrid(grid);
		this.setWinNumber(3);
	}*/

	/** @return the grid */
	private Grid getGrid() {
		return grid;
	}

	/** @param grid the grid to set */
	private void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	/** @return the winNumber */
	protected int getWinNumber() {
		return winNumber;
	}

	/** @param winNumber the winNumber to set  */
	private void setWinNumber(int winNumber) {
		
		// Checks that winNumber is smaller or equal to grid X/Y axis.
		if(winNumber <= this.getGrid().getxMatrixLength()) {
			if (winNumber <= this.getGrid().getyMatrixLength()) {
				this.winNumber = winNumber;
			} else {
				throw new InvalidParameterException();
			}	
		} else {
			throw new InvalidParameterException();
		}
	}
	
	/** @return the ai */
	protected BaseAI getAi() {
		return ai;
	}

	/** @param ai the ai to set */
	protected void setAi(BaseAI ai) {
		this.ai = ai;
	}

	/** @method Defines game flow */
	protected abstract void gameEngine();
		
	/** @method print game board */
	protected void printBoard() {
		System.out.println();
		this.getGrid().printGrid();
	}

}