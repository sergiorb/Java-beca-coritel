package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

public enum SquareState {
	BLANK(""),
	CIRCLE("O"),
	CROSS("X");
	
	private String squareState;
	
	private SquareState(String value) {
		this.squareState = value;
	}
	
	public String getSquareState() {
		return squareState;
	}
	
	@Override
	public String toString() {
		return String.format("%s", this.getSquareState());
	}
}
