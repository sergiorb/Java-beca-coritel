/**
*	@file GradeBookTest.java
*	@author Sergio Romero Barra
*
*	Test GradeBook class
*/

package com.sergiorb.java_beca_coritel.ud7.multidimensionalarray;

// Main class
public class GradeBookTest {

	// Main method
	public static void main(String[] args) {
		
		// Initial grades values. 
		// Each line represents a student. Each column represents a student's grade.
		int[][] studentsGrades = {
				{90,72,5},
				{66,69,64},
				{0,0,0},
				{63,37,56},
				{4,86,23},
				{82,29,41},
				{19,91,98},
				{37,100,99},
				{100,100,100},
				{74,35,55},
		};
		
		// Instances a GradeBook object.
		GradeBook book = new GradeBook(studentsGrades);
		
		System.out.printf("Minumun grade:  %d\n\n", book.getMinimumGrade());
		
		System.out.printf("Maximun grade: %d\n\n", book.getMaximumGrade());
		
		System.out.printf("Class average: %.2f\n\n", book.getClassAverage());
		
		book.outputBarChart();
		
		book.outputGrades();
		
		book.outputStartChar();
	}

}
