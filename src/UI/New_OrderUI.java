package UI;

import Data.Customer;
import Data.Order;
import Database.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class New_OrderUI {

	private JFrame frame;
	private JTextField CustomerField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField deliveryField;
	private JTextField AmtField;
	private String custName;
	private String phoneNum;
	private String email;
	private String address;
	private int amt;


	/**
	 * Create the application.
	 */
	public New_OrderUI() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				New_OrderUI window = new New_OrderUI();
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

		JLabel phoneLabel = new JLabel("Phone Number");
		phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		phoneLabel.setBounds(37, 258, 202, 14);
		frame.getContentPane().add(phoneLabel);

		CustomerField = new JTextField();
		CustomerField.setBounds(37, 224, 202, 23);
		frame.getContentPane().add(CustomerField);
		CustomerField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(437, 285, 70, 14);
		frame.getContentPane().add(lblNewLabel_2);


		JButton btnLogin = new JButton("CONFIRM ORDER");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.setBounds(327, 357, 168, 48);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(e -> {
			custName = CustomerField.getText();
			phoneNum = phoneField.getText();
			address = deliveryField.getText();
			email = emailField.getText();
			amt = Integer.parseInt(AmtField.getText());
			Customer customer = null;
			try {
				customer = new Customer(custName, phoneNum, address, email, amt);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (customer != null) {
				customer.customerArray.add(custName);
			}
			if (customer != null) {
				customer.customerArray.add(phoneNum);
			}
			if (customer != null) {
				customer.customerArray.add(address);
			}
			if (customer != null) {
				customer.customerArray.add(email);
			}
			if (customer != null) {
				customer.customerArray.add(String.valueOf(amt));
			}
			Order order = new Order(amt);
			if (customer != null) {
				customer.customerInfo();
			}
			lblNewLabel_2.setText("$" + order.total());
			DBConnect write = new DBConnect();
			write.writeToDBCust(custName, Integer.parseInt(phoneNum), address, email, amt, (int) order.total());
		});


		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Arial", Font.BOLD, 15));
		lblCustomerName.setBounds(37, 199, 202, 14);
		frame.getContentPane().add(lblCustomerName);

		JLabel lblDeliveryAddress = new JLabel("Delivery Address");
		lblDeliveryAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblDeliveryAddress.setBounds(37, 373, 202, 14);
		frame.getContentPane().add(lblDeliveryAddress);

		JLabel lblNewLabel_3 = new JLabel("NEW ORDER");
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(162, 137, 219, 28);
		frame.getContentPane().add(lblNewLabel_3);


		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailAddress.setBounds(37, 312, 202, 14);
		frame.getContentPane().add(lblEmailAddress);

		JLabel lblIfItIs = new JLabel("If it is a pick up order, type N/A");
		lblIfItIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfItIs.setBounds(37, 420, 202, 14);
		frame.getContentPane().add(lblIfItIs);

		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(37, 276, 202, 23);
		frame.getContentPane().add(phoneField);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(37, 331, 202, 23);
		frame.getContentPane().add(emailField);

		deliveryField = new JTextField();
		deliveryField.setColumns(10);
		deliveryField.setBounds(37, 398, 202, 23);
		frame.getContentPane().add(deliveryField);

		JLabel lblEnterAmount = new JLabel("Enter Amount:");
		lblEnterAmount.setFont(new Font("Arial", Font.BOLD, 15));
		lblEnterAmount.setBounds(313, 228, 135, 14);
		frame.getContentPane().add(lblEnterAmount);

		AmtField = new JTextField();
		AmtField.setBounds(437, 224, 95, 23);
		frame.getContentPane().add(AmtField);
		AmtField.setColumns(10);


		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 15));
		lblTotal.setBounds(313, 285, 135, 14);
		frame.getContentPane().add(lblTotal);

		JLabel lblEnterType = new JLabel("Enter Type");
		lblEnterType.setFont(new Font("Arial", Font.BOLD, 15));
		lblEnterType.setBounds(313, 259, 135, 14);
		frame.getContentPane().add(lblEnterType);

		JComboBox<String> TypeBox = new JComboBox<>();
		TypeBox.setBackground(new Color(255, 255, 255));
		TypeBox.setBounds(437, 256, 95, 20);
		frame.getContentPane().add(TypeBox);

		TypeBox.addItem("Liquid Eggs");
		TypeBox.addItem("Shell Eggs");


		DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel lblNewLabel_4 = new JLabel(date.format(now));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(175, 112, 206, 14);
		frame.getContentPane().add(lblNewLabel_4);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(e -> {

			getFrame().dispose();
			HomeUI home = new HomeUI();
			home.getFrame().setLocationRelativeTo(null);
			home.getFrame().setVisible(true);

		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnBack);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
