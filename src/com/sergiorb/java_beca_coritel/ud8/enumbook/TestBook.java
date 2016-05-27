package com.sergiorb.java_beca_coritel.ud8.enumbook;

import java.util.EnumSet;

public class TestBook {

	public static void main(String[] args) {
		
		System.out.println("Show all books:\n");
		for (Book book : Book.values()) {
			System. out. printf( "%-10s%-45s%s\n", book , book.getTitle(), book.getCopyrightYear());
		}

		System.out.println("\nShow a constants range:\n");
		for (Book book: EnumSet.range(Book.JHTP, Book.CPPHTP)) {
			System. out. printf( "%-10s%-45s%s\n", book , book.getTitle(), book.getCopyrightYear());
		}
	}
}
