/**
 *	@author Sergio Romero Barra
 *
 *	http://bikeportland.org/2011/12/12/new-study-compares-bicyclings-co2-emissions-to-other-modes-63536
 */

package com.sergiorb.java_beca_coritel.ud10.ecological;

public class Car implements EcologicalImpact {

	private int passengers;
	private double kilometers;
	private double CO2EmissionValue;
	
	public Car(int passengers, double kilometers) {
		this.setKilometers(kilometers);
		this.setPassengers(passengers);
		this.setCO2EmissionCO2Value(271.0);
	}
	
	/** @return the passengers */
	public int getPassengers() {
		return passengers;
	}

	/** @param passengers the passengers to set */
	private void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	/** @return the kilometers */
	public double getKilometers() {
		return kilometers;
	}

	/** @param kilometers the kilometers to set */
	private void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	/** @return the cO2Emission */
	public double getCO2EmissionValue() {
		return CO2EmissionValue;
	}

	/** @param cO2Emission the cO2Emission to set */
	private void setCO2EmissionCO2Value(double cO2EmissionValue) {
		this.CO2EmissionValue = cO2EmissionValue;
	}

	@Override
	public double calculateEcologicalImpact() {
		
		double impact = this.getPassengers() * this.getKilometers() * this.getCO2EmissionValue();
		
		System.out.printf("# %s -----------------\n", this.getClass().getSimpleName());
		System.out.printf("# Passengers: %d\n", this.getPassengers());
		System.out.printf("# Kilometers: %.2f\n", this.getKilometers());
		System.out.printf("# Ecological impact: %,.2f gr\n\n", impact);
		
		
		return this.getPassengers() * this.getKilometers() * this.getCO2EmissionValue();
	}
}
