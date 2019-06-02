package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditSupplier_UI {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	EditSupplier_UI() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				EditSupplier_UI window = new EditSupplier_UI();
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
	private void initialize() {
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
		lblNewLabel_1.setBounds(158, 89, 260, 23);
		frame.getContentPane().add(lblNewLabel_1);


		JLabel label_1 = new JLabel("Company Name");
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(300, 149, 115, 14);
		frame.getContentPane().add(label_1);

		JTextField CompanyName = new JTextField();
		CompanyName.setBounds(300, 174, 202, 23);
		frame.getContentPane().add(CompanyName);
		CompanyName.setColumns(10);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailAddress.setBounds(300, 268, 108, 14);
		frame.getContentPane().add(lblEmailAddress);

		JTextField emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(300, 293, 202, 23);
		frame.getContentPane().add(emailField);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoneNumber.setBounds(300, 327, 108, 14);
		frame.getContentPane().add(lblPhoneNumber);

		JTextField phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(300, 352, 202, 23);
		frame.getContentPane().add(phoneField);

		JLabel lblFarmAddress = new JLabel("Farm Address");
		lblFarmAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblFarmAddress.setBounds(300, 384, 108, 14);
		frame.getContentPane().add(lblFarmAddress);

		JTextField FAddressField = new JTextField();
		FAddressField.setColumns(10);
		FAddressField.setBounds(300, 409, 202, 23);
		frame.getContentPane().add(FAddressField);

		JButton btnAddSupplier = new JButton("MAKE EDIT");
		btnAddSupplier.addActionListener(e -> {
		});
		btnAddSupplier.setForeground(Color.BLACK);
		btnAddSupplier.setBackground(new Color(25, 25, 112));
		btnAddSupplier.setBounds(325, 443, 140, 23);
		frame.getContentPane().add(btnAddSupplier);

		DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel lblNewLabel_4 = new JLabel(date.format(now));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(175, 112, 206, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(43, 231, 193, 29);
		frame.getContentPane().add(comboBox);

		JLabel lblToEditA = new JLabel("Choose Supplier to Edit ");
		lblToEditA.setHorizontalAlignment(SwingConstants.CENTER);
		lblToEditA.setBounds(43, 209, 193, 14);
		frame.getContentPane().add(lblToEditA);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(e -> {

			getFrame().dispose();
			New_ExtSupplierUI previous = null;
			try {
				previous = new New_ExtSupplierUI();
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
	}

	JFrame getFrame() {
		return this.frame;
	}
}