/**
*	@file SquareState.java
*	@author Sergio Romero Barra
*
*	Defines a square states set for TicTacToe
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

/** Class */
public enum SquareState {
	
	// Square states
	BLANK(""),
	CIRCLE("O"),
	CROSS("X");
	
	// Instance Variable
	private String squareState;
	
	/** @param squareState setter */
	private SquareState(String value) {
		this.squareState = value;
	}
	
	/** @return squareState getter */
	public String getSquareState() {
		return squareState;
	}
	
	@Override
	public String toString() {
		return String.format("%s", this.getSquareState());
	}
}
