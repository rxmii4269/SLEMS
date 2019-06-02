package User;

import java.io.Serializable;

public class Supervisor extends User implements Serializable {
	private static String firstName;
	private static String lastName;
	private static String employeeID;
	private static Position position;
	private static String emailAddress;
	private static int phoneNumber;


	private static volatile Supervisor soleInstance;

	private Supervisor(String firstName, String lastName, String employeeID, String emailAddress, int phoneNumber, Position position) {
		super();
		Supervisor.firstName = firstName;
		Supervisor.lastName = lastName;
		Supervisor.employeeID = employeeID;
		Supervisor.position = position;
		Supervisor.emailAddress = emailAddress;
		Supervisor.phoneNumber = phoneNumber;


		if (getSoleInstance() != null) {
			throw new RuntimeException("Use the getInstance() method to get the single instance of this class.");
		}
	}

	public static Supervisor getInstance() {
		if (getSoleInstance() == null) {
			synchronized (Supervisor.class) {
				if (getSoleInstance() == null)
					setSoleInstance(new Supervisor(firstName, lastName, employeeID, emailAddress, phoneNumber, position));
			}
		}
		return getSoleInstance();
	}

	private static Supervisor getSoleInstance() {
		return soleInstance;
	}

	private static void setSoleInstance(Supervisor soleInstance) {
		Supervisor.soleInstance = soleInstance;
	}


}
