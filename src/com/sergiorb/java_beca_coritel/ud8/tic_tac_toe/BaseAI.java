/**
*	@file BaseIA.java
*	@author Sergio Romero Barra
*
*	Defines an abstract class for IA's
*/

package com.sergiorb.java_beca_coritel.ud8.tic_tac_toe;

public abstract class BaseAI {

	/** @method calculates next IA move */
	public abstract void generateMove(Grid grid, SquareState player);
}
