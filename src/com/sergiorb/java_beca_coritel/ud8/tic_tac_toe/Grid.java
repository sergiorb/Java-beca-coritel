/**
*	@file Grid.java
*	@author Sergio Romero Barra
*
*	Defines a TicTacToegame board.
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.security.InvalidParameterException;
import java.util.EnumSet;

/** Class */
public class Grid {

	// Instances variables.
	private Square[][] matrix; // Square matrix.
	private int xMatrixLength; // Matrix length on x axis.
	private int yMatrixLength; // Matrix length on Y axis.
	protected SquareState winedBy; // Stores who wins.
	protected int winNumber; // Stores win number condition.
	
	/** @constructor Main */
	protected Grid() {
		this.setxMatrixLength(3);
		this.setyMatrixLength(3);
		this.matrix = new Square[this.getxMatrixLength()][this.getyMatrixLength()];
		this.generateMatrix();
		this.setWinNumber(3);
	}
	
	/*
	protected Grid (int x, int y) {
		this.setxMatrixLength(x);
		this.setyMatrixLength(y);
		this.matrix = new Square[this.getxMatrixLength()][this.getyMatrixLength()];
		this.generateMatrix();
		this.setWinNumber(3);
	}
	
	protected Grid(Square[][] matrix) {
		this.setMatrix(matrix);
		this.setxMatrixLength(this.getMatrix().length);
		this.setyMatrixLength(this.getMatrix()[1].length);
		this.setWinNumber(3);
	}*/

	/** @return the matrix */
	private Square[][] getMatrix() {
		return matrix;
	}

	/** @param matrix the matrix to set */
	private void setMatrix(Square[][] matrix) {
		this.matrix = matrix;
	}
	
	/** @return the xMatrixLength */
	protected int getxMatrixLength() {
		return xMatrixLength;
	}

	/** @param xMatrixLength the xMatrixLength to set */
	private void setxMatrixLength(int xMatrixLength) {
		this.xMatrixLength = xMatrixLength;
	}

	/** @return the yMatrixLength */
	protected int getyMatrixLength() {
		return yMatrixLength;
	}

	/** @param yMatrixLength the yMatrixLength to set */
	private void setyMatrixLength(int yMatrixLength) {
		this.yMatrixLength = yMatrixLength;
	}
	
	/** @return the winNumber */
	protected int getWinNumber() {
		return winNumber;
	}

	/** @param winNumber the winNumber to set  */
	private void setWinNumber(int winNumber) {
		
		if(winNumber <= this.getxMatrixLength()) {
			if (winNumber <= this.getyMatrixLength()) {
				this.winNumber = winNumber;
			} else {
				throw new InvalidParameterException();
			}	
		} else {
			throw new InvalidParameterException();
		}
	}

	/** @return the winedBy */
	protected SquareState getWinedBy() {
		return winedBy;
	}

	/** @param winedBy the winedBy to set */
	protected void setWinedBy(SquareState winedBy) {
		this.winedBy = winedBy;
	}
	
	/** @method Loops over matrix to check if there is no Blanks states */
	protected boolean isGridFull() {
		
		int counter = 0;
		int totalSquares = this.getxMatrixLength() * this.getyMatrixLength();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				if(matrix[i][j].getSquareState() != SquareState.BLANK) {
					counter++;
				}
			}
		}
		
		// If there is equal not blank state number than total squares..
		if(counter == totalSquares) {
			return true; // Grid is full.
		} else {
			return false; // Grid is not full.
		}
	}
	
	/** @return playable states */
	protected EnumSet<SquareState> getSquarePlayerStates() {
		return EnumSet.range(SquareState.CIRCLE, SquareState.CROSS);
	}
	
	/** @method generates default blank matrix */
	private void generateMatrix() {
				
		for (int i = 0; i < this.getxMatrixLength(); i++) {
			for (int j = 0; j < this.getyMatrixLength(); j++) {
				
				// Sets a new square object in current position.
				this.matrix[i][j] = new Square();
			}
		}
	}
	
	/** @method Sets a state for the given grid position */
	protected boolean setSquareState(int row, int column, SquareState state) {
		
		String message;
		
		// If row is a valid value (smaller that matrix X axis length)
		if(row < 0 || row > this.getxMatrixLength()-1) {
			message = String.format("Wrong row value: Select from 0 to %d", this.getxMatrixLength()-1);
			throw new InvalidParameterException(message);
		}
		
		// If column is a valid value (smaller that matrix Y axis length)
		if(column < 0 || column > this.getyMatrixLength()-1) {
			message = String.format("Wrong column value: Select from 0 to %d", this.getyMatrixLength()-1);
			throw new InvalidParameterException(message);
		}
		
		// If requested square is blank...
		if(this.getMatrix()[row][column].getSquareState() == SquareState.BLANK) {
			
			// Sets given state in square.
			this.getMatrix()[row][column].setSquareState(state);
			return true; // And return true.
			
		} else {
			
			return false;// Returns false.
		}
	}
	
	/** @return State for requested row and column */
	protected SquareState getSquareState(int x, int y) {
		return this.matrix[x][y].getSquareState();
	}
	
	/** @return true if requested row/column is available */
	protected boolean squareIsBlank(int x, int y) {
		
		if(this.matrix[x][y].getSquareState() == SquareState.BLANK) {
			return true;
		} else {
			return false;
		}
	}
	
	/** @return If there is a winer State on X axis */
	protected boolean checkWinInX() {
		
		int count = 0;
		SquareState previousState = SquareState.BLANK;
		
		// Loops over matrix and looks for a repeated state.
		for (int i = 0; i < this.getxMatrixLength(); i++) {
			for (int j = 0; j < this.getyMatrixLength(); j++) {
				
				// If current state if different from last state,
				// resets counter.
				if(this.getSquareState(i, j) != previousState ) {
					count = 0;
				} 
				
				// If current state is Circle or Cross, increase counter.
				switch (this.getSquareState(i, j)) {
				case CIRCLE:
					count++;
					break;
				case CROSS:
					count++;
					break;
				default:
					break;
				}
				
				// If counter equals win condition number
				if(count == this.getWinNumber()) {
										
					// Sets winner and..
					this.setWinedBy(this.getSquareState(i, j));
					
					return true; // ...return true.
				}
				
				// Stores last state
				previousState = this.getSquareState(i, j);
			}
			
			count = 0; // Resets counter when row changes.
		}

		return false; // Returns false if no win condition is reached.
	}
	
	/** @return If there is a winer State on Y axis */
	protected boolean checkWinInY() {
		
		int count = 0;
		SquareState previousState = SquareState.BLANK;

		// Loops over matrix and looks for a repeated state.
		for (int i = 0; i < this.getyMatrixLength(); i++) {
			for (int j = 0; j < this.getxMatrixLength(); j++) {
				
				// If current state if different from last state,
				// resets counter.
				if(this.getSquareState(j, i) != previousState ) {
					count = 0;
				} 
				
				// If current state is Circle or Cross, increase counter.
				switch (this.getSquareState(j, i)) {
				case CIRCLE:
					count++;
					break;
				case CROSS:
					count++;
					break;
				default:
					break;
				}
				
				// If counter equals win condition number
				if(count == this.getWinNumber()) {
										
					// Sets winner and..
					this.setWinedBy(this.getSquareState(j, i));
					
					return true; // ...and return true
				}
				
				// Stores last state
				previousState = this.getSquareState(j, i);
			}
			
			count = 0; // Resets counter when column changes.
		}
		
		return false; // Returns false if no win condition is reached.
	}
	
	/** @return If there is a winer in any diagonal */
	protected boolean checkWinInXY() {
		
		int count = 0;
		SquareState previousState = SquareState.BLANK;

		// First, Checks left-to-right diagonal
		for (int i = 0; i < this.getyMatrixLength(); i++) {
			
				// If current state if different from last state,
				// resets counter.
				if(this.getSquareState(i, i) != previousState ) {
					count = 0;
				} 
				
				// If current state is Circle or Cross, increase counter.
				switch (this.getSquareState(i, i)) {
				case CIRCLE:
					count++;
					break;
				case CROSS:
					count++;
					break;
				default:
					break;
				}
				
				// If counter equals win condition...
				if(count == this.getWinNumber()) {
					
					// Sets who win and...
					this.setWinedBy(this.getSquareState(i, i));
					return true; // ...returns true
				}
				
				previousState = this.getSquareState(i, i);
		}
		
		// If left-to-right diagonal has not win condition...
		
		count = 0; // Resets counter
		
		// Establish column number (first row, last column)
		int retroColumn = this.getyMatrixLength() - 1;
		
		// Loops over right-to-left diagonal
		for (int i = 0; i < this.getxMatrixLength(); i++) {	
			
			// If current state if different from last state,
			// resets counter.
			if(this.getSquareState(i, retroColumn) != previousState ) {
				count = 0;
			} 
			
			// If current state is Circle or Cross, increase counter.
			switch (this.getSquareState(i, retroColumn)) {
			case CIRCLE:
				count++;
				break;
			case CROSS:
				count++;
				break;
			default:
				break;
			}
			
			// If counter equals win condition...
			if(count == this.getWinNumber()) {
				
				// Sets who wins and... 
				this.setWinedBy(this.getSquareState(i, retroColumn));
				return true; // ... returns true
			}
			
			// Sets previous state.
			previousState = this.getSquareState(i, retroColumn);
			retroColumn--; // Decreases Column to check left side.
		}
		
		// If there is no win condition in any diagonal, returns false.
		return false;
	}
	
	/** @return Checks all win conditions and returns true if one of them is true. 
	 * Otherwise, returns false. */
	protected boolean checkWinConditions() {
		
		if(this.checkWinInX() != false || this.checkWinInY() != false || this.checkWinInXY() != false) {
			return true;
		} else {
			return false;
		}
	}
	
	/** @method prints grid */
	protected void printGrid() {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				String state = String.format("[%1s] ", matrix[i][j].getSquareState());
				
				System.out.print(state);
			}
			System.out.println();
		}
	}
}
