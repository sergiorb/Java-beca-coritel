/**
*	@file GradeBook.java
*	@author Sergio Romero Barra
*
*	Stores a class grades bidimensional array and analyze it.
*	Provides method for printing data about the class.
*/

package com.sergiorb.java_beca_coritel.ud7.multidimensionalarray;

// Main class
public class GradeBook {

	private int[][] studentsGrades; // Stores student's grades
	private int[] gradesByRange = new int[11]; // Stores grade range amount.

	/** @constructor main constructor */
	public GradeBook(int[][] studentsGrades) {
		this.setStudentsGrades(studentsGrades); // Sets student-grade array
		this.analyzeGrades(); // Analyzes data on object instantiation.
	}
	
	/** @return getStudentsGrades getter */
	public int[][] getStudentsGrades() {
		return studentsGrades;
	}

	/** @setter setStudentsGrades */
	public void setStudentsGrades(int[][] studentsGrades) {
		this.studentsGrades = studentsGrades;
	}

	/** @return getGradesByRange */
	public int[] getGradesByRange() {
		return gradesByRange;
	}

	/** @setter getGradesByRange */
	public void setGradesByRange(int[] gradesByRange) {
		this.gradesByRange = gradesByRange;
	}
	
	/** @return the minimum grade value on the array */
	public int getMinimumGrade() {

		int minimun = studentsGrades[0][0];

		// For every grade in the array...
		for (int i = 0; i < studentsGrades.length; i++) {
			for (int j = 0; j < studentsGrades[j].length; j++) {
				
				// If current value is smaller than the current minimum...
				if (minimun > studentsGrades[i][j]) {
					minimun = studentsGrades[i][j]; // Sets a new minimum
				}
			}
		}

		return minimun;
	}

	/** @return the maximum grade value on the array */
	public int getMaximumGrade() {

		int maximum = studentsGrades[0][0];

		// For every grade in the array...
		for (int i = 0; i < studentsGrades.length; i++) {
			for (int j = 0; j < studentsGrades[j].length; j++) {

				// If current value is greater than the current minimum...
				if (maximum < studentsGrades[i][j]) {
					maximum = studentsGrades[i][j];
				}
			}
		}

		return maximum;
	}

	/** @returns the average by row position in the array */
	public double getStudentAverage(int position) {

		double average = 0.0;

		// For every student's grade...
		for (int i = 0; i < studentsGrades[position].length; i++) {
			average += studentsGrades[position][i]; // Sums value.
		}

		average /= studentsGrades[position].length; // divide value by number of elements

		return average;
	}

	/** @return average in a range from 1 to 10 */
	private int averageToStarts(double average) {

		int starts = 0;

		starts = (int) Math.ceil(average / 10.0);

		return starts;
	}

	/** @return total class average */
	public double getClassAverage() {

		double average = 0.0;
		int i;
		
		// For every student, retrieves its average..
		for (i = 0; i < studentsGrades.length; i++) {
			average += getStudentAverage(i);// ...and sums it to average.
		}

		average /= i; // And divides by total students

		return average;
	}

	/** @method Prints students grades in a range of 0 to 10 starts. */
	public void outputStartChar() {

		System.out.println("Printing students grades in a range of 0 to 10 starts:");

		for (int i = 0; i < studentsGrades.length; i++) {

			System.out.printf("Student %2d: ", i + 1);
			int j;
			for (j = 0; j < averageToStarts(getStudentAverage(i)); j++) {
				System.out.printf("%2s ", "*");
			}

			for (int e = 0; e < 10 - j; e++) {
				System.out.printf("%2s ", "0");
			}

			System.out.println();
		}

		System.out.println();
	}

	/** @method Analyze array data to sets the amount of each grade in studentsGrades array. */
	private void analyzeGrades() {

		int value;

		for (int i = 0; i < studentsGrades.length; i++) {
			for (int j = 0; j < studentsGrades[i].length; j++) {

				value = studentsGrades[i][j];

				// ++gradesByRange[value/10]
				
				if (value == 100) {
					gradesByRange[10]++;
				} else if (value >= 90) {
					gradesByRange[9]++;
				} else if (value >= 80) {
					gradesByRange[8]++;
				} else if (value >= 70) {
					gradesByRange[7]++;
				} else if (value >= 60) {
					gradesByRange[6]++;
				} else if (value >= 50) {
					gradesByRange[5]++;
				} else if (value >= 40) {
					gradesByRange[4]++;
				} else if (value >= 30) {
					gradesByRange[3]++;
				} else if (value >= 20) {
					gradesByRange[2]++;
				} else if (value >= 10) {
					gradesByRange[1]++;
				} else {
					gradesByRange[0]++;
				}
			}
		}
	}

	/** @method Prints grades amount by range */
	public void outputBarChart() {

		System.out.println("Printing grades amount by range:");

		for (int i = 0; i < gradesByRange.length; i++) {

			if (i == gradesByRange.length - 1) {
				System.out.printf("  100: ");
			} else {
				System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
			}

			for (int j = 0; j < gradesByRange[i]; j++) {
				System.out.printf("* ");
			}

			System.out.println();
		}

		System.out.println();
	}

	/** @method Prints a class info matrix */
	public void outputGrades() {

		System.out.println("Student        Grades      Average");
		
		// For every row...
		for (int i = 0; i < studentsGrades.length; i++) {
			System.out.printf("#%2d:    ", i+1);
			
			// loop over every column...
			for (int j = 0; j < studentsGrades[i].length; j++) {
				System.out.printf("%5d ", studentsGrades[i][j]);
			}
			
			System.out.printf("%7.2f", getStudentAverage(i));
			System.out.println(); // Jumps at the end of every row.
		}

		System.out.println(); // Jumps at the end of the matrix

	}
}
