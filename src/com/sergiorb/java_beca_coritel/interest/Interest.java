package com.sergiorb.java_beca_coritel.interest;
/**
*	@file Interest.java
*	@author Sergio Romero Barra
*
*	Let’s use the for statement to compute compound interest. Consider the following problem:
*	A person invests $1,000 in a savings account yielding 5% interest. Assuming that all the 
*	interest is left on deposit, calculate and print the amount of money in the account at the 
*	end of each year for 10 years. Use the following formula to determine the amounts:
*	a = p (1 + r)^n
*
*	where:
*
*	p is the original amount invested (i.e., the principal)
*	r is the annual interest rate (e.g., use 0.05 for 5%)
*	n is the number of years
*	a is the amount on deposit at the end of the nth year.
*	
*	The solution to this problem involves a loop that performs the indicated calculation 
*	for each of the 10 years the money remains on deposit.
*/

// Main class
public class Interest {

	// Main method
	public static void main(String[] args) {
		
		// Variables declaration
		double interest = 0.05;
		double amountInvested = 1000.0;
		double deposit = 0.0;
		int toYear = 10;
		
		System.out.println("Year    Amount on deposit");
		
		// From year 1 to 1, calculate amount on deposit
		// There is other way to calculate it without Marh.pow [search]
		for(int year=1; year <= toYear; year++) {
			
			deposit = amountInvested *  Math.pow(1.0 + interest, year);
			 
			System.out.printf("  %2d    %,.2f\n", year, deposit); // Prints output
		}

	}

}
