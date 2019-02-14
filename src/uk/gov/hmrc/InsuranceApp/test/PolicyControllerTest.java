package uk.gov.hmrc.InsuranceApp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.gov.hmrc.InsuranceApp.controller.PolicyController;
import uk.gov.hmrc.InsuranceApp.domain.PolicyException;

class PolicyControllerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNameShouldThrowExeptionWhenWhiteSpaceOnlyInName() {
		//arrange 
	String name =  "                ";
	// Act & assert
	assertThrows(PolicyException.class, ()-> PolicyController.checkForWhiteSpace(name));
	}

}
