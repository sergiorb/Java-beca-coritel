/**
*	@file PruebaLibroCalificaciones.java
*	@author Sergio Romero Barra
*
*	Creates an LibroCalificaciones object and calls its showMessage method.
*/

package com.sergiorb.java_beca_coritel.libro_de_calificaciones;

public class PruebaLibroCalificaciones {

	// Main method
	public static void main(String[] args) {
		
		LibroCalificaciones book = new LibroCalificaciones(); // Object instanciation
		
		book.showMessage();
		book.setWelcomeMessage("Hello over there!!");
		book.showMessage();
		book.setWelcomeMessage("Hello!!");
		book.showMessage();
	}

}
