package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

public class TestTicTacToe {

	public static void main(String[] args) {
		
		TicTacToe game = new TicTacToe(10,10);
		
		game.randomMove();
		
		game.printBoard();

	}

}
