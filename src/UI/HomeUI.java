package UI;

import Report.Report;
import Security.Login_UserUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeUI {
	private JFrame frame;


	/**
	 * Create the application.
	 */
	public HomeUI() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				HomeUI window = new HomeUI();
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
		frame.setBounds(100, 100, 570, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("WELCOME TO ");
		label.setForeground(SystemColor.controlDkShadow);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ebrima", Font.BOLD, 24));
		label.setBounds(10, 22, 554, 23);
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("SUPER FRESH EGGS");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poetsen One", Font.BOLD, 40));
		lblNewLabel.setBounds(70, 42, 408, 48);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
		lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 22));
		lblNewLabel_1.setBounds(80, 84, 386, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("HOME SCREEN");
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_3.setBounds(159, 118, 219, 28);
		frame.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Add/Edit  User");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.addActionListener(e -> {

			frame.dispose();
			New_UserUI add_user = null;
			try {
				add_user = new New_UserUI();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (add_user != null) {
				add_user.getFrame().setLocationRelativeTo(null);
				add_user.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(386, 180, 142, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnExternalSup = new JButton("Add/ Edit Supplier");
		btnExternalSup.addActionListener(e -> {

			frame.dispose();
			New_ExtSupplierUI supplierUI = null;
			try {
				supplierUI = new New_ExtSupplierUI();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (supplierUI != null) {
				supplierUI.getFrame().setLocationRelativeTo(null);
				supplierUI.getFrame().setVisible(true);
			}
		});
		btnExternalSup.setForeground(Color.WHITE);
		btnExternalSup.setBackground(new Color(25, 25, 112));
		btnExternalSup.setBounds(386, 231, 142, 28);
		frame.getContentPane().add(btnExternalSup);

		JButton btnAddOrders = new JButton("Add Order");
		btnAddOrders.addActionListener(e -> {
			getFrame().dispose();
			New_OrderUI order = new New_OrderUI();
			order.getFrame().setLocationRelativeTo(null);
			order.getFrame().setVisible(true);
		});
		btnAddOrders.setForeground(Color.WHITE);
		btnAddOrders.setBackground(new Color(25, 25, 112));
		btnAddOrders.setBounds(386, 309, 142, 29);
		frame.getContentPane().add(btnAddOrders);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(23, 157, 340, 301);
		frame.getContentPane().add(textArea);


		JButton btnViewSuppliers = new JButton("View Suppliers");
		btnViewSuppliers.setForeground(Color.WHITE);
		btnViewSuppliers.setBackground(new Color(25, 25, 112));
		btnViewSuppliers.setBounds(386, 270, 142, 28);
		frame.getContentPane().add(btnViewSuppliers);

		JButton btnUpdateInventory = new JButton("Add/Edit Inventory");
		btnUpdateInventory.setForeground(Color.WHITE);
		btnUpdateInventory.setBackground(new Color(25, 25, 112));
		btnUpdateInventory.setBounds(386, 383, 142, 27);
		btnUpdateInventory.addActionListener(e -> {

			frame.dispose();
			Enter_DataUI data = null;
			try {
				data = new Enter_DataUI();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (data != null) {
				data.getFrame().setLocationRelativeTo(null);
				data.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnUpdateInventory);

		JButton btnGenerateReport_1 = new JButton("Generate Report");
		btnGenerateReport_1.setForeground(Color.WHITE);
		btnGenerateReport_1.setBackground(new Color(25, 25, 112));
		btnGenerateReport_1.setBounds(386, 421, 142, 27);
		btnGenerateReport_1.addActionListener(e -> {
			Report report = null;
			try {
				report = new Report();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			if (report != null) {
				try {
					report.generateReport();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(getFrame(), "Report Successfully Created", "SLEMS",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(HomeUI.class.getResource("/resources/check-mark.png")));


		});
		frame.getContentPane().add(btnGenerateReport_1);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(Color.WHITE);
		btnLogout.addActionListener(e -> {

			frame.dispose();
			Login_UserUI login = new Login_UserUI();
			login.getFrame().setLocationRelativeTo(null);
			login.getFrame().setVisible(true);
		});

		btnLogout.setBounds(455, 8, 89, 23);
		frame.getContentPane().add(btnLogout);

		JButton btnViewOrders_1 = new JButton("View Orders");
		btnViewOrders_1.setForeground(Color.WHITE);
		btnViewOrders_1.setBackground(new Color(25, 25, 112));
		btnViewOrders_1.setBounds(386, 349, 142, 27);
		frame.getContentPane().add(btnViewOrders_1);
		btnViewOrders_1.addActionListener(e -> {
			try {
				String content = new String(Files.readAllBytes(Paths.get("./Customer Info.txt")));
				textArea.append(content);
				textArea.setFont(new Font("Arial", Font.PLAIN, 12));

			} catch (IOException ex) {
				ex.printStackTrace();
			}

			try {

				textArea.read(new InputStreamReader(
								getClass().getResourceAsStream("./Customer Info.txt")),
						null);

			} catch (Exception f) {
				f.printStackTrace();
			}
		});
	}

	public JFrame getFrame() {
		return this.frame;
	}

}
