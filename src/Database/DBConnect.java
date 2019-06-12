package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {
	private String host = "jdbc:mariadb://localhost:3306/SLEMS";
	private String username = "root";
	private String password = "romyroms";


	public void writeToDBCust(String customerName, int phoneNumber, String deliveryAddress, String email,
							  int quantity, int cost) {

		try {
			Connection con = DriverManager.getConnection(host, username, password);
			PreparedStatement pst = con.prepareStatement("INSERT INTO CustomerData VALUES (?,?,?,?," +
					"?,?,?)");
			pst.setString(1, null);
			pst.setString(2, customerName);
			pst.setString(3, String.valueOf(phoneNumber));
			pst.setString(4, deliveryAddress);
			pst.setString(5, email);
			pst.setString(6, String.valueOf(quantity));
			pst.setString(7, String.valueOf(cost));

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void writeToDBUser(String employeeID, String firstName, String lastName, String emailAddress,
							  String phoneNumber, String Position) {
		try {
			Connection con = DriverManager.getConnection(host, username, password);
			PreparedStatement pst = con.prepareStatement("insert into Users values (?,?,?,?,?,?)");
			pst.setString(1, employeeID);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, emailAddress);
			pst.setString(5, phoneNumber);
			pst.setString(6, Position);

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void writeToDBDailyEggs(String employeeID, String collectedEggs, String spoiledEggs, String brokenEggs,
								   String workStationSector, String workStationNumber) {
		try {
			Connection conn = DriverManager.getConnection(host, username, password);
			PreparedStatement pst = conn.prepareStatement("insert into DailyCollectedEggs values(?,?,?,?,?,?)");
			pst.setString(1, employeeID);
			pst.setString(2, collectedEggs);
			pst.setString(3, spoiledEggs);
			pst.setString(4, brokenEggs);
			pst.setString(5, workStationSector);
			pst.setString(6, workStationNumber);

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


	}

	public void writeToDBEggSupplier(String companyName, String emailAddress, String phoneNumber, String farmAddress,
									 String amountOfEggs) {
		try {
			Connection conn = DriverManager.getConnection(host, username, password);
			PreparedStatement pst = conn.prepareStatement("insert into EggSupplier values (?,?,?,?,?,?)");
			pst.setString(1, null);
			pst.setString(2, companyName);
			pst.setString(3, emailAddress);
			pst.setString(4, phoneNumber);
			pst.setString(5, farmAddress);
			pst.setString(6, amountOfEggs);

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}