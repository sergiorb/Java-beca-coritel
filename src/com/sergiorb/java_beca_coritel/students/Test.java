/**
*	@file Student.java
*	@author Sergio Romero Barra
*
*	Test students class.
*/

package com.sergiorb.java_beca_coritel.students;

// Main class
public class Test {

	// Main mehtod
	public static void main(String[] args) {
		
		// Students instantiation.
		Student student00 = new Student("Jhon", 58.23);
		Student student01 = new Student();
		Student student02 = new Student("Sarah", 70.45);
		
		// Shows students info
		student00.printInform();
		student01.printInform();
		student02.printInform();

	}

}
