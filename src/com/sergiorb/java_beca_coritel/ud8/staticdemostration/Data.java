/**
*	@file Data.java
*	@author Sergio Romero Barra
*
*	Stores a static class variable
*/

package com.sergiorb.java_beca_coritel.ud8.staticdemostration;

/** @class Data */
public class Data {
	
	// Static variable
	private static int variable = 10;

	/** @return the variable */
	public static int getVariable() {
		return variable;
	}

	/** @param variable the variable to set */
	public static void setVariable(int variable) {
		Data.variable = variable;
	}
	
}

