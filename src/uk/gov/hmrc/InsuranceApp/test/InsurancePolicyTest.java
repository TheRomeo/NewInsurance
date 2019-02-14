package uk.gov.hmrc.InsuranceApp.test;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.AddressType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.CarType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.StorageType;

class InsurancePolicyTest {

	@Before
	void setUp() throws Exception {
	}

	@After
	void tearDown() throws Exception {
	}

	@Test

	void testShouldCalcualtePremiumGivenAllFactors() {
		double expectedPremium = 226.8;
		String name = "Jack";
		byte age = 17;
		byte yearsDriving = 1;
		byte noClaims = 0;
		boolean hasMedicalHistory = false;
		StorageType storageType = StorageType.DRIVE;
		AddressType addressType = AddressType.A;
		CarType carType = CarType.VAUXHALLASTRA;
		boolean hasPoints = false;
		VehiclePolicy jacksPolicy = new VehiclePolicy(name, age, yearsDriving, noClaims, hasMedicalHistory, storageType,
				addressType, carType, hasPoints);
		double actualPremium = jacksPolicy.getPremium();

		assertEquals(expectedPremium, actualPremium, 0.0001);
	}

	@Test
	void testShouldCalcualtePremiumForFordMondeoDriver() {
		double expectedPremium = 549.84; 
		String name = "John";
		byte age = 45;
		byte yearsDriving = 20;
		byte noClaims = 5;
		boolean hasMedicalHistory = true;
		StorageType storageType = StorageType.ONSTREET;
		AddressType addressType = AddressType.B;
		CarType carType = CarType.FORDMONDEO;
		boolean hasPoints = true;

		VehiclePolicy johnsPolicy = new VehiclePolicy(name, age, yearsDriving, noClaims, hasMedicalHistory, storageType,
				addressType, carType, hasPoints);
		double actualPremium = johnsPolicy.getPremium();

		assertEquals(expectedPremium, actualPremium, 0.01);
	}

	@Test
	void testShouldCalcualtePremiumForCitroenXsaraDriver() {
		double expectedPremium = 32.64;
		String name = "Mary";
		byte age = 30;
		byte yearsDriving = 12;
		byte noClaims = 5;
		boolean hasMedicalHistory = false;
		StorageType storageType = StorageType.GARAGE;
		AddressType addressType = AddressType.A;
		CarType carType = CarType.CITROENXSARA;
		boolean hasPoints = false;

		VehiclePolicy marysPolicy = new VehiclePolicy(name, age, yearsDriving, noClaims, hasMedicalHistory, storageType,
				addressType, carType, hasPoints);
		double actualPremium = marysPolicy.getPremium();

		assertEquals(expectedPremium, actualPremium, 0.0001);
	}

}
