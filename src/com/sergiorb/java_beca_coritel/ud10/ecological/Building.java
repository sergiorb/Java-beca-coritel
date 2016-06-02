/**
 *	@author Sergio Romero Barra
 *
 *	http://bikeportland.org/2011/12/12/new-study-compares-bicyclings-co2-emissions-to-other-modes-63536
 */

package com.sergiorb.java_beca_coritel.ud10.ecological;

public class Building implements EcologicalImpact {

	private double electrycityConsumption;
	private double gasConsumption;
	private double fuelConsumption;
	private double lpgConsumption;
	private double wasteConsumption;
	private double waterConsumption;
	private double cO2EmissionValue;
	
	public Building(double electrycityConsumption, double gasConsumption, 
			double fuelConsumption, double lpgConsumption, double wasteConsumption,
			double waterConsumption) {
		
		this.setElectrycityConsumption(electrycityConsumption);
		this.setGasConsumption(gasConsumption);
		this.setFuelConsumption(fuelConsumption);
		this.setLpgConsumption(lpgConsumption);
		this.setWasteConsumption(wasteConsumption);
		this.setWaterConsumption(waterConsumption);
	}

	/** @return the electrycityConsumption */
	private double getElectrycityConsumption() {
		return electrycityConsumption;
	}

	/** @param electrycityConsumption the electrycityConsumption to set */
	private void setElectrycityConsumption(double electrycityConsumption) {
		this.electrycityConsumption = electrycityConsumption;
	}

	/** @return the gasConsumption */
	private double getGasConsumption() {
		return gasConsumption;
	}

	/** @param gasConsumption the gasConsumption to set */
	private void setGasConsumption(double gasConsumption) {
		this.gasConsumption = gasConsumption;
	}

	/** @return the fuelConsumption */
	private double getFuelConsumption() {
		return fuelConsumption;
	}

	/** @param fuelConsumption the fuelConsumption to set */
	private void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	/** @return the lpgConsumption */
	private double getLpgConsumption() {
		return lpgConsumption;
	}

	/** @param lpgConsumption the lpgConsumption to set */
	private void setLpgConsumption(double lpgConsumption) {
		this.lpgConsumption = lpgConsumption;
	}

	/** @return the wasteConsumption */
	private double getWasteConsumption() {
		return wasteConsumption;
	}

	/** @param wasteConsumption the wasteConsumption to set */
	private void setWasteConsumption(double wasteConsumption) {
		this.wasteConsumption = wasteConsumption;
	}

	/** @return the waterConsumption */
	private double getWaterConsumption() {
		return waterConsumption;
	}

	/** @param waterConsumption the waterConsumption to set */
	private void setWaterConsumption(double waterConsumption) {
		this.waterConsumption = waterConsumption;
	}

	/** @return the cO2EmissionValue */
	private double getcO2EmissionValue() {
		return cO2EmissionValue;
	}

	/**  @param cO2EmissionValue the cO2EmissionValue to set */
	private void setcO2EmissionValue(double cO2EmissionValue) {
		this.cO2EmissionValue = cO2EmissionValue;
	}

	@Override
	public double calculateEcologicalImpact() {
		// TODO Auto-generated method stub
		return 0;
	}

}
