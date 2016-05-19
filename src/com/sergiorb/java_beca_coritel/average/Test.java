/**
*	@file Student.java
*	@author Sergio Romero Barra
*
*	Test student. Creates a dummy student object and ask user to
*	introduce marks until mark value equals -1. Finally, present
*	student marks and grade inform.
*/

package com.sergiorb.java_beca_coritel.average;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		// Tests variables
		Scanner input = new Scanner(System.in); // scanner object for reading user data
		Student student = new Student("Juan"); // Instantiate student object.
		double value = 0.0; // User value input
		
		do { // First, do body...
			
			System.out.println("Introduce next mark [\"-1\" to finish]:");
						
			try { // Controls if there is an error with user value
				
				value = input.nextDouble(); // Stores value
				
			} catch(InputMismatchException e ) { // In case of error...
				
				System.out.printf("Enter a valid double mark!\n");
				input.next(); // Cleans input value
				continue; // Don't execute left code, repeat immediately. 
			}
			
			if(value != -1) { // If value is not exit value
			
				student.addMark(value); // Adds mark
				student.printMarkArray(); // Print current marks array
			}
			
		} while (value != -1); // ... then, repeats while value is not -1
		
		input.close(); // Close scanner stream
		
		student.printInform();

		System.out.println("Program finished!!");
		
	}

}
