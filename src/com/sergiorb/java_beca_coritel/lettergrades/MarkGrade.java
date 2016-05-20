/**
*	@file MarkGrade.java
*	@author Sergio Romero Barra
*
*	Defines an object that store a mark and its pertinent grade.
*
*	@TOCHECK: markToGrade() should be in Class class due the possibility
*	to have different grade rules per class.
*/

package com.sergiorb.java_beca_coritel.lettergrades;

// Main class
public class MarkGrade {
	
	// Instance variables
	double mark;
	String grade;
	
	// Main constructor
	public MarkGrade() {
		this.mark = 0.0;
		this.grade = "Unknown";
	}
	
	// Constructor with mark param
	public MarkGrade(double mark) {
		
		this.setMark(mark);
		// Calculate grade on object instantiation
		this.setGrade(markToGrade(mark));
	}

	public double getMark() {
		return mark;
	}

	// Establish mark and calculates its grade
	public void setMark(double mark) {
		this.mark = mark;
		this.setGrade(markToGrade(mark));
	}

	public String getGrade() {
		return grade;
	}

	private void setGrade(String grade) {
		this.grade = grade;
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
	
	// Converts mark(double) to grade(string)
	public String markToGrade(double mark) {
			
		// If mark is a valid value...
		if(checkMark(mark)) {
			if (mark >= 90.0) {
				
				return "A";
			} else if (mark >= 80.0) {
				
				return "B";
			} else if (mark >= 70.0) {
					
				return "C";
			} else if (mark >= 60.) {
				
				return "D";
			} else {
				
				return "F";
			}
		} else { // ...Return "Value Error"
				
				return "Value Error";
		}
	}
}