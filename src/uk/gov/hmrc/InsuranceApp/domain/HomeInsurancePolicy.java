package uk.gov.hmrc.InsuranceApp.domain;

import java.util.List;

import uk.gov.hmrc.InsuranceApp.data.PolicyData;

public class HomeInsurancePolicy extends Policy {
	
	public enum Ownership {
		RENTED, OWNED
	}
	
	public enum ConstructionType{
		BRICK, STRAW, WOOD
	}
	
	public enum PropertyType {
		FLAT, BUNGALOW, DETACHED, SEMIDETACHED
	}

	private ConstructionType constructiontype;
	private PropertyType propertyType;
	private Ownership ownership;
	private byte numberOfOccupants;
	private boolean hasFloodingHistory;
	
	
	
	public HomeInsurancePolicy(String address, byte age, String name) {
		super(address, age, name);
		// TODO Auto-generated constructor stub
	}
	
	//this is know as a mutator or a setter
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	
	public void setOwnership(Ownership ownership) {
		this.ownership = ownership;
	}
	
	public void setConstructiontype(ConstructionType constructiontype) {
		this.constructiontype = constructiontype;
	}
	
	

	@Override
	public double getPremium() {
		double cFactor = PolicyData.getConstructionFactor(constructiontype);
		double basePremium = PolicyData.getPropertyPremium(propertyType);
		double oFactor = PolicyData.getOwnershipFactor(ownership);
		return cFactor * basePremium * oFactor;
	}
	
	

}
