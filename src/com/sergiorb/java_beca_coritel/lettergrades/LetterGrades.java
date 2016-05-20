package com.sergiorb.java_beca_coritel.lettergrades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LetterGrades {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // user input object.
		
		int student = 1;
		int passes = 0;
		int failures = 0;
		int value = 0;
		String preValue;
		String invalidString = "INVALID_STRING";
		
		ArrayList<MarkGrade> markGradeList = new ArrayList<MarkGrade>();
		
		
		// While student exams stored are less than 10...
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
			
			if(value >= 0 && value <= 100){ // 
				
				markGradeList.add(new MarkGrade(value));
				
			} else { // incorrect value
				
				System.out.printf("\nInvalid value\n");
			}
		}
		
		for (MarkGrade markGrade : markGradeList) {
			
			System.out.printf("%d - %s\n", (int)markGrade.getMark(), markGrade.getGrade());
		}
	}

}
