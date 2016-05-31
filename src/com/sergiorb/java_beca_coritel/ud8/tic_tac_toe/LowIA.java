package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

public class LowIA extends BaseIA {

	@Override
	public void generateMove(Grid grid, SquareState player) {
		
		boolean generated = false;
		
		System.out.println("IA is (not really) thinking...");
		
		do {
			
			int randomX = (int) Math.ceil(Math.random() * grid.getxMatrixLength())-1;
			int randomY = (int) Math.ceil(Math.random() * grid.getyMatrixLength())-1;
			
			if(grid.squareIsBlank(randomX, randomY)) {
				
				grid.setSquareState(randomX, randomY, player);
				generated = true;
			}
			
		} while(!generated && !grid.isGridFull());
	}

}
