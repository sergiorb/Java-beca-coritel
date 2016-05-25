/**
*	@file Bidimensional.java
*	@author Sergio Romero Barra
*
*	Defines two matrix and prints it.
*/

package com.sergiorb.java_beca_coritel.ud7.bidimensional;

public class Bidimensional {
	
	/** @method Receives a bidimensional array and prints it */
	public static void printMatrix(int[][] array, String header) {
		
		System.out.println(header);
		
		// For every row...
		for (int i = 0; i < array.length; i++) {
			// loop over every column...
			for (int j = 0; j < array[i].length; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println(); // Jumps at the end of every row.
		}
		
		System.out.println(); // Jumps at the end of the matrix
	}

	/** @method Main method */
	public static void main(String[] args) {
		
		// Defines two matrix
		int[][] firstArray = {{1,2,3},{4,5,6}};
		int[][] secondArray = {{1,2},{3},{4,5,6}};
		
		// Calls printing array function
		printMatrix(firstArray, "Values in array1 by row are");
		printMatrix(secondArray, "Values in array1 by row are");
	}

}
