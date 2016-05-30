/**
*	@file TestBasePlusCommissionEmployee.java
*	@author Sergio Romero Barra
*
*	Test BasePlusCommissionEmployee class. Adds a 100€ bonus if the employee's date of birth
*	equals current month.
*/

package com.sergiorb.java_beca_coritel.ud9.employeedate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

// Main class
public class TestBasePlusCommissionEmployee {
	
	// Main method
	public static void main(String[] args) {
		
		// Employee array list.
		ArrayList<BasePlusCommissionEmployee> employeeArray = new ArrayList<BasePlusCommissionEmployee>();
		// Current date
		GregorianCalendar today = new GregorianCalendar();
		
		// Generate 11 employees..
		for (int i = 0; i < 12; i++) {
			
			// With different month date
			employeeArray.add( new BasePlusCommissionEmployee("Bob", "Lewis", UUID.randomUUID().toString(), 
					5000, .04, 300, 2004, i, 12));
						
			// If today.month equals employee.month, add bonus.
			if(today.get(Calendar.MONTH) == employeeArray.get(i).getDateBirthDay().get(Calendar.MONTH)) {
				employeeArray.get(i).addBonus(100.0);
			}
		}
		

		for (BasePlusCommissionEmployee employee : employeeArray) {
			System.out.println("\nEmployee information obtained by get methods:");
			System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
			System.out.printf("%s %s%n", "Last name is", employee.getLastName());
			System.out.printf("%s %s%n", "Birthday:", employee.getDateBirthDay().getTime());
			System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
			System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
			System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());
			System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());
		}
	}
}