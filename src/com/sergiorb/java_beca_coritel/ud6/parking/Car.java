/**
*	@file Car.java
*	@author Sergio Romero Barra
*
*	Defines a car object to store the car id, how much
* 	time it has been on the park and how much money it has to pay. 
*/

package com.sergiorb.java_beca_coritel.ud6.parking;

/** Main class **/
public class Car {
	
	private String id; // Identification
	private double hours; // How much time it has been on the parking.
	private double charge; // How much money it has to pay.
	
	/** @method Main constructor **/
	public Car(String id, double hours) {
		this.setId(id);
		this.setHours(hours);
	}

	/** @method id getter **/
	public String getId() {
		return id;
	}

	/** @method id setter **/
	public void setId(String id) {
		this.id = id;
	}

	/** @method hours getter **/
	public double getHours() {
		return hours;
	}

	/** @method hours setter **/
	public void setHours(double hours) {
		this.hours = hours;
	}

	/** @method charge getter **/
	public double getCharge() {
		return charge;
	}

	/** @method charge setter **/
	protected void setCharge(double charge) {
		this.charge = charge;
	}
}
