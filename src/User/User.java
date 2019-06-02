package User;

import Security.Login_UserUI;

public class User {

	public User() {

	}

	public static void main(String[] args) {
		User user = new User();
		user.Login();

	}


	private void Login() {
		Login_UserUI login = new Login_UserUI();
		login.getFrame().setLocationRelativeTo(null);
		login.getFrame().setVisible(true);
	}

	public enum Position {
		Supervisor(),
		Subordinate();

		Position() {

		}


	}
}


