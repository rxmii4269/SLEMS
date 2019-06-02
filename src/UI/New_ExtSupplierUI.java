package UI;

import Data.ExternalEggSupplier;
import Data.ExternalEggSupply;
import Database.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class New_ExtSupplierUI {

	private JFrame frame;
	private JTextField CompanyName;
	private JTextField AmtEggField;
	private JTextField EEmailField;
	private JTextField EPhoneField;
	private JTextField EFAddressField;
	private FileWriter writeTable = new FileWriter("src/resources/Supplier Info.txt", StandardCharsets.UTF_8, true);
	private BufferedWriter bw = new BufferedWriter(writeTable);
	private PrintWriter out = new PrintWriter(bw);
	private ExternalEggSupplier externalEggSupplier = new ExternalEggSupplier();
	private ArrayList<String> details = new ArrayList<>();
	private String formatStr = "%-30s %-30s %-30s %-20s %-20s%n";

	/**
	 * Create the application.
	 */
	New_ExtSupplierUI() throws IOException {
		initialize();
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

		CompanyName = new JTextField();
		CompanyName.setBounds(49, 184, 202, 23);
		frame.getContentPane().add(CompanyName);
		CompanyName.setColumns(10);


		JLabel label_1 = new JLabel("Company Name");
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(49, 159, 120, 14);
		frame.getContentPane().add(label_1);


		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailAddress.setBounds(49, 218, 108, 14);
		frame.getContentPane().add(lblEmailAddress);

		EEmailField = new JTextField();
		EEmailField.setColumns(10);
		EEmailField.setBounds(49, 244, 202, 23);
		frame.getContentPane().add(EEmailField);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoneNumber.setBounds(49, 280, 120, 14);
		frame.getContentPane().add(lblPhoneNumber);

		EPhoneField = new JTextField();
		EPhoneField.setColumns(10);
		EPhoneField.setBounds(49, 306, 202, 23);
		frame.getContentPane().add(EPhoneField);

		JLabel lblNewLabel_3 = new JLabel("EXTERNAL SUPPLIERS");
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(168, 132, 219, 28);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblFarmAddress = new JLabel("Farm Address");
		lblFarmAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblFarmAddress.setBounds(49, 342, 108, 14);
		frame.getContentPane().add(lblFarmAddress);

		EFAddressField = new JTextField();
		EFAddressField.setColumns(10);
		EFAddressField.setBounds(49, 368, 202, 23);
		frame.getContentPane().add(EFAddressField);

		JLabel lblNewLabel_2 = new JLabel("Amount of Eggs");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(49, 404, 202, 14);
		frame.getContentPane().add(lblNewLabel_2);

		AmtEggField = new JTextField();
		AmtEggField.setColumns(10);
		AmtEggField.setBounds(49, 430, 202, 23);
		frame.getContentPane().add(AmtEggField);

		JButton btnEditExistingSuppliers = new JButton("Edit Existing Suppliers");
		btnEditExistingSuppliers.setForeground(Color.WHITE);
		btnEditExistingSuppliers.setBackground(new Color(25, 25, 112));
		btnEditExistingSuppliers.setBounds(334, 279, 168, 34);
		frame.getContentPane().add(btnEditExistingSuppliers);
		btnEditExistingSuppliers.addActionListener(e -> {

			getFrame().dispose();
			EditSupplier_UI edit = new EditSupplier_UI();
			edit.getFrame().setVisible(true);
		});

		JButton btnDeleteSupplier = new JButton("Delete Supplier");
		btnDeleteSupplier.setForeground(Color.WHITE);
		btnDeleteSupplier.setBackground(new Color(25, 25, 112));
		btnDeleteSupplier.setBounds(334, 220, 168, 34);
		frame.getContentPane().add(btnDeleteSupplier);
		btnDeleteSupplier.addActionListener(e -> {

			getFrame().dispose();
			Delete_SupplierUI delete = new Delete_SupplierUI();
			delete.getFrame().setLocationRelativeTo(null);
			delete.getFrame().setVisible(true);

		});

		DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel lblNewLabel_4 = new JLabel(date.format(now));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(175, 112, 206, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JButton button_2 = new JButton("Add Supplier");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(25, 25, 112));
		button_2.setBounds(334, 350, 168, 23);
		button_2.addActionListener(e -> {
			out.print(String.format(formatStr, "Company Name", "Email Address", "Phone Number", "Farm Address", "Amount of Eggs"));
			details.add(getCompanyName().getText());
			details.add(getEEmailField().getText());
			details.add(getEPhoneField().getText());
			details.add(getEFAddressField().getText());
			details.add(getAmtEggField().getText());
			externalEggSupplier.externalEggSupplier.add(getCompanyName().getText());
			externalEggSupplier.externalEggSupplier.add(getEEmailField().getText());
			externalEggSupplier.externalEggSupplier.add(getEPhoneField().getText());
			externalEggSupplier.externalEggSupplier.add(getEFAddressField().getText());
			externalEggSupplier.externalEggSupplier.add(getAmtEggField().getText());
			ExternalEggSupply externalEggSupply = new ExternalEggSupply(getAmtEggField().getText());

			assert writeTable != null;
			out.print(String.format(formatStr, details.get(0), details.get(1), details.get(2),
					details.get(3), details.get(4)));
			out.close();
			DBConnect connect = new DBConnect();
			connect.writeToDBEggSupplier(details.get(0), details.get(1), details.get(2), details.get(3),
					details.get(4));
			JOptionPane.showMessageDialog(getFrame(), "Supplier added", "SLEMS",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/resources/check-mark.png")));


		});
		frame.getContentPane().add(button_2);

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

	JFrame getFrame() {
		return this.frame;
	}

	private JTextField getCompanyName() {
		return CompanyName;
	}

	private JTextField getAmtEggField() {
		return AmtEggField;
	}

	private JTextField getEEmailField() {
		return EEmailField;
	}

	private JTextField getEPhoneField() {
		return EPhoneField;
	}

	private JTextField getEFAddressField() {
		return EFAddressField;
	}

}

