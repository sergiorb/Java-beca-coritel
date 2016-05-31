package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.util.Scanner;

public class PlayerVsPlayerTicTacToe extends BaseTicTacToe {
	
	public PlayerVsPlayerTicTacToe() {
		super();
	}
	/*
	public PlayerVsPlayerTicTacToe(int x, int y) {
		super(x, y);
	}
	
	public PlayerVsPlayerTicTacToe(Grid grid) {
		super(grid);
	}*/

	@Override
	protected void gameEngine() {
		
		boolean win = false;
		boolean added = false;
		
		int userRow, userColumn;
		int sentinel = 0;
		
		Scanner input = new Scanner(System.in);
		SquareState squareState = SquareState.BLANK;
		
		while(!this.grid.isGridFull() && !win) {
			
			this.printBoard();
			
			if(sentinel%2 == 0) {
				System.out.printf("Player one turn:\n");
				squareState = SquareState.CROSS;
			} else {
				System.out.printf("Player two turn:\n");
				squareState = SquareState.CIRCLE;
			}
			
			System.out.printf("Introduce row (1 - %d):\n", this.grid.getxMatrixLength());
			userRow = input.nextInt() -1;
			System.out.printf("Introduce column (1 - %d):\n", this.grid.getyMatrixLength());
			userColumn = input.nextInt() -1;
			
			added = this.grid.setSquareState(userRow, userColumn, squareState);
				
			if(added == false) {
				System.out.printf("\nThat square  is not availabe.\n");
				continue;
			}
			
			win = this.grid.checkWinConditions();
			
			sentinel++;
		}
		
		input.close();
				
		System.out.printf("\nWinned by %s\n", this.grid.getWinedBy() != null ? this.grid.getWinedBy():"No One");
	}

}
