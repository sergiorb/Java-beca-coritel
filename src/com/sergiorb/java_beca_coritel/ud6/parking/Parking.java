/**
*	@file Parking.java
*	@author Sergio Romero Barra
*
*	Defines a parking class that stores Car objects, and defines
*	charge rules to use it.
*/

package com.sergiorb.java_beca_coritel.ud6.parking;

import java.util.ArrayList;

public class Parking {
	
	private static double minumPrice = 2.0; // The smaller amount that a car has to pay.
	private static int maxBaseMinutes = 60 * 3; // Minimum hours to be charged in minutes.
	private static double plusPrice = 0.5; // Adding price by hour or fraction of it.
	private static double maxPrice = 10.0; // The higher amount that a car has to pay.
	private static int dayMinutes = 24 * 60; // Minutes of one day.
	private double totalAmount; // Keeps the amount sums of every car in the parking.
	ArrayList<Car> cars; // Holds Car objects that use the parking
	
	// Main constructor
	public Parking() {
		this.cars = new ArrayList<Car>();
	}
	
	// @method add a car object to the parking
	public void addCar(Car car) {
		
		car.setCharge(calculateCharges(car.getHours())); // Sets car charge
		this.cars.add(car); // Stores it
		
	}
	
	// @method Calculates cars charge.
	public static double calculateCharges(double hours) {
		
		int minutes = (int) (hours * 60.0); // car parking usage in minutes.
		double amount = 0.0; // Quantity to be charged.
		
		//System.out.printf("Hours: %f\n", hours);
		//System.out.printf("Minutes: %d\n", minutes);
		
		// If the car has used less than the minimum...
		if(minutes <= maxBaseMinutes) {
			
			amount = minumPrice;
		} else if (minutes >= dayMinutes){
			
			amount = maxPrice;
		} else {
			
			amount = minumPrice; // Adds minimum price
			
			// Assums that any fraction of hour count as a hole hour.
			// Ex:
			// hours = 10.6
			// total hours = 11
			amount += (Math.ceil(hours-maxBaseMinutes/60)) * plusPrice;
			
			/**
			// Ex:
			// hours = 10.6
			// completeHours == 10
			// remaining == 0.6
			int completeHours = (int) hours; // Calculate how many complete hours we have
			double remaining = hours - (double) completeHours; // Calculates the remaining hours we have
			
			// Subtracts the minimum payed hours (maxBaseMinutes divided by 60 minutes)
			// from the total hours and adds to amount
			amount += (completeHours - maxBaseMinutes/60 ) * plusPrice;
		
			// If there is a remaining..
			if(remaining != 0.0) {
				
				// Adds minimum addition price
				amount += plusPrice;
			}**/
		}
		
		return amount;
	}
	
	// Prints an inform
	public void printInform() {
		
		for (Car car : cars) {
			
			totalAmount += car.getCharge();
			
			System.out.printf("Car[%s]:\n  Total amount for %.2f hours "
					+ "is $%.2f\n\n", car.getId(), car.getHours(), car.getCharge());
		}
		
		System.out.printf("The parking has %d cars and a total amount of %.2f\n", cars.size(), totalAmount);

	}
}
