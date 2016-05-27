package com.sergiorb.java_beca_coritel.ud7.analyzecraps;

public class GameData {

	private boolean winned;
	private int round;
	
	public GameData(boolean winned, int round) {
		this.setWinned(winned);
		this.setRound(round);
	}
	
	/** @return the winned */
	public boolean isWinned() {
		return winned;
	}
	/** @param winned the winned to set */
	protected void setWinned(boolean winned) {
		this.winned = winned;
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
