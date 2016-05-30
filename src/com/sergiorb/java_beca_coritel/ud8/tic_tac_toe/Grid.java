package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.security.InvalidParameterException;

public class Grid {

	private Square[][] matrix;
	private int xMatrixLength;
	private int yMatrixLength;
	
	protected Grid() {
		this.setxMatrixLength(3);
		this.setyMatrixLength(3);
		this.matrix = new Square[this.getxMatrixLength()][this.getyMatrixLength()];
		this.generateMatrix();
	}
	
	protected Grid (int x, int y) {
		this.setxMatrixLength(x);
		this.setyMatrixLength(y);
		this.matrix = new Square[this.getxMatrixLength()][this.getyMatrixLength()];
		this.generateMatrix();
	}
	
	protected Grid(Square[][] matrix) {
		this.setMatrix(matrix);
		this.setxMatrixLength(this.getMatrix().length);
		this.setyMatrixLength(this.getMatrix()[1].length);
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
	
	/** @method generates default blank matrix */
	private void generateMatrix() {
				
		for (int i = 0; i < this.getxMatrixLength(); i++) {
			for (int j = 0; j < this.getyMatrixLength(); j++) {

				this.matrix[i][j] = new Square();
			}
		}
	}
	 
	
	protected void setSquareState(int row, int column, int state) {
		
		String message;
		
		if(row < 0 || row > this.getxMatrixLength()-1) {
			message = String.format("Wrong row value: Select from 0 to %d", this.getxMatrixLength()-1);
			throw new InvalidParameterException(message);
		}
		
		if(column < 0 || column > this.getyMatrixLength()-1) {
			message = String.format("Wrong column value: Select from 0 to %d", this.getyMatrixLength()-1);
			throw new InvalidParameterException(message);
		}
		
		switch (state) {
		case 0:
			this.getMatrix()[row][column].setSquareState(SquareState.BLANK);
			break;
		case 1:
			this.getMatrix()[row][column].setSquareState(SquareState.CIRCLE);
			break;
		case 2:
			this.getMatrix()[row][column].setSquareState(SquareState.CROSS);
			break;
		default:
			message = String.format("%d is not a valid state. Options are:"
					+ "\nBLANK:0\nCIRCLE:1\nCROSS:2", state);
			throw new InvalidParameterException(message);
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
		
		int optionsLength = SquareState.values().length;
		
		System.out.println(optionsLength);
		int number = (int) Math.ceil(Math.random() * optionsLength);
		
		return number;
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
