package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.security.InvalidParameterException;

public abstract class BaseTicTacToe {

	protected Grid grid;
	protected int winNumber;
	
	public BaseTicTacToe() {
		this.setGrid(new Grid(3,3));
		this.setWinNumber(3);
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
	
	protected abstract void gameEngine();
		
	/** @method print game board */
	protected void printBoard() {
		System.out.println();
		this.getGrid().printGrid();
	}

}