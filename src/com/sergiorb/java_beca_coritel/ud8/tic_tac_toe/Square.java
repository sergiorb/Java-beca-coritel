package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

public class Square {

	private SquareState squareState;
	
	public Square() {
		this.setSquareState(SquareState.BLANK);
	}
	
	public Square(SquareState state) {
		this.setSquareState(state);
	}
	
	/** @return the squareState */
	public SquareState getSquareState() {
		return squareState;
	}

	/** @param squareState the squareState to set */
	public void setSquareState(SquareState squareState) {
		this.squareState = squareState;
	}
}
