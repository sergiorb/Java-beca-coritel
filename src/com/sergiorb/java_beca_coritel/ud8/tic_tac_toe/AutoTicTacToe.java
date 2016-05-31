package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

public class AutoTicTacToe extends BaseTicTacToe {
	
	public AutoTicTacToe() {
		super();
	}
	
	/*
	public AutoTicTacToe(int x, int y) {
		super(x, y);
	}
	
	public AutoTicTacToe(Grid grid) {
		super(grid);
	}*/

	
	@Override
	protected void gameEngine() {
		
		boolean win = false;
		int sentinel = 0;
		
		LowIA ia = new LowIA();
		
		System.out.println("----------------------------------------------");
		System.out.println("\nAutoTicTacToe: an IA playing against itself.");
		
		while(!this.grid.isGridFull() && !win) {
			
			if(sentinel%2 == 0) {
				ia.generateMove(grid, SquareState.CIRCLE);
			} else {
				ia.generateMove(grid, SquareState.CROSS);
			}
			
			win = this.grid.checkWinConditions();
			sentinel++;
		}
		
		this.printBoard();
		
		System.out.printf("\nWinned by %s\n", this.grid.getWinedBy() != null ? this.grid.getWinedBy():"No One");
	}
}
