/**
*	@file TestTime.java
*	@author Sergio Romero Barra
*
*	Tests time class overloaded constructor.
*/

package com.sergiorb.java_beca_coritel.ud8.timeoverloaded;

public class TestTime {

	public static void main(String[] args) {

		// Create 5 Time1 objects with different constructor methods
		Time t1 = new Time();
		Time t2 = new Time(02);
		Time t3 = new Time(0, 34);
		Time t4 = new Time(12, 25, 42);
		Time t5 = new Time(t4);

		// Print the times with different formats
		System.out.printf("%s%s\n", t1.displayUniversalTime(), t1.displayStandardTime()); 																							// format
		System.out.printf("%s%s\n", t2.displayUniversalTime(), t2.displayStandardTime()); 																							// format
		System.out.printf("%s%s\n", t3.displayUniversalTime(), t3.displayStandardTime()); 																							// format
		System.out.printf("%s%s\n", t4.displayUniversalTime(), t4.displayStandardTime()); 																							// format
		System.out.printf("%s%s\n", t5.displayUniversalTime(), t5.displayStandardTime());																			// format

	}

}
