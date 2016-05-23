/**
*	@file TestParking.java
*	@author Sergio Romero Barra
*
*	Ask user for introducing parking car periods of time and
*	calculates the charge of every one, then prints an inform.
*/

package com.sergiorb.java_beca_coritel.ud6.parking;

import java.util.Scanner;
import java.util.UUID;

/** Main class **/
public class TestParking {
	
	/** Main method **/
	public static void main(String[] args) {
		
		
		Car car; // Car class object.
		Parking parking = new Parking(); // Parking to store cars
		Scanner input = new Scanner(System.in); // Input user object
		double userInput; // Data loaded from user.
		
		System.out.printf("To exit, introduce -1\n");
		
		do {
			
			System.out.printf("Introduce hours (Ex:4.5):\n");
			userInput = input.nextDouble(); // Asks for a new car time lapse 
			car = new Car(UUID.randomUUID().toString(), userInput); // Generate a new car
			
			parking.addCar(car); // Adds the car to the parking
			
		} while(userInput != -1); // If user input is not -1, ask again.
		
		input.close(); // Close scanner object.
		
		parking.printInform(); // Calls parking object to inform the user.
	}
}
