/**
*	@file Analyzer.java
*	@author Sergio Romero Barra
*
*	Defines an analyzer for craps game.
*/

package com.sergiorb.java_beca_coritel.ud7.analyzecraps;

import java.util.ArrayList;

/** Main class */
public class Analyzer {

	private int totalPlayedGames; // Games played.
	private ArrayList<GameData> games; // Stores GameData objects to work with them.
	private int maxRounds; // Maximum number of rounds we want to analyze.
	private double dataPerDuration[][]; // Stores analyzed data.

	/** @constructor main */
	public Analyzer(int totalPlatedGames, ArrayList<GameData> games) {
		this.setTotalPlayedGames(totalPlatedGames);
		this.setGames(games);
		this.setMaxRounds(21);
		// Creates a data array with a length as the maximum rounds defined,
		// with four values (win, lose, win rate and lose rate).
		this.setDataPerDuration(new double[this.getMaxRounds()][4]);
	}

	/** @constructor with maxRounds */
	public Analyzer(int totalPlatedGames, ArrayList<GameData> games, int maxRounds) {
		this.setTotalPlayedGames(totalPlatedGames);
		this.setGames(games);
		this.setMaxRounds(maxRounds);
		this.setDataPerDuration(new double[this.getMaxRounds()][4]);
	}

	/** @return the totalPlatedGames */
	private int getTotalPlayedGames() {
		return totalPlayedGames;
	}

	/** @param totalPlayedGames the totalPlatedGames to set */
	private void setTotalPlayedGames(int totalPlayedGames) {
		this.totalPlayedGames = totalPlayedGames;
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

	/** @method Any GameData object with a duration greater that the maximum value 
	 * of rounds that we want to analyze, it is set to maxRounds value. */
	private void trimDataToMaxRounds() {

		for (GameData game : this.getGames()) {

			if (game.getRound() > this.getMaxRounds()) {
				game.setRound(this.getMaxRounds());
			}
		}
	}

	/** @method Analyze GameData objects and fills dataPerDuration array */
	public void analyze() {

		this.trimDataToMaxRounds(); // Trims games duration.
		
		double dataPerDuration[][] = this.getDataPerDuration();

		// for every game
		for (GameData game : this.getGames()) {

			// Get its finishing round (-1 to adjusts it to the array)
			int round = game.getRound()-1; 

			// If game is wined...
			if (game.isWined()) {
				++dataPerDuration[round][0]; // Increases wined value for current finish round
			} else {
				++dataPerDuration[round][1]; // Increases lost value for current finish round
			}
			
			// Calculates win and lose rate, dividing round wins/loses by the sum of wins and loses
			// in the current duration(finish round).
			dataPerDuration[round][2] = dataPerDuration[round][0] / (dataPerDuration[round][0]
					+ dataPerDuration[round][1]);
			dataPerDuration[round][3] = dataPerDuration[round][1] / (dataPerDuration[round][0]
					+ dataPerDuration[round][1]);
		}
	}
	
	/** @method prints data array for user */
	public void printData() {
		
		int winned, lost;
		double winRate, loseRate;
		
		System.out.printf("Round   Winned   Lost      WinRate  LoseRate\n");
		for (int i = 0; i < dataPerDuration.length; i++) {
			
			winned = (int) this.getDataPerDuration()[i][0];
			lost = (int) this.getDataPerDuration()[i][1];
			winRate = this.getDataPerDuration()[i][2];
			loseRate = this.getDataPerDuration()[i][3];
			
			System.out.printf("#%,4d   %,7d  %,7d %6.2f   %6.2f\n", i+1, winned, lost, winRate, loseRate);
		}
	}
}
