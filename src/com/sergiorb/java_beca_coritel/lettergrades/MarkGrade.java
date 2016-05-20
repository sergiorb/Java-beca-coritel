package com.sergiorb.java_beca_coritel.lettergrades;

public class MarkGrade {
	
	double mark;
	String grade;
	
	public MarkGrade() {
		this.mark = 0.0;
		this.grade = "Unknown";
	}
	
	public MarkGrade(double mark) {
		this.setMark(mark);
		this.setGrade(markToGrade(mark));
	}

	public double getMark() {
		return mark;
	}

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
			} else if (mark >= 65.0) {
					
				return "C";
			} else {
				
				return "F";
			}
		} else { // ...Return "Value Error"
				
				return "Value Error";
		}
	}
}