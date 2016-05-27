/**
*	@file GameData.java
*	@author Sergio Romero Barra
*
*	Defines an object to store craps games data.
*/

package com.sergiorb.java_beca_coritel.ud7.analyzecraps;

public class GameData {

	private boolean wined;
	private int round;
	
	public GameData(boolean winned, int round) {
		this.setWined(winned);
		this.setRound(round);
	}
	
	/** @return the wined */
	public boolean isWined() {
		return wined;
	}
	/** @param winned the wined to set */
	protected void setWined(boolean winned) {
		this.wined = winned;
	}
	/** @return the round */
	public int getRound() {
		return round;
	}
	/** @param round the round to set */
	protected void setRound(int round) {
		this.round = round;
	}
}
