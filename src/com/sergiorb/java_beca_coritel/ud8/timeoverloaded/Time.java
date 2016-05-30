/**
*	@file Time.java
*	@author Sergio Romero Barra
*
*	Defines a time object.
*/

package com.sergiorb.java_beca_coritel.ud8.timeoverloaded;

public class Time {

	// Variable declarations
	private int hour;
	private int minute;
	private int second;

	// Default constructor
	public Time() {
		this.setTime(00, 00, 00);

	}

	// Constructor with hours
	public Time(int hour) {

		this.setTime(hour, 0, 0);
	}

	// Constructor with hours and minutes
	public Time(int hour, int minute) {
		this.setTime(hour, minute, 0);
	}

	// Constructor with hours, minutes and seconds
	public Time(int hour, int minute, int second) {

		this.setTime(hour, minute, second);
	}

	// Constructor with Time1 object
	public Time(Time time) {

		this.setTime(time.getHour(), time.getMinute(), time.getSecond());

	}

	// Getters and Setters
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	// End Setters and Getters

	// Method Set Time
	public void setTime(int hour, int minute, int second) {

		// Check that time is in the correct range
		if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) {
			throw new IllegalArgumentException("Hour, minute and seconds have to be in range");
		}

		this.setHour(hour); // Set hour
		this.setMinute(minute); // Set minute
		this.setSecond(second); // Set second
	} // End set time method

	// Display time in universal format
	public String displayUniversalTime() {

		return String.format("The time is: %02d:%02d:%02d%n", this.getHour(), 
				this.getMinute(), this.getSecond());
	} // End displayUniversalTime method

	// Display time in standard format
	public String displayStandardTime() {

		return String.format("The time is: %d:%02d:%02d %s%n", 
				(this.getHour() % 12 == 0) ? 12 : this.getHour() % 12,
				// Print hours from 1-12 by using mod12
				this.getMinute(), 
				// Add AM or PM depending on the hour
				this.getSecond(), (this.getHour() < 12) ? "AM" : "PM"); 
	} // End displayStandardTime method

} // End class
