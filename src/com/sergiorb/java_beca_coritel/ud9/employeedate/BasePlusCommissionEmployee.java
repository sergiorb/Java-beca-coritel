package com.sergiorb.java_beca_coritel.ud9.employeedate;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	
	protected double baseSalary;
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
			double grossSales, double commissionRate, int year, int month, int dayOfMonth) {
		
		super(firstName, lastName, socialSecurityNumber, grossSales, 
				commissionRate, year, month, dayOfMonth);
	}
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
			double grossSales, double commissionRate, double base, int year, int month, int dayOfMonth) {
		
		super(firstName, lastName, socialSecurityNumber, grossSales, 
				commissionRate, year, month, dayOfMonth);
		
		this.setBaseSalary(base);
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
	
	/** @method add a bonus to base salary */
	public void addBonus(double bonus) {
		
		this.setBaseSalary(this.getBaseSalary() + bonus);
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
				"commission rate", getCommissionRate(), "Base salary is:", getBaseSalary(), "Salary:", getSalary());
	}

	
}
