package uk.gov.hmrc.InsuranceApp.app;

import java.util.Scanner;

import uk.gov.hmrc.InsuranceApp.controller.PolicyController;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.AddressType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.CarType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.StorageType;

public class InsuranceQuoteGenerator {

	public static void main(String[] args) {

		generateDialogue();
		
	
	}

	//Push and pull with eclipse123


	private static void generateDialogue() {
		try(Scanner myScanner  = new Scanner(System.in)){
					
		System.out.println("Please enter your name: ");
		String name = myScanner.next();		

		
		System.out.println("How old are you? ");
		byte age = myScanner.nextByte();
	
		
		System.out.println("What is the make of your vehicle? ");
		String make = myScanner.next();
		
		System.out.println("What is the model of your vehicle? ");
		String model = myScanner.next();
		
		System.out.println("How many years have you been driving? ");
		byte yearsDriving = myScanner.nextByte();

		
		System.out.println("do you have more than 1 years no claims? ");
		byte noClaims = myScanner.nextByte();
	
		
		System.out.println("Do you have any medical history we should know about? (yes/no)");
		String hasMedicalHistory = myScanner.next();

		
		System.out.println("Where do you keep your vehicle? (Garage, OnStreet or Drive");
		String storage = myScanner.next();

		
		System.out.printf("Do you live in A - England, B - Scotland, C - Wales");
		String address = myScanner.next();
		AddressType addressType = AddressType.valueOf(address);
		
		System.out.println("Do you have any points on your licence? ");
		String hasPoints = myScanner.next();
		
		PolicyController controller = new PolicyController();
		 double premium = controller.processRequest(name, age, make, model, 
				yearsDriving, noClaims, hasMedicalHistory, storage, address, hasPoints);
		
		System.out.println(premium);
		
		}
	}



}
