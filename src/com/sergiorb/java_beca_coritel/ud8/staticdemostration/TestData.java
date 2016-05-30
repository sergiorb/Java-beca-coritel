/**
*	@file TestData.java
*	@author Sergio Romero Barra
*
*	Shows static variables usage
*/

package com.sergiorb.java_beca_coritel.ud8.staticdemostration;

// Main class
public class TestData {

	// Main method
	public static void main(String[] args) {
		
		// Instantiates two objects from data class.
		Data data0 = new Data();
		Data data1 = new Data();
		
		// Shows both objects value.
		System.out.println(data0.getVariable());
		System.out.println(data1.getVariable());
		
		// Changes one object variable.
		data0.setVariable(100);
		
		// Shows again both objects data.
		System.out.println(data0.getVariable());
		System.out.println(data1.getVariable());
		
		// Shows class data.
		System.out.println(Data.getVariable());
	}
}
