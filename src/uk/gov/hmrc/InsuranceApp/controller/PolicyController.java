package uk.gov.hmrc.InsuranceApp.controller;

import uk.gov.hmrc.InsuranceApp.domain.PolicyException;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.AddressType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.CarType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.StorageType;

public class PolicyController {

	// 1. User enters a name
	// 2. System prompts user for age
	// 3. System prompts user for years driving experience
	// 4. Choose your address type A - England, B - Scotland, C - Wales
	// 5. How many years no claims
	// 6. Medical history Y/N/
	// 7. How do you store it
	// 8. Make and Model
	// 9. points on licence

	private static final byte MIN_DRIVING_AGE = 17;
	private static final byte MAX_DRIVING_AGE = 80;
	private static final byte MAX_NOCLAIMS = 10;
	private static String unknownTypeMessage;
	private  byte age;
	private byte yearsDriving;
	private String name;
	private byte noClaims;
	private boolean hasMedicalHistory;
	private StorageType storageType;
	private AddressType addressType;
	private CarType carType;
	private boolean hasPoints;

	public void setCarType(String make, String model) {
		// Make sure that the 2 strings are not nulls
		this.carType = CarType.UNKNOWN;
		try {
			StringBuilder sb = new StringBuilder(make);
			this.carType = CarType.valueOf(sb.append(model).toString().toUpperCase());
		} catch (IllegalArgumentException e) {
			setUnknownTypeMessage("car");
		}
	
	}


	public void setYearsNoClaims(byte years) {
		if (!(0 <= years && years <= MAX_NOCLAIMS))
			throw new PolicyException("Invalid no claims");
		this.noClaims = noClaims;
	}

	public void setMedicalHistory(String answer) {
		this.hasMedicalHistory = getYesNoAnswer(answer);
	}
	
	public void setPoints(String answer) {
		this.hasPoints = getYesNoAnswer(answer);
	}

	public boolean getYesNoAnswer(String answer) {
		// Check that the answer is not null
		// normalise the answer
		// map to either true or false
		boolean hasMedicalHistory = false;
		if (answer == null) {
			throw new PolicyException("Please provide a valid medical history answer");
		} else {
			String a = answer.toUpperCase();
			if (a.equals("YES") || a.equals("Y")) {
				hasMedicalHistory = true;
			}
		}
		return hasMedicalHistory;
	}

	public void setStorageType(String storage) {
		this.storageType = StorageType.UNKNOWN;
		try {
			this.storageType = StorageType.valueOf(storage.toUpperCase());
		} catch (IllegalArgumentException e) {
			setUnknownTypeMessage("storage");
		}
		
	}

	public void setUserName(String userName) {

		if (userName == null) {
			throw new PolicyException("A valid name is required for a policy quote");

		}
		checkForWhiteSpace(userName);
		this.name = userName.toUpperCase();
	}

	public void setYearsDrivingExperience(byte years) {
		if (0 >= years && years <= (MAX_DRIVING_AGE - MIN_DRIVING_AGE))
			throw new PolicyException("You must have at least 1 - 63 years driving experience");
		this.yearsDriving = years;
	}

	public void setAddressType(String addressType) {
		AddressType addType = AddressType.UNKNOWN;
		try {
			addType = AddressType.valueOf(addressType.toUpperCase());
		} catch (IllegalArgumentException e) {
			setUnknownTypeMessage(" address type");
		}
		this.addressType = addType;
	}

	private void setUnknownTypeMessage(String message) {

		unknownTypeMessage = "The " + message
				+ "provided is unknown. Please contact customer services to get an accurate quote";
	}

	public void setAge(byte age) {
		if (!(age >= MIN_DRIVING_AGE && MAX_DRIVING_AGE <= 80))
			throw new PolicyException("The valid age range for a policy is 17-80");
		this.age = age;
	}

	public static void checkForWhiteSpace(String userName) {

		char[] contents = userName.toCharArray();
		boolean allWhiteSpace = true;
		for (char c : contents) {
			if (c != ' ') {
				allWhiteSpace = false;
				break;
			}
		}

		if (allWhiteSpace)
			throw new PolicyException("A valid name is required for a policy quote");
	}

	public double getPremium() {

		VehiclePolicy myPolicy = new VehiclePolicy(name, age, yearsDriving, noClaims, hasMedicalHistory, storageType, addressType,
				carType, hasPoints);

		return myPolicy.getPremium();
	}

	public double processRequest(String name2, byte age2, String make, String model, byte yearsDriving2, byte noClaims2,
			String hasMedicalHistory2, String storage, String address, String hasPoints2) {
		setUserName(name2);
		setAge(age2);
		setCarType(make, model);
		setYearsDrivingExperience(yearsDriving2);
		setYearsNoClaims(noClaims2);
		setMedicalHistory(hasMedicalHistory2);
		setStorageType(storage);
		setAddressType(address);
		setPoints(hasPoints2);
		saveQuote();
		return getPremium();
		
		
	}
	
	private void saveQuote() {
		
	}
}
