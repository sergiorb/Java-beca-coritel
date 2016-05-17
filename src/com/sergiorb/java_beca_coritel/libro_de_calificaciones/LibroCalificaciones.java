/**
*	@file LibroCalificaciones.java
*	@author Sergio Romero Barra
*
*	Defines a mark book class that shows a welcome message.
*/

package com.sergiorb.java_beca_coritel.libro_de_calificaciones;

public class LibroCalificaciones {
	
	private String welcomeMessage = "Welcome to"; // Welcome message var.
	private int welcomeMessageMinLength = 8; // welocome message min length var

	// welcomeMessage getter.
	public String getWelcomeMessage() {
		
		return welcomeMessage;
	} // end wellcomeMessage getter

	// welcomeMessage setter.
	public void setWelcomeMessage(String welcomeMessage) {
		
		// Asserts welcomeMessage is "welcomeMessage_min_length" chars length.
		if(welcomeMessage.length() >= this.welcomeMessageMinLength) {
			this.welcomeMessage = welcomeMessage;
		} else {
			System.out.printf("Welcome message needs %d characters at least.\n", this.welcomeMessageMinLength);
		}
		
	} // end wellcomeMessage setter

	// Prints showMessage var.
	public void showMessage(String courseName) {
		
		// Checks if courseName have 1 or more chars.
		if(courseName.length() > 0) {
			System.out.printf("%s %s course.\n", this.welcomeMessage, courseName);
		} else {
			System.out.println("You need to enter one ore more characters");
		}
		
	} // end showMessage
}
