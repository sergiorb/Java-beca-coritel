/**
*	@file AutoPolicyTest.java
*	@author Sergio Romero Barra
*
*	Tester for AutoPolicy class. Instantiate two objects
*	and calls their printReport methods.
*/

package com.sergiorb.java_beca_coritel.autopolicy;

/** Main class **/
public class AutoPolicyTest {

	/** Main Method **/
	public static void main(String[] args) {
		
		// AutoPolicy objects instantiation.
		AutoPolicy policy00 = new AutoPolicy(11111111, "Camaro", "Ny");
		AutoPolicy policy01 = new AutoPolicy(22222222, "Carger", "CN");
		
		// Calls printReport().
		policy00.printReport();
		policy01.printReport();
	}

}
