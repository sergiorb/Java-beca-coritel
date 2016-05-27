/**
*	@file Book.java
*	@author Sergio Romero Barra
*
*	Defines a enum Book class that stores books.
*/

package com.sergiorb.java_beca_coritel.ud8.enumbook;

/** @class declaration */
public enum Book {

	// Constants variables
	JHTP( "Java How to Program" , "2012" ),
	CHTP( "C How to Program" , "2007" ),
	IW3HTP( "Internet & World Wide Web How to Program" , "2008" ),
	CPPHTP( "C++ How to Program" , "2012" ),
	VBHTP( "Visual Basic: 2010 How to Program" , "2011" ),
	CSHARPHTP( "Visual Cll 2010 How to Program", "2011" );
	
	// enum object instance variables that match field
	// defined above.
	private final String title;
	private final String copyrightYear;
	
	Book(String title, String copyrightYear) {
		this.title = title;
		this.copyrightYear = copyrightYear;
	}
	
	/** @return the title */
	public String getTitle() {
		return title;
	}

	/** @return the copyrightYear */
	public String getCopyrightYear() {
		return copyrightYear;
	}
}
