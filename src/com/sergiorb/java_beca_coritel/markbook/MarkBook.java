/**
*	@file MarkBook.java
*	@author Sergio Romero Barra
*
*	Defines a mark book class that shows a welcome message.
*/

package com.sergiorb.java_beca_coritel.markbook;

public class MarkBook {
	
	// Privates vars to force caller to use get/set method.
	private String welcomeMessage = "Welcome to"; // Welcome message var.
	private int welcomeMessageMinLength = 8; // welocome message min length var
	private String courseName = "Unknown"; // Default value for course name.

	// messageMinLength private getter
	private int getWelcomeMessageMinLength() {
		return welcomeMessageMinLength;
	} // end messageMinLength private getter

	// courseName getter
	public String getCourseName() {
		return courseName;
	} // end courseName getter

	// courseName setter
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	} // end courseName setter

	// welcomeMessage getter.
	public String getWelcomeMessage() {
		
		return welcomeMessage;
	} // end wellcomeMessage getter

	
	// welcomeMessage setter.
	public void setWelcomeMessage(String welcomeMessage) {
		
		// Asserts welcomeMessage is "welcomeMessage_min_length" chars length.
		if(welcomeMessage.length() >= getWelcomeMessageMinLength()) {
			this.welcomeMessage = welcomeMessage;
		} else {
			System.out.printf("Welcome message needs %d characters at least.\n", getWelcomeMessageMinLength());
		}
		
	} // end wellcomeMessage setter

	// Prints showMessage  plus course name.
	public void showMessage() {
		
		System.out.printf("%s %s course.\n", getWelcomeMessage(), getCourseName());
		
	} // end showMessage
}
