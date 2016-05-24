/**
 * There were asked 20 students to make a valuation from a school cafeteria.
 * They could assign a score from 1(Awful) to 5(Excellent).
 * 
 */

package com.sergiorb.java_beca_coritel.ud7.studentssurvey;

public class StudentsSurvey {

	/** Returns a random dice result **/
	public static int getFakeValuation() {
		
		int result;
		
		// Multiplies the Math.random result (0.0 to 1.0) with 5
		// and round it to the upper integer 
		result = (int) Math.ceil(Math.random() * 5);
		
		return result;
	}
	
	/** Main method */
	public static void main(String[] args) {
		
		int[] valuations = new int[20]; // Stores students valuations
		int[] valuationsQuantity = new int[5]; // Stores total number of every valuation value
		
		// Generating 20 values due valuation array length
		for (int i = 0; i < valuations.length; i++) {
			
			valuations[i] = getFakeValuation(); // Generate value and saves to array
			
			//System.out.printf("Valuation[%02d]:   %d\n",i+1, valuations[i]);
			
			// Increase the quantity value for the valuation value
			valuationsQuantity[valuations[i]-1] += 1; 
		}
		
		// Loops over valuationsQuantity to show user how many people have voted every value.
		for (int i = 0; i < valuationsQuantity.length; i++) {
			System.out.printf("Calification Value[%d]:   %,d %s\n",
					i+1, valuationsQuantity[i], valuationsQuantity[i]==1?"person":"people");
		}

 
	}

}
