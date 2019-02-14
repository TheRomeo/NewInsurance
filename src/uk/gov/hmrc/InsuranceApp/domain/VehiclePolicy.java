package uk.gov.hmrc.InsuranceApp.domain;


import uk.gov.hmrc.InsuranceApp.data.PolicyData;

public class VehiclePolicy {

	// declaring enums are like final arrays / methods

	public enum AddressType {
		A, B, C, UNKNOWN
	}

	public enum StorageType {
		ONSTREET, DRIVE, GARAGE, UNKNOWN
	}

	public enum CarType {
		VAUXHALLASTRA, FORDMONDEO, CITROENXSARA, UNKNOWN
	}

	// all the variant types needed for the code
	String name;
	byte age;
	byte yearsDriving;
	byte noClaims;
	boolean hasMedicalHistory;
	AddressType addressType;
	CarType carType;
	StorageType storageType;
	boolean hasPoints;

	// Define a constructor for instantiation
	public VehiclePolicy(String name, byte age, byte yearsDriving, byte noClaims, boolean hasMedicalHistory,
			StorageType storageType, AddressType addressType, CarType carType, boolean hasPoints) {

		// initialisation of your fields
		this.name = name;
		this.age = age;
		this.yearsDriving = yearsDriving;
		this.noClaims = noClaims;
		this.hasMedicalHistory = hasMedicalHistory;
		this.addressType = addressType;
		this.carType = carType;
		this.storageType = storageType;
		this.hasPoints = hasPoints;

	}


	// first ageFactor will be 1.05 * basePremium (between 17 and 25)
	private double getAgeFactor() {
		// 17 - 25 -> 1.05
		// 26 - 35 -> 0.85
		// 35 - 50 -> 1
		double ageFactor = 0;
		if (age >= 17 && age <= 25) {
			ageFactor = 1.05;
		} else if (age >= 26 && age <= 35) {
			ageFactor = 0.85;
		} else if (age >= 36 && age <= 50) {
			ageFactor = 1;
		} else {
			throw new IllegalArgumentException("Age was out of range. " + "The age provided was " + age
					+ "Valid ranges are " + "17 - 25, 26 - 35, 36 - 50");
		}

		return ageFactor;

	}

	// years driving similar to how age factor was set

	private double getYearsFactor() {
		double yearsFactor = 0;
		if (yearsDriving >= 0 && yearsDriving <= 9) {
			yearsFactor = 1.2;
		} else if (yearsDriving >= 10 && yearsDriving <= 19) {
			yearsFactor = 0.8;
		} else if (yearsDriving >= 20 && yearsDriving <= 50) {
			yearsFactor = 0.75;
		} else {
			throw new IllegalArgumentException("Years driving was out of range " + "The amount of years provided was "
					+ yearsDriving + "Valid ranges are " + "0 - 9, 10 - 19 and 20 - 50");
		}

		return yearsFactor;

	}


	private double getNoClaimsFactor() {
		double noClaimsFactor = 0;
		if (noClaims >= 0 && noClaims <= 1) {
			noClaimsFactor = 1.2;
		} else if (noClaims >= 10 && noClaims <= 19) {
			noClaimsFactor = 0.8;
		} else if (noClaims >= 20 && noClaims <= 50) {
			noClaimsFactor = 0.75;
		} else {
			throw new IllegalArgumentException("No claims was out of range " + "The amount of no claims provided was "
					+ noClaims + "Valid ranges are " + "0 - 1, 2 - 5 and 6+");
		}

		return noClaimsFactor;
	}

	private double getMedicalFactor() {
		return hasMedicalHistory ? 1.15 : 1;

	}


	private double getPointsFactor() {
		return hasPoints ? 1.25 : 1;

	}

	public double getPremium() {
		return PolicyData.getPremium(carType) * getAgeFactor() * getMedicalFactor()
				* PolicyData.getStorageFactor(storageType) * PolicyData.getAddressFactor(addressType) * getPointsFactor() * getYearsFactor();

	}

}
