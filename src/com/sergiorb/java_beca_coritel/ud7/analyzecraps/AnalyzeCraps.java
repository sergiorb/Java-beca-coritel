package com.sergiorb.java_beca_coritel.ud7.analyzecraps;

import java.util.ArrayList;

public class AnalyzeCraps {

	public static void main(String[] args) {
		
		Craps crap = new Craps();
		ArrayList<GameData> gamesData = new ArrayList<GameData>();
		int toPlay = 1000000;
		
		for (int i = 0; i < toPlay; i++) {
			gamesData.add(crap.play());
		}
		
		Analyzer analyzer = new Analyzer(toPlay, gamesData);
		
		analyzer.analyze();
		analyzer.printData();
	}
}
