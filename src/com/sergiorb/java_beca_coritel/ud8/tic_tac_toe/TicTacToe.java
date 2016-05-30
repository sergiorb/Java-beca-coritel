package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.security.InvalidParameterException;

public class TicTacToe {

	private Grid grid;
	
	public TicTacToe() {
		this.setGrid(new Grid(3,3));
	}
	
	public TicTacToe(int x, int y) {
		
		if (x < 2 || y < 2) {
			String message = String.format("Rows and Columns have to be 2 length at least\n");
			throw new InvalidParameterException(message);
		}
		
		this.setGrid(new Grid(x, y));
	}
	
	public TicTacToe(Grid grid) {
		this.setGrid(grid);
	}

	/** @return the grid */
	private Grid getGrid() {
		return grid;
	}

	/** @param grid the grid to set */
	private void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	public void randomMove() {
		
		boolean control = true;
		
		while(control) {
			int randomX = (int) Math.ceil(Math.random() * this.grid.getxMatrixLength())-1;
			int randomY = (int) Math.ceil(Math.random() * this.grid.getyMatrixLength())-1;
		
			if(this.grid.squareIsBlank(randomX, randomY)) {
				this.grid.setSquareState(randomX, randomY, this.grid.getRandomStateNumber());
			} else {
				control = false;
			}
		}
	}
	
	/** @method print game board */
	public void printBoard() {
		System.out.println();
		this.getGrid().printGrid();
	}

}
