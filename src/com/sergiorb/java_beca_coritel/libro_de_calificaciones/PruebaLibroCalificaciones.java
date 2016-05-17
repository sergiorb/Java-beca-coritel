/**
*	@file PruebaLibroCalificaciones.java
*	@author Sergio Romero Barra
*
*	Creates an LibroCalificaciones object and calls its showMessage method.
*/

package com.sergiorb.java_beca_coritel.libro_de_calificaciones;

import java.util.Scanner;

public class PruebaLibroCalificaciones {

	// Main method
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // Scanner object instanciation
		
		try {
			
			LibroCalificaciones book = new LibroCalificaciones(); // Object instanciation
			
			book.showMessage("");
			book.showMessage("Python"); // Calls showMessage
			book.setWelcomeMessage("Welcome to the scary"); // Sets welcomeMessage property.
			book.showMessage("HTML5"); // Calls showMessage
			book.setWelcomeMessage("Welcome to me mega scary"); // Sets welcomeMessage property.
			book.showMessage("Scala");
				
			System.out.println("Introduce course name:");
			String courseName = scan.nextLine(); // reads course name
			
			book.showMessage(courseName); // Sets welcomeMessage property.
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			scan.close(); // Close scan stream object.
			System.out.println("Program finished!");
		}
	}

}
