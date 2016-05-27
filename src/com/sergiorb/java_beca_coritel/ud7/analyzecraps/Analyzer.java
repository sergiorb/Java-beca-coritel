package com.sergiorb.java_beca_coritel.ud7.analyzecraps;

import java.util.ArrayList;

public class Analyzer {

	private int totalPlatedGames;
	private ArrayList<GameData> games;
	private int maxRounds;
	private double dataPerDuration[][];

	/** @constructor main */
	public Analyzer(int totalPlatedGames, ArrayList<GameData> games) {
		this.setTotalPlatedGames(totalPlatedGames);
		this.setGames(games);
		this.setMaxRounds(21);
		this.setDataPerDuration(new double[this.getMaxRounds()][4]);
	}

	/** @constructor with maxRounds */
	public Analyzer(int totalPlatedGames, ArrayList<GameData> games, int maxRounds) {
		this.setTotalPlatedGames(totalPlatedGames);
		this.setGames(games);
		this.setMaxRounds(maxRounds);
		this.setDataPerDuration(new double[this.getMaxRounds()][4]);
	}

	/** @return the totalPlatedGames */
	private int getTotalPlatedGames() {
		return totalPlatedGames;
	}

	/** @param totalPlatedGames the totalPlatedGames to set */
	private void setTotalPlatedGames(int totalPlatedGames) {
		this.totalPlatedGames = totalPlatedGames;
	}

	/** @return the games */
	private ArrayList<GameData> getGames() {
		return games;
	}

	/** @param games the games to set */
	private void setGames(ArrayList<GameData> games) {
		this.games = games;
	}

	/** @return the maxRounds */
	private int getMaxRounds() {
		return maxRounds;
	}

	/**  @param maxRounds the maxRounds to set */
	private void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}

	/** @return the dataPerDuration */
	private double[][] getDataPerDuration() {
		return dataPerDuration;
	}

	/** @param dataPerDuration the dataPerDuration to set */
	private void setDataPerDuration(double[][] dataPerDuration) {
		this.dataPerDuration = dataPerDuration;
	}

	private void trimDataToMaxRounds() {

		for (GameData game : this.getGames()) {

			if (game.getRound() > this.getMaxRounds()) {
				game.setRound(this.getMaxRounds());
			}
		}
	}

	public void analyze() {

		this.trimDataToMaxRounds();
		
		double dataPerDuration[][] = this.getDataPerDuration();

		for (GameData game : this.getGames()) {

			int round = game.getRound()-1;

			if (game.isWinned()) {
				++dataPerDuration[round][0];
			} else {
				++dataPerDuration[round][1];
			}
			
			dataPerDuration[round][2] = dataPerDuration[round][0] / (dataPerDuration[round][0]
					+ dataPerDuration[round][1]);
			dataPerDuration[round][3] = dataPerDuration[round][1] / (dataPerDuration[round][0]
					+ dataPerDuration[round][1]);
		}
	}
	
	public void printData() {
		
		int winned, lost;
		double winRate, loseRate;
		
		System.out.printf("Round  Winned  Lost     WinRate  LoseRate\n");
		for (int i = 0; i < dataPerDuration.length; i++) {
			
			winned = (int) this.getDataPerDuration()[i][0];
			lost = (int) this.getDataPerDuration()[i][1];
			winRate = this.getDataPerDuration()[i][2];
			loseRate = this.getDataPerDuration()[i][3];
			
			System.out.printf("#%3d   %6d  %6d %6.2f   %6.2f\n", i+1, winned, lost, winRate, loseRate);
		}
	}
}
