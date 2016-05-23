/**
*	@file TestMath.java
*	@author Sergio Romero Barra
*
*	Tests Static classes call (with Math class).
*/

package com.sergiorb.java_beca_coritel.ud6.testmath;

/** Main Class **/
public class TestMath {
	
	/** Main method **/
	public static void main(String[] args) {
	
		System.out.printf("Math.PI = %f\n", Math.PI);
		System.out.printf("Math.abs(-15.8) = %.2f\n", Math.abs(-15.8));
		System.out.printf("Math.random() = %.2f\n", Math.random());
		System.out.printf("Math.ceil(9.2) = %.2f\n", Math.ceil(9.2));
		System.out.printf("Math.max(9.2, -11.5) = %.2f\n", Math.max(9.2, -11.5));
		System.out.printf("Math.sin(90.5) = %.2f\n", Math.sin(90.5));
	}

}
