/**
*	@file Override.java
*	@author Sergio Romero Barra
*
*	Defines a square method and override it to pass integers and doubles
*	numbers.
*/

package com.sergiorb.java_beca_coritel.ud6.override;

public class Override {
	
	/** @Method Multiplies a number by itself **/
	public static int square(int number) {
		System.out.printf("Calling square method with integer %d\n", number);
		return number * number;
	}
	
	/** @Method Overridden square with double parameter **/
	public static double square(double number) {
		System.out.printf("Calling square method with double %.2f\n", number);
		return (double) number * number;
	}

	/** @Method Main method **/
	public static void main(String[] args) {

		System.out.printf("The square of number 7 is %d\n", square(7));
		System.out.printf("The square of number 7 is %.2f\n", square(7.5));
	}

}
