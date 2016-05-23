/**
*	@file AutoPolicy.java
*	@author Sergio Romero Barra
*
*	Holds Policy characteristics per model, state and accountNumber.
*/

package com.sergiorb.java_beca_coritel.autopolicy;

public class AutoPolicy {

	private int accountNumber; // Policy account number
	private String carModel; // Car that the policy applies to
	private String state; // Two letters state abbreviation 
	
	public AutoPolicy(int accountNumber, String model, String state) {
		
		this.setAccountNumber(accountNumber);
		this.setModel(model);
		this.setState(state);
	}
	
	/** @retun the accountNumber **/
	public int getAccountNumber() {
		return accountNumber;
	}

	/** @param accountNumber the accountNumber to set **/
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/** @return the model **/
	public String getModel() {
		return carModel;
	}

	/** @param model the model to set **/
	public void setModel(String model) {
		this.carModel = model;
	}

	/** @return the state **/
	public String getState() {
		return state;
	}

	/** @param state the state to set **/
	public void setState(String state) {
		
		// Asserts a two letters length state name.
		if(state.length() == 2) {
			this.state = state;
		} else {
			System.out.println("State name has to be two letters length");
		}
		
	}
	
	/** @method Returns whether the state has no-fault insurance. **/
	public boolean isNotFaultState() {
		
		boolean isNotFault;
		
		
		switch (getState().toLowerCase()) {
		case "ma": case "nj": case "ny": case "pa":
			isNotFault = true;
			break;
		default:
			isNotFault = false;
			break;
		}
		
		return isNotFault;
	}
	
	/** @method  prints instance info about its assurance**/
	public void printReport() {
		
		System.out.println("The auto policy:");
		System.out.printf("Account #: %d; Car: %s;\nState %s %s a no-fault state\n\n",
				getAccountNumber(), getModel(), getState(), isNotFaultState()?"is":"is not");
	}
}
