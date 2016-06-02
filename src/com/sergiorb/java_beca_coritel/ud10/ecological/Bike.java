/**
 *	@author Sergio Romero Barra
 *
 *	http://bikeportland.org/2011/12/12/new-study-compares-bicyclings-co2-emissions-to-other-modes-63536
 */

package com.sergiorb.java_beca_coritel.ud10.ecological;

public class Bike implements EcologicalImpact {

	private int passengers;
	private double kilometers;
	private double cO2EmissionValue;
	
	public Bike(int passengers, double kilometers) {
		this.setPassengers(passengers);
		this.setKilometers(kilometers);
		this.setCO2EmissionValue(21.0);
	}
	
	/** @return the passengers */
	public int getPassengers() {
		return passengers;
	}

	/** @param passengers the passengers to set */
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	/** @return the kilometers */
	public double getKilometers() {
		return kilometers;
	}

	/** @param kilometers the kilometers to set */
	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	/** @return the cO2Emission */
	public double getCO2EmissionValue() {
		return cO2EmissionValue;
	}

	/** @param cO2Emission the cO2Emission to set */
	public void setCO2EmissionValue(double cO2EmissionValue) {
		this.cO2EmissionValue = cO2EmissionValue;
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
