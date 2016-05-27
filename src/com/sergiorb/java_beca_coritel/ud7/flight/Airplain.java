package com.sergiorb.java_beca_coritel.ud7.flight;

public class Airplain {

	private boolean seats[];
	private int amountFirstClassSeats;
	private boolean airplainWellDesigned;
	
	/** @constructor main */
	public Airplain() {
		this.setSeats(new boolean[10]);
		this.setAmountFirstClassSeats(5);
		this.setAirplainWellDesigned(true);
	}
	
	/** @constructor seats */
	public Airplain(int totalSeats, int firstClassSeats) {
		
		if(totalSeats > firstClassSeats) {
			this.setSeats(new boolean[totalSeats]);
			this.setAmountFirstClassSeats(firstClassSeats);
			this.setAirplainWellDesigned(true);
		} else {
			this.setAirplainWellDesigned(false);
			System.out.println("You can't assing more first-class seats"
					+ " than the total number of seats!.");
		}
	}

	/** @return the seats */
	private boolean[] getSeats() {
		return seats;
	}

	/** @param seats the seats to set */
	private void setSeats(boolean[] seats) {
		this.seats = seats;
	}

	/** @return the amountFirstClassSeats */
	public int getAmountFirstClassSeats() {
		return amountFirstClassSeats;
	}

	/** @param amountFirstClassSeats the amountFirstClassSeats to set */
	public void setAmountFirstClassSeats(int amountFirstClassSeats) {
		this.amountFirstClassSeats = amountFirstClassSeats;
	}
	
	/**
	 * @return the airplainWellDesigned
	 */
	private boolean isAirplainWellDesigned() {
		return airplainWellDesigned;
	}

	/**
	 * @param airplainWellDesigned the airplainWellDesigned to set
	 */
	private void setAirplainWellDesigned(boolean airplainWellDesigned) {
		this.airplainWellDesigned = airplainWellDesigned;
	}

	public boolean requestSeat(int sectionClass) {
		
		if(isAirplainWellDesigned()) {
			
			if(sectionClass == 1){
				for (int i = 0; i < amountFirstClassSeats; i++) {
					if(seats[i] != true) {
						seats[i] = true;
						printTicket(i, "First");
						return true;
					}
				}
				System.out.println("There is no space in first class.");
			} else if (sectionClass == 2) {
				for (int i = amountFirstClassSeats; i < seats.length; i++) {
					if(seats[i] != true) {
						seats[i] = true;
						printTicket(i, "Economic");
						return true;
					}
				}
				System.out.println("There is no space in Economic class.");
			} else {
				System.out.println("That class doesn't exist.");
			}
		}
		
		return false;
	}
	
	public void printTicket(int seatNumber, String className) {
		
		System.out.printf("#####################\n");
		System.out.printf("# Seat Number:   %2d #\n", seatNumber+1);
		System.out.printf("# Class:   %8s #\n", className);
		System.out.printf("#####################\n");
	}
	
	
	public void printFligtStatus() {
		
		System.out.printf("%s First Class %s\n", "=========", "===========");
		
		for (int i = 0; i < amountFirstClassSeats; i++) {
			System.out.printf("%s \n",seats[i]);
		}
		
		System.out.printf("%s Economic Class %s\n", "========", "=========");
		
		for (int i = amountFirstClassSeats; i < seats.length; i++) {
			System.out.printf("%s \n", seats[i]);
		}
	}
}
