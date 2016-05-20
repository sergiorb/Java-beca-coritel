/**
*	@file LetterGrades.java
*	@author Sergio Romero Barra
*
*	calculates the class average of a set of numeric grades 
*	entered by the user, and uses a switch statement to determine 
*	whether each grade is the equivalent of an A, B, C, D or F 
*	and to increment the appropriate grade counter. The program 
*	also displays a summary of the number of students who received 
*	each grade.
*/

package com.sergiorb.java_beca_coritel.lettergrades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//  Main class
public class LetterGrades {

	// Main method
	public static void main(String[] args) {
		
		int value = 0; // Stores user input
		Scanner input = new Scanner(System.in); // user input object.
		Class myClass = new Class(); // Class object
		
		// Stores MarkGrade objects on Class object.
		ArrayList<MarkGrade> markGradeList = new ArrayList<MarkGrade>(); 
		
		System.out.println("Enter integer grades in the range 0-100.");
		System.out.println("Type the end-of-file indicator to terminate input:");
		System.out.println("Type the end-of-file indicator to terminate input:");
		System.out.println("On Unix/Linux/Mac OS x type <Crtl> d, then press Enter");
		System.out.println("On Windows type <Crtl> z, then press Enter");

		// Executes until user enters end-of-file char.
		while(input.hasNext()) {
			
			try { // Assert user input
				
				value = input.nextInt(); // Read user input
				
			} catch(InputMismatchException e) { // If entered anything than an integer 
				
				input.next(); // Cleans input buffer
				value = -1; // Asserts invalid value
			}
			
			if(value >= 0 && value <= 100){ // If value is correct...
				
				// Adds a new MarkGrade object to markGrade list.
				markGradeList.add(new MarkGrade(value));
				
			} else { // incorrect value
				
				System.out.printf("\nInvalid value\n");
			}
		}
		
		input.close(); // Close scanner object
		
		myClass = new Class(); // Instantiate a class and...
		myClass.addMarkGradeArray(markGradeList); //...sets markGrade list. 
		
		myClass.printInform(); // Inform the user
	}

}
