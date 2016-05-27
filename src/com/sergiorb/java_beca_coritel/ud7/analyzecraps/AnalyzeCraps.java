/**
*	@file AnalyzeCraps.java
*	@author Sergio Romero Barra
*
*	Analyze craps gambling game.
*/

package com.sergiorb.java_beca_coritel.ud7.analyzecraps;

import java.util.ArrayList;

/** Main class */
public class AnalyzeCraps {

	/** Main method */
	public static void main(String[] args) {
		
		Craps crap = new Craps(); // Instantiate craps gam.e
		ArrayList<GameData> gamesData = new ArrayList<GameData>(); // Stores GameData objects.
		int toPlay = 1000000; // Games to be played.
		
		// Play a game an stores the GameDada result in gamesData array.
		for (int i = 0; i < toPlay; i++) {
			gamesData.add(crap.play());
		}
		
		// Creates a new Analyzer object with the played games.
		Analyzer analyzer = new Analyzer(toPlay, gamesData); 
		
		analyzer.analyze(); // Analyze data.
		analyzer.printData(); // Show user results.
	}
}
