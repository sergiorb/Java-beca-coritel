/**
*	@file Student.java
*	@author Sergio Romero Barra
*
*	Stores student name and its marks. Then calculates its grades.
*/

package com.sergiorb.java_beca_coritel.average;

import java.util.ArrayList;

// Main class
public class Student {

	private String name; // Stores Student`s name.
	private ArrayList<Double> marks; // Stores marks
	private double average; // Stores student`s average.
	private String grade; // Stores student`s grade.
	
	// Default constructor
	public Student() {
		
		this.setName("Unknown");
		this.setGrade("Unknown");
		this.marks = new ArrayList<Double>();
	}
	
	// Constructor with name
	public Student(String name) {
		this.name = name;
		this.setGrade("Unknown");
		this.marks = new ArrayList<Double>();
	}
	
	// getName getter
	public String getName() {
		return name;
	}

	// getName setter
	public void setName(String name) {
		this.name = name;
	}
	
	// getAverage getter
	public double getAverage() {
		return average;
	}

	// setAverage getter
	private void setAverage(double average) {
		this.average = average;
	}
	
	// getGrade getter
	public String getGrade() {
		return grade;
	}

	// getGrade setter
	private void setGrade(String grade) {
		this.grade = grade;
	}
	
	// Calculates and set the average mark.
	private void calculateAverage() {
		
		double average = 0.0;
		
		// Iterates over marks array, retrieving each position value
		for (Double mark : marks) {
			average += mark; // Sums mark to previous average
		}
		
		// Stores average on instance variable.
		setAverage(average / marks.size());
	}
	
	// Validates mark value 
	private boolean checkMark(double mark) {
			
		// Mark has to be between 0.0 and 100.0
		if(mark >= 0.0 && mark <= 100.0) {
			return true;
		} else {	
			return false;
		}
	}
	
	// Adds a value to marks array if there is space on it.
	public boolean addMark(double mark) {
		
		if(checkMark(mark)) { // If mark value is correct
				
			marks.add(mark); // Append new mark value to marks array
			calculateAverage(); // Update average value
			setGrade(markToGrade(getAverage()));
			return true;
			
		} else {
			
			System.out.printf("Enter a mark between 0.0 and 100.0\n");
			return false;
		}
	}
	
	// Converts mark(double) to grade(string)
	public String markToGrade(double mark) {
		
		// If mark is a valid value...
		if(checkMark(mark)) {
			if (mark >= 90.0) {
				
				return "A";
			} else if (mark >= 80.0) {
				
				return "B";
			} else if (mark >= 65.0) {
				
				return "C";
			} else {
				
				return "F";
			}
		} else { // ...Return "Value Error"
			
			return "Value Error";
		}
	}	

	// Shows current values of marks array
	public void printMarkArray() {
		
		System.out.print("Marks: [");
		
		// Iterates over marks to show them
		for (int i = 0; i < marks.size(); i++) {
			System.out.printf("%.2f, ", marks.get(i));
		}
		
		System.out.printf("]\n\n");
	}
	
	// Prints in terminal the student`s info.
	public void printInform() {
	
		if(!marks.isEmpty()) {
			
			// Format the message.
			String message = String.format("\n\n%s, with an average of %.2f, "
					+ "has a grade of %S\n", getName(), getAverage(), getGrade());
			
			// Prints it.
			System.out.println(message);
			
			// Calls printMarkArray.
			printMarkArray();
		} else {
			
			System.out.println("No grades were entered");
		}
	}
}
