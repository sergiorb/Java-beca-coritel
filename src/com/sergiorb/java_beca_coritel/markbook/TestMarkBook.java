/**
*	@file TestMarkBook.java
*	@author Sergio Romero Barra
*
*	Creates an LibroCalificaciones object and calls its showMessage method.
*/

package com.sergiorb.java_beca_coritel.markbook;

import java.util.Scanner;

public class TestMarkBook {

	// Main method
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // Scanner object instanciation
		
		try {
			
			MarkBook book = new MarkBook(); // Object instanciation
			
			book.showMessage(); // Calls showMessage.
			book.setCourseName("Python"); // Sets course name in the object
			book.showMessage();
			book.setWelcomeMessage("Welcome to the scary"); // Sets welcomeMessage property.
			book.showMessage();
			book.setCourseName("HTML5");
			book.showMessage();
			book.setWelcomeMessage("Welcome to the mega scary");
			book.showMessage();
			book.setWelcomeMessage("Welcome to the marvelous world of");
			book.setCourseName("Scala");
			book.showMessage();
				
			System.out.println("Introduce course name:");
			String courseName = scan.nextLine(); // reads course name from user
			
			book.setCourseName(courseName);
			book.showMessage(); // Sets welcomeMessage property.
			
		} catch (Exception e) {
			
			System.out.println("An error ocurred!. Existing...");
			
		} finally {
			
			scan.close(); // Close scan stream object.
			System.out.println("Program finished!");
		}
	}

}
