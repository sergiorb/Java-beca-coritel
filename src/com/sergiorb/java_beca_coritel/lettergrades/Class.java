/**
*	@file Class.java
*	@author Sergio Romero Barra
*
*	This class accept a MarkGrade array and analyze its content to 
*	present an inform to the user.
*
*	@TOCHECK: Markgrade.markToGrade() should be in this class due the possibility
*	to have different grade rules per class.
*/

package com.sergiorb.java_beca_coritel.lettergrades;

import java.util.ArrayList;

// Main class
public class Class {
	
	// Private object to store grade and quantity together
	private class GradeQuantity {
		
		// Instance GradeQuantity variables
		private String grade;
		private int quantity = 0;
		
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public int getQuantity() {
			return quantity;
		}
		
		// Increment quantity by 1.
		public void incrementQuantity() {
			this.quantity += 1;
		}
	}
	
	// Instances Class variables
	private int totalMarks; // Total number of grades stored.
	private double average; // Average grade from all stored grades.
	private ArrayList<MarkGrade> markGradeList; // MarkGrade object list.
	private ArrayList<GradeQuantity> gradeQuantityList; // GradeQuantity list.
	
	// Main constructor
	public Class() {
		this.setTotalGrades(0);
		this.setAverage(0.0);
		this.markGradeList = new ArrayList<MarkGrade>();
		this.gradeQuantityList = new ArrayList<GradeQuantity>();
	}
	
	private int getTotalGrades() {
		return totalMarks;
	}

	private void setTotalGrades(int totalGrades) {
		this.totalMarks = totalGrades;
	}

	private void setAverage(double average) {
		this.average = average;
	}
	
	//  markGradeList setter.
	public void addMarkGradeArray(ArrayList<MarkGrade> array) {
		
		this.markGradeList = array;
	} // end markGradeList setter
	
	// Checks if there is a GradeQuantity object with the given grade(letter).
	// If so, returns its position on the array. If not, returns -1.
	private int gradeExistInGradeQuantityList(String grade) {
		
		// Iterates over gradeQuantityList
		for (int i = 0; i < gradeQuantityList.size(); i++) {
			
			// If given grade equals to current grade...
			if(gradeQuantityList.get(i).getGrade().equals(grade)) {
				return i; // Returns its position.
			}
		}
		
		return -1;
	}
	
	// Calculate data and sets it in the instance
	private void calculateData() {
		
		// Local variables
		GradeQuantity gradeQuantity;
		
		// Stores the result of gradeExistInGradeQuantityList() to know
		// if we have to create a new GradeQuantity object or update an existing one.
		int result; 
		
		// For each element in markGradeList...
		for (MarkGrade markGrade : markGradeList) {
			
			
			totalMarks += (int) markGrade.getMark(); // Sums marks
			
			result = gradeExistInGradeQuantityList(markGrade.getGrade()); // Sets result
			
			// If grade doesn't exist in the array...
			if(result == -1) {
				
				gradeQuantity = new GradeQuantity(); // Create a new one
				gradeQuantity.setGrade(markGrade.getGrade()); // Sets Grade letter
				gradeQuantity.incrementQuantity(); // Increment quantity for current kind of grade(letter).
				gradeQuantityList.add(gradeQuantity); // Adds to gradeQuantity list
				
			} else { // If there is one already, updates quantity value.
				
				gradeQuantityList.get(result).incrementQuantity();
			}
		}
		
		// Sets instance variables
		setTotalGrades(totalMarks);
		setAverage((double)getTotalGrades()/(double)markGradeList.size());	
	}
	
	// Prints for user instance info
	public void printInform() {
		
		calculateData(); // Calls calculateData to prepare Class data.
		
		System.out.println("Grade Report:");
		System.out.printf("Total of %d grades entered is %d\n", markGradeList.size(), totalMarks);
		System.out.printf("Class average is %.2f\n", average);
		System.out.println("Number of students who recivied each grade:");
		
		// For each element in grade-quantity Object, prints its grade and quantity.
		for (GradeQuantity gradeQuantity : gradeQuantityList) {
			System.out.printf("%s: %d\n", gradeQuantity.getGrade(), gradeQuantity.getQuantity());
		}
	}
}
