/**
*	@file TestBook.java
*	@author Sergio Romero Barra
*
*	Shows enum Book class usage.
*/

package com.sergiorb.java_beca_coritel.ud8.enumbook;

import java.util.EnumSet;

/** @class main */
public class TestBook {

	/** @method main */
	public static void main(String[] args) {
		
		
		System.out.println("Show all books:\n");
		for (Book book : Book.values()) { // Retrieves all enum constants 
			System. out. printf( "%-10s%-45s%s\n", book , book.getTitle(), book.getCopyrightYear());
		}

		System.out.println("\nShow a constants range:\n");
		// Retrieves all values in Book class between JHTP and CPPHTP constant.
		// This is possible due its(Book enum) inheritance from set class .
		for (Book book: EnumSet.range(Book.JHTP, Book.CPPHTP)) { 
			System. out. printf( "%-10s%-45s%s\n", book , book.getTitle(), book.getCopyrightYear());
		}
	}
}
