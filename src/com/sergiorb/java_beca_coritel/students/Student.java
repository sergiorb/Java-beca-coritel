/**
*	@file Student.java
*	@author Sergio Romero Barra
*
*	Stores student name and its grade.
*/

package com.sergiorb.java_beca_coritel.students;

// Main class
public class Student {

	private String name; // Stores Student`s name.
	private double mark; // Stores student`s mark.
	private String grade; // Stores student`s grade.
	
	// Validates mark value 
	private boolean checkMark(double mark) {
		
		// Mark has to be between 0.0 and 100.0
		if(mark >= 0.0 && mark <= 100.0) {
			return true;
		} else {
			return false;
		}
	}
	
	// getName getter
	public String getName() {
		return name;
	}

	// getName setter
	public void setName(String name) {
		this.name = name;
	}
	
	// getMark getter
	private double getMark() {
		return mark;
	}

	// getMark setter
	private void setMark(double mark) {
		this.mark = mark;
	}
	
	// getGrade getter
	public String getGrade() {
		return grade;
	}

	// getGrade setter
	public void setGrade(String grade) {
		this.grade = grade;
	}

	// Default constructor
	public Student() {
		
		this.setName("Unknown");
		this.setMark(0);
		this.setGrade("Unknown");
	}
	
	// Param mark constructor
	public Student(String name, double mark) {
		
		this.name = name;
		// this.mark = mark
		this.setMark(mark);
		this.setGrade(markToGrade(mark)); // 
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
	
	// Prints in terminal student info
	public void printInform() {
	
		// Format the message.
		String message = String.format("%s, with a mark of %.2f, "
				+ "has a grade of %S\n", getName(), getMark(), getGrade());
		
		// Prints it.
		System.out.println(message);
	}
}
