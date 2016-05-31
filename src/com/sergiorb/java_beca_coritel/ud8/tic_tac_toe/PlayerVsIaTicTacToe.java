package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

import java.util.Scanner;

public class PlayerVsIaTicTacToe extends BaseTicTacToe {
	
	public PlayerVsIaTicTacToe() {
		super();
	}
	/*
	public PlayerVsIaTicTacToe(int x, int y) {
		super(x, y);
	}
	
	public PlayerVsIaTicTacToe(Grid grid) {
		super(grid);
	}*/

	@Override
	protected void gameEngine() {
		
		boolean win = false;
		boolean added = false;
		
		int userOption = -1;
		int askUser =-1;
		int userRow, userColumn;
		
		Scanner input = new Scanner(System.in);
		SquareState userState = SquareState.BLANK;
		SquareState iaState = SquareState.BLANK;
		
		LowIA ia = new LowIA();
		
		System.out.println("------------------------------------------");
		System.out.println("\nPlayer Vs IA: play against the computer.");
		
		System.out.println("Do you want to play first?");
		System.out.println("Choose Yes[1] or No[0]:");
		askUser = input.nextInt();
		
		while(userOption != 0 || userOption != 1){
			
			System.out.println("Choose O[0] or X[1]:");
			userOption = input.nextInt();
			
			if(userOption == 0) {
				userState = SquareState.CIRCLE;
				iaState = SquareState.CROSS;
				break;
			} else if(userOption == 1) {
				userState = SquareState.CROSS;
				iaState = SquareState.CIRCLE;
				break;
			} else {
				System.out.println("Wrong option");
			}
		}
		
		while(!this.grid.isGridFull() && !win) {
			
			this.printBoard();
			
			if(askUser == 1) {
			
				System.out.printf("Introduce row (1 - %d):\n", this.grid.getxMatrixLength());
				userRow = input.nextInt() -1;
				System.out.printf("Introduce column (1 - %d):\n", this.grid.getyMatrixLength());
				userColumn = input.nextInt() -1;
			
				added = this.grid.setSquareState(userRow, userColumn, userState);
				
				if(added == false) {
					System.out.printf("\nThat square  is not availabe.\n");
					continue;
				}
				
				askUser = 1;
			} else {
				
				askUser = 1;
			}
			
			win = this.grid.checkWinConditions();
			
			if(!win) {
				ia.generateMove(grid, iaState);
			}
			
			win = this.grid.checkWinConditions();
		}
		
		input.close();
				
		System.out.printf("\nWinned by %s\n", this.grid.getWinedBy() != null ? this.grid.getWinedBy():"No One");
	}

}
