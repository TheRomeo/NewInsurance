package uk.gov.hmrc.InsuranceApp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import uk.gov.hmrc.InsuranceApp.domain.HomeInsurancePolicy.ConstructionType;
import uk.gov.hmrc.InsuranceApp.domain.HomeInsurancePolicy.Ownership;
import uk.gov.hmrc.InsuranceApp.domain.HomeInsurancePolicy.PropertyType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.AddressType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.CarType;
import uk.gov.hmrc.InsuranceApp.domain.VehiclePolicy.StorageType;

public class PolicyData {

	private static Connection con;

	public static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance", "root", "Pa$$w0rd");
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	private static Hashtable<CarType, Double> loadPremiums() {
		Hashtable<CarType, Double> premiums = new Hashtable<CarType, Double>();
		premiums.put(CarType.CITROENXSARA, new Double(400)); // boxing the primitive
		premiums.put(CarType.FORDMONDEO, new Double(750));
		premiums.put(CarType.VAUXHALLASTRA, new Double(1000));
		return premiums;
	}

	public static double getPremium(CarType carType) {

		return loadPremiums().get(carType);
	}

	public static double getStorageFactor(StorageType storageType) {

		return loadStorageFactors().get(storageType);
	}

	private static HashMap<StorageType, Double> loadStorageFactors() {
		HashMap<StorageType, Double> storageFactors = new HashMap<>();
		storageFactors.put(StorageType.DRIVE, Double.valueOf(0.15));
		storageFactors.put(StorageType.ONSTREET, Double.valueOf(0.8));
		storageFactors.put(StorageType.GARAGE, Double.valueOf(0.1));

		return storageFactors;

	}

	public static double getAddressFactor(AddressType addressType) {
		return loadAddressFactors().get(addressType);
	}

	private static HashMap<AddressType, Double> loadAddressFactors() {
		HashMap<AddressType, Double> addressFactors = new HashMap<>();
		addressFactors.put(AddressType.A, Double.valueOf(1.2));
		addressFactors.put(AddressType.B, Double.valueOf(0.85));
		addressFactors.put(AddressType.C, Double.valueOf(1.2));

		return addressFactors;
	}

	private static ResultSet getQueryResultSet(String query) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	private static Hashtable<CarType, Double> loadConstructionTypeFactors() {

		return null;
	}

	public static double getConstructionFactor(ConstructionType key) {
		HashMap<ConstructionType, Double> construcationType = new HashMap<>();

		construcationType.put(ConstructionType.BRICK, 1.2);
		construcationType.put(ConstructionType.STRAW, 0.85);
		construcationType.put(ConstructionType.WOOD, 1.2);

		return construcationType.get(key);

	}

	public static double getPropertyFactor(PropertyType key) {
		return loadPropertyTypeFactors().get(key);
	}

	private static Hashtable<CarType, Double> loadPropertyTypeFactors() {
		return null;
	}

	public static double getPropertyPremium(PropertyType key) {
		HashMap<PropertyType, Double> propertyType = new HashMap<>();
		propertyType.put(PropertyType.FLAT, 1200.00);
		propertyType.put(PropertyType.BUNGALOW, 600.00);
		propertyType.put(PropertyType.DETACHED, 480.00);
		propertyType.put(PropertyType.SEMIDETACHED, 750.00);

		return propertyType.get(key);

	}

	public static double getOwnershipFactor(Ownership key) {
		HashMap<Ownership, Double> ownership = new HashMap<>();
		ownership.put(Ownership.RENTED, 0.8);
		ownership.put(Ownership.OWNED, 0.3);

		return ownership.get(key);

	}

}
