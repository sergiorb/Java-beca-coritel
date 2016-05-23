/**
*	@file Circle.java
*	@author Sergio Romero Barra
*
*	Ask user to introduce the radius of a circle and calculates its area.
*/

package com.sergiorb.java_beca_coritel.ud6.circle;

import java.util.Scanner;

/** Main method **/
public class Circle {
	
	/** Calculates the area of a circle **/
	public static double calculateArea(double radious) {
		
		double area;
		
		area = Math.PI * Math.pow(radious, 2);
		//area = Math.PI * (radius * radius);
		
		return area;
	}

	/** Main method **/
	public static void main(String[] args) {
		
		double radius; // Stores radius
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insert radius (cm):");
		radius = input.nextDouble();
		input.close();
		
		System.out.printf("A %.2fcm circle radius has %.2f cm^2", radius, calculateArea(radius));

	}

}
