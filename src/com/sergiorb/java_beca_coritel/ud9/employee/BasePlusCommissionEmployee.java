package com.sergiorb.java_beca_coritel.ud9.employee;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	
	protected double baseSalary;
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
			double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
	}
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
			double grossSales, double commissionRate, double base) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
	}
	
	/** @return the baseSalary */
	public double getBaseSalary() {
		return baseSalary;
	}

	/** @param baseSalary the baseSalary to set */
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	/** @return final salary. */
	public double getSalary() {
		
		return getBaseSalary() + (getGrossSales() * getCommissionRate());
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
				"commission rate", getCommissionRate(), "Base salary is:", getBaseSalary(), "Salary:", getSalary());
	}

	
}
