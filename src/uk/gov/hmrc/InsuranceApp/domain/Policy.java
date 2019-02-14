package uk.gov.hmrc.InsuranceApp.domain;

import java.util.List;


public abstract class Policy {
	
	protected String address;
	protected byte age;
	protected String name;

	
	
	public Policy(String address, byte age, String name) {
		this.age = age;
		this.name = name;
		this.address = address;

	}
	
	public abstract double getPremium();
	

}
