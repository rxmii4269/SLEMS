package Security;

import UI.HomeUI;

import javax.swing.*;
import java.awt.*;

public class Login_UserUI {

	private String username;
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField UsernameField;
	private String Password = "";


	/**
	 * /**
	 * Create the application.
	 */
	public Login_UserUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 570, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);


		JLabel label = new JLabel("WELCOME TO ");
		label.setForeground(SystemColor.controlDkShadow);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ebrima", Font.BOLD, 24));
		label.setBounds(0, 27, 554, 23);
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("SUPER FRESH EGGS");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poetsen One", Font.BOLD, 40));
		lblNewLabel.setBounds(30, 45, 500, 48);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
		lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 22));
		lblNewLabel_1.setBounds(140, 89, 300, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(127, 163, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);

		setPassword(new JPasswordField());
		passwordField.setBounds(127, 274, 310, 43);
		frame.getContentPane().add(getPassword());

		setUsername(new JTextField());
		UsernameField.setBounds(127, 188, 310, 43);
		frame.getContentPane().add(getUsername());
		UsernameField.setColumns(10);


		JLabel lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(127, 249, 108, 14);
		frame.getContentPane().add(lblPassword);

		JButton btnLogin = new JButton("LOGIN ");
		frame.getRootPane().setDefaultButton(btnLogin);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.addActionListener(e -> {

			char[] password = getPassword().getPassword();
			for (char s : password) {
				String tmp = Password;
				Password = tmp + s;
			}

			username = getUsername().getText();
			if (Password.equalsIgnoreCase("admin") && username.equalsIgnoreCase("Supervisor")) {
				JOptionPane.showMessageDialog(getFrame(), "Login Successful" + "\n " + "Welcome SuperVisor", "SLEMS SUPERVISOR",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/resources/check-mark.png")));


				frame.dispose();
				// Add HomePage Launch for Supervisor
				HomeUI home = new HomeUI();
				home.getFrame().setLocationRelativeTo(null);
				home.getFrame().setVisible(true);

			} else if (Password.equalsIgnoreCase("worker") && username.equalsIgnoreCase("Subordinate")) {
				JOptionPane.showMessageDialog(getFrame(), "Login Successful" + "\n " + "Welcome Worker", "SLEMS WORKER",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("check-mark.png")));
				getPassword().setText(null);
				getUsername().setText(null);

				frame.dispose();

				HomeUI home = new HomeUI();
				home.getFrame().setLocationRelativeTo(null);
				home.getFrame().setVisible(true);

			} else {
				JOptionPane.showMessageDialog(getFrame(), "Invalid Login Details", "Login Error",
						JOptionPane.ERROR_MESSAGE);
				getPassword().setText(null);
				getUsername().setText(null);
				getUsername().grabFocus();
			}

		});
		btnLogin.setBounds(199, 374, 168, 34);
		frame.getContentPane().add(btnLogin);


		JButton btnExit = new JButton("Exit");

		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(25, 25, 112));
		btnExit.setBounds(281, 430, 131, 28);
		btnExit.addActionListener(e -> {
			setFrame(new JFrame("Exit"));
			if (JOptionPane.showConfirmDialog(getFrame(), "Confirm Exit", "Login Systems",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				getUsername().setText(null);
				getPassword().setText(null);
				System.exit(0);
			} else {
				getUsername().grabFocus();
			}

		});
		frame.getContentPane().add(btnExit);

		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(25, 25, 112));
		btnReset.setBounds(140, 430, 131, 28);
		btnReset.addActionListener(e -> {
			getUsername().setText(null);
			getPassword().setText(null);
			getUsername().grabFocus();
		});
		frame.getContentPane().add(btnReset);
	}

	public JFrame getFrame() {
		return frame;
	}

	//	public String getLoginName(){ return getUserN
	private void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField getUsername() {
		return UsernameField;
	}

	private void setUsername(JTextField username) {
		this.UsernameField = username;
	}

	private JPasswordField getPassword() {
		return passwordField;
	}

	private void setPassword(JPasswordField password) {
		this.passwordField = password;
	}

}


