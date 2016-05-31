package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.security.InvalidParameterException;
import java.util.EnumSet;

public class Grid {

	private Square[][] matrix;
	private int xMatrixLength;
	private int yMatrixLength;
	protected SquareState winedBy;
	protected int winNumber;
	
	protected Grid() {
		this.setxMatrixLength(3);
		this.setyMatrixLength(3);
		this.matrix = new Square[this.getxMatrixLength()][this.getyMatrixLength()];
		this.generateMatrix();
		this.setWinNumber(3);
	}
	
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
	}

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
		
		if(counter == totalSquares) {
			return true;
		} else {
			return false;
		}
	}
	
	protected EnumSet<SquareState> getSquarePlayerStates() {
		return EnumSet.range(SquareState.CIRCLE, SquareState.CROSS);
	}
	
	/** @method generates default blank matrix */
	private void generateMatrix() {
				
		for (int i = 0; i < this.getxMatrixLength(); i++) {
			for (int j = 0; j < this.getyMatrixLength(); j++) {

				this.matrix[i][j] = new Square();
			}
		}
	}
	 
	protected boolean setSquareState(int row, int column, SquareState state) {
		
		String message;
		
		if(row < 0 || row > this.getxMatrixLength()-1) {
			message = String.format("Wrong row value: Select from 0 to %d", this.getxMatrixLength()-1);
			throw new InvalidParameterException(message);
		}
		
		if(column < 0 || column > this.getyMatrixLength()-1) {
			message = String.format("Wrong column value: Select from 0 to %d", this.getyMatrixLength()-1);
			throw new InvalidParameterException(message);
		}
				
		if(this.getMatrix()[row][column].getSquareState() == SquareState.BLANK) {
			this.getMatrix()[row][column].setSquareState(state);
			return true;
		} else {
			return false;
		}
	}
	
	protected SquareState getSquareState(int x, int y) {
		return this.matrix[x][y].getSquareState();
	}
	
	protected boolean squareIsBlank(int x, int y) {
		
		if(this.matrix[x][y].getSquareState() == SquareState.BLANK) {
			return true;
		} else {
			return false;
		}
	}
	
	protected int getRandomStateNumber() {
		
		EnumSet<SquareState> options = EnumSet.range(SquareState.CIRCLE, SquareState.CROSS);		
		
		return (int) Math.ceil(Math.random() * options.size());
	}
	
	protected SquareState checkWinInX() {
		
		int count = 0;
		SquareState previousState = SquareState.BLANK;
		
		for (int i = 0; i < this.getxMatrixLength(); i++) {
			for (int j = 0; j < this.getyMatrixLength(); j++) {
				
				if(this.getSquareState(i, j) != previousState ) {
					count = 0;
				} 
				
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
				
				if(count == this.getWinNumber()) {
										
					this.setWinedBy(this.getSquareState(i, j));
					
					return this.getSquareState(i, j);
				}
				
				previousState = this.getSquareState(i, j);
			}
			
			count = 0;
		}

		return null;
	}
	
	protected SquareState checkWinInY() {
		
		int count = 0;
		SquareState previousState = SquareState.BLANK;

		for (int i = 0; i < this.getyMatrixLength(); i++) {
			for (int j = 0; j < this.getxMatrixLength(); j++) {
				
				if(this.getSquareState(j, i) != previousState ) {
					count = 0;
				} 
				
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
				
				if(count == this.getWinNumber()) {
										
					this.setWinedBy(this.getSquareState(j, i));
					
					return this.getSquareState(j, i);

				}
				
				previousState = this.getSquareState(j, i);
			}
			
			count = 0;
		}
		
		return null;
	}
	
	protected SquareState checkWinInXY() {
		
		int count = 0;
		SquareState previousState = SquareState.BLANK;

		for (int i = 0; i < this.getyMatrixLength(); i++) {				
				if(this.getSquareState(i, i) != previousState ) {
					count = 0;
				} 
				
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
				
				if(count == this.getWinNumber()) {
					this.setWinedBy(this.getSquareState(i, i));
					return this.getSquareState(i, i);
				}
				
				previousState = this.getSquareState(i, i);
		}
		
		count = 0;
		
		int retroColumn = this.getyMatrixLength() - 1;
		
		for (int i = 0; i < this.getxMatrixLength(); i++) {				
			if(this.getSquareState(i, retroColumn) != previousState ) {
				count = 0;
			} 
			
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
			
			if(count == this.getWinNumber()) {
				this.setWinedBy(this.getSquareState(i, retroColumn));
				return this.getSquareState(i, retroColumn);
			}
			
			previousState = this.getSquareState(i, retroColumn);
			retroColumn--;
		}
		
		return null;
	}
	
	protected boolean checkWinConditions() {
		
		if(this.checkWinInX() != null || this.checkWinInY() != null || this.checkWinInXY() != null) {
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
