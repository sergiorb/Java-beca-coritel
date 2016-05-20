/**
*	@file Analysis.java
*	@author Sergio Romero Barra
*
*	Stores if students (up to 10) has passed or failed their exam.
*	Shows result and, if all students have passed, give bonus to
*	instructor.
*/

package com.sergiorb.java_beca_coritel.pseudocode;

import java.util.InputMismatchException;
import java.util.Scanner;

// Main class
public class Analysis {

	// Main method
	public static void main(String[] args) {
		
		int passes = 0; // Stores number of passed exams. 
		int failures = 0; // Stores number of failed exams. 
		int student = 1; // Controls loop.
		int value = 0; // Stores user input.
		
		Scanner input = new Scanner(System.in); // user input object.
		
		// While student exams stored are less than 10...
		while(student <= 10) {
			
			System.out.printf("Enter result (1 = pass, 2 = fail): ");
			
			try { // Assert user input
				
				value = input.nextInt(); // Read user input
				
			} catch(InputMismatchException e) { // If entered anything than an integer 
				
				input.next(); // Cleans input buffer
				value = 3; // Aserts invalid value
			}
			
			if(value == 1){ // If exam is passed...
				
				++passes; // Increase passed exams
				++student; // Increase stored students
				
			} else if(value == 2) { // if exam is failed...
				
				++failures; // Increase failed exams
				++student; // Increase stored students
				
			} else { // incorrect value
				
				System.out.printf("\nInvalid value\n");

			}
		}
		
		// Informs user
		System.out.printf("Passed: %d\n", passes);
		System.out.printf("Failed: %d\n", failures);
		
		// If there is more than 8 passed students...
		if(passes > 8) {
			
			// Bonus to instructor.
			System.out.printf("Bonus to instructor!\n");
		}
	}
}
