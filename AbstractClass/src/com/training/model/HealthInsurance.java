package com.training.model;

public class HealthInsurance extends Insurance {

	 private String[] preExistingDiseases;
	 
	
	
	
	public HealthInsurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HealthInsurance(int policyNumber, String policyHolderName, String[] preExistingDiseases) {
		super(policyNumber, policyHolderName);
		this.preExistingDiseases = preExistingDiseases;
	}

	public HealthInsurance(int policyNumber, String policyHolderName) {
		super(policyNumber, policyHolderName);
		// TODO Auto-generated constructor stub
	}



	@Override
	public double calculatePremium() {

		double premium = 1000;
		
		for(String eachItem : preExistingDiseases) {
			if(eachItem.equalsIgnoreCase("BP") || eachItem.equalsIgnoreCase("sugar") ) {
				premium = 15000;
			}
		}
		
		return premium;
	}

}
