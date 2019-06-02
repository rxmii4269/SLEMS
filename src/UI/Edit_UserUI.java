package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Edit_UserUI {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	Edit_UserUI() throws IOException {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Edit_UserUI window = new Edit_UserUI();
				window.getFrame().setLocationRelativeTo(null);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 570, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setFocusable(true);
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
		lblNewLabel.setBounds(73, 45, 408, 48);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
		lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 22));
		lblNewLabel_1.setBounds(158, 89, 246, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(32, 333, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JTextField textField = new JTextField();
		textField.setBounds(32, 299, 202, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("EDIT USER");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.setBounds(304, 368, 154, 38);
		frame.getContentPane().add(btnLogin);

		JLabel label_1 = new JLabel("First Name");
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(32, 274, 108, 14);
		frame.getContentPane().add(label_1);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(32, 358, 202, 23);
		frame.getContentPane().add(textField_1);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailAddress.setBounds(32, 392, 108, 14);
		frame.getContentPane().add(lblEmailAddress);

		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(32, 417, 202, 23);
		frame.getContentPane().add(textField_2);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoneNumber.setBounds(289, 276, 108, 14);
		frame.getContentPane().add(lblPhoneNumber);

		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(289, 301, 202, 23);
		frame.getContentPane().add(textField_3);

		JLabel lblPleaseEnterEmployee = new JLabel("Please Enter Employee ID");
		lblPleaseEnterEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseEnterEmployee.setFont(new Font("Arial", Font.BOLD, 15));
		lblPleaseEnterEmployee.setBounds(32, 216, 215, 14);
		frame.getContentPane().add(lblPleaseEnterEmployee);

		JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(35, 242, 212, 23);
		frame.getContentPane().add(textField_5);

		JLabel lblEnterYourPosition = new JLabel("Enter your Position");
		lblEnterYourPosition.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterYourPosition.setFont(new Font("Arial", Font.BOLD, 15));
		lblEnterYourPosition.setBounds(286, 218, 268, 14);
		frame.getContentPane().add(lblEnterYourPosition);

		JTextField textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(286, 244, 202, 23);
		frame.getContentPane().add(textField_6);


		// Add Action Listener and pop up message to show that it was a successful.
		JLabel lblNewLabel_3 = new JLabel("EDIT USER");
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(168, 123, 219, 28);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblChooseUserTo = new JLabel("Choose User to Edit ");
		lblChooseUserTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseUserTo.setBounds(178, 156, 193, 14);
		frame.getContentPane().add(lblChooseUserTo);
		New_UserUI user = new New_UserUI();
		String[] array = user.details.toArray(new String[0]);
		JComboBox<String> comboBox = new JComboBox<>(array);
		comboBox.setEditable(true);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(178, 178, 193, 29);
		frame.getContentPane().add(comboBox);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(e -> {

			getFrame().dispose();
			New_UserUI previous = null;
			try {
				previous = new New_UserUI();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (previous != null) {
				previous.getFrame().setLocationRelativeTo(null);
				previous.getFrame().setVisible(true);
			}


		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);

		DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel lblNewLabel_4 = new JLabel(date.format(now));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(175, 112, 206, 14);
		frame.getContentPane().add(lblNewLabel_4);
	}

	JFrame getFrame() {
		return this.frame;
	}
}