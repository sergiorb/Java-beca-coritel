/**
*	@file LowAI.java
*	@author Sergio Romero Barra
*
*	Defines a AI that generate random positions until it can be added.
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

/** Class */
public class LowAI extends BaseAI {

	@Override
	public void generateMove(Grid grid, SquareState state) {
		
		boolean generated = false;
		
		System.out.println("IA is (not really) thinking...");
		
		do {
			
			// Generates a random position from the grid.
			int randomX = (int) Math.ceil(Math.random() * grid.getxMatrixLength())-1;
			int randomY = (int) Math.ceil(Math.random() * grid.getyMatrixLength())-1;
			
			// If that position is blank... 
			if(grid.squareIsBlank(randomX, randomY)) {
				
				// Sets square state and exit.
				grid.setSquareState(randomX, randomY, state);
				generated = true;
			}
			
		} while(!generated && !grid.isGridFull());
	}

}
