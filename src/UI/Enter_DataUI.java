package UI;

import Data.Egg;
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

public class Enter_DataUI {
	private JFrame frame;
	private JTextField IDField;
	private JTextField ECollectedField;
	private JTextField ESpoiltField;
	private JTextField EBrokenField;
	private JTextField workstationS;
	private JTextField workstationN;
	private FileWriter writeTable = new FileWriter("src/resources/Data.txt", StandardCharsets.UTF_8, true);
	private BufferedWriter bw = new BufferedWriter(writeTable);
	private PrintWriter out = new PrintWriter(bw);
	private FileWriter product = new FileWriter("src/resources/Product.txt", StandardCharsets.UTF_8, true);
	private BufferedWriter pw = new BufferedWriter(product);
	private PrintWriter pout = new PrintWriter(pw);
	private String formatter = "%-30s %-30s %-30s%n";
	private String formatStr = "%-30s %-30s %-30s %-15s %-25s %-20s%n";
	private int eggsSpoiled;
	private int eggsCollected;
	private int eggsBroken;

	/**
	 * Create the application.
	 */
	Enter_DataUI() throws IOException {
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

		JLabel lblNewLabel_2 = new JLabel("Enter Workstation Section:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(33, 250, 202, 14);
		frame.getContentPane().add(lblNewLabel_2);

		IDField = new JTextField();
		IDField.setBounds(33, 201, 202, 28);
		frame.getContentPane().add(IDField);
		IDField.setColumns(10);

		JLabel lblEnterYourId = new JLabel("Enter your ID Number:");
		lblEnterYourId.setFont(new Font("Arial", Font.BOLD, 15));
		lblEnterYourId.setBounds(33, 176, 180, 14);
		frame.getContentPane().add(lblEnterYourId);

		JLabel lblEmailAddress = new JLabel("Enter Workstation Number:");
		lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailAddress.setBounds(33, 336, 202, 14);
		frame.getContentPane().add(lblEmailAddress);

		JLabel lblPleaseEnterSupervisor = new JLabel("Enter Eggs Collected:");
		lblPleaseEnterSupervisor.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseEnterSupervisor.setFont(new Font("Arial", Font.BOLD, 15));
		lblPleaseEnterSupervisor.setBounds(295, 205, 174, 23);
		frame.getContentPane().add(lblPleaseEnterSupervisor);

		ECollectedField = new JTextField();
		ECollectedField.setColumns(10);
		ECollectedField.setBounds(473, 202, 55, 23);
		frame.getContentPane().add(ECollectedField);

		JLabel lblPleaseEnterEmployee = new JLabel("Enter Eggs Spoilt:");
		lblPleaseEnterEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseEnterEmployee.setFont(new Font("Arial", Font.BOLD, 15));
		lblPleaseEnterEmployee.setBounds(295, 242, 168, 23);
		frame.getContentPane().add(lblPleaseEnterEmployee);

		JLabel lblEnterEggsBroken = new JLabel("Enter Eggs Broken:");
		lblEnterEggsBroken.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterEggsBroken.setFont(new Font("Arial", Font.BOLD, 15));
		lblEnterEggsBroken.setBounds(295, 282, 161, 21);
		frame.getContentPane().add(lblEnterEggsBroken);

		JLabel lblNewLabel_3 = new JLabel("ENTER DAILY DATA ");
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(162, 137, 219, 28);
		frame.getContentPane().add(lblNewLabel_3);

		DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel lblNewLabel_4 = new JLabel(date.format(now));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(175, 112, 206, 14);
		frame.getContentPane().add(lblNewLabel_4);


		ESpoiltField = new JTextField();
		ESpoiltField.setColumns(10);
		ESpoiltField.setBounds(473, 238, 55, 23);
		frame.getContentPane().add(ESpoiltField);

		EBrokenField = new JTextField();
		EBrokenField.setColumns(10);
		EBrokenField.setBounds(473, 280, 55, 23);
		frame.getContentPane().add(EBrokenField);

		JButton btnGoHome = new JButton("Go Home");
		btnGoHome.addActionListener(e -> {

			frame.dispose();
			HomeUI home = new HomeUI();
			home.getFrame().setLocationRelativeTo(null);
			home.getFrame().setVisible(true);
		});
		btnGoHome.setForeground(Color.WHITE);
		btnGoHome.setBackground(new Color(25, 25, 112));
		btnGoHome.setBounds(22, 434, 147, 28);
		frame.getContentPane().add(btnGoHome);

		JButton btnSaveData = new JButton("Save Data");
		btnSaveData.setForeground(Color.WHITE);
		btnSaveData.setBackground(new Color(25, 25, 112));
		btnSaveData.setBounds(191, 434, 147, 28);
		btnSaveData.addActionListener(e -> {
			setEggsSpoiled(Integer.parseInt(ESpoiltField.getText()));
			setEggsCollected(Integer.parseInt(ECollectedField.getText()));
			setEggsBroken(Integer.parseInt(EBrokenField.getText()));
			Egg egg = new Egg();


			assert out != null;


			out.println(String.format(formatStr, getIDField().getText(), getECollectedField().getText(),
					getESpoiltField().getText(), getEBrokenField().getText(), getWorkstationS().getText(),
					getWorkstationN().getText()));
			out.print("\n");

			pout.println(String.format(formatter, "Collected Eggs", "Spoiled Eggs", "Broken Eggs"));
			pout.println(String.format(formatter, getECollectedField().getText(), getESpoiltField().getText(), EBrokenField.getText()));

			DBConnect connect = new DBConnect();
			connect.writeToDBDailyEggs(getIDField().getText(), getECollectedField().getText(), getESpoiltField().getText(),
					getEBrokenField().getText(), getWorkstationS().getText(), getWorkstationN().getText());

			pout.flush();
			pout.close();
			out.close();

			//Check if all fields are filled
			if (getIDField().getText().equals("") || getECollectedField().getText().equals("") ||
					getESpoiltField().getText().equals("") || getEBrokenField().getText().equals("") ||
					getWorkstationS().getText().equals("") || getWorkstationN().getText().equals("")) {

				JOptionPane.showMessageDialog(getFrame(), "Please Enter All Fields", "Missing Data",
						JOptionPane.ERROR_MESSAGE);
			} else {

				JOptionPane.showMessageDialog(getFrame(), "Data saved", "SLEMS",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/resources/check-mark.png")));
			}
		});
		frame.getContentPane().add(btnSaveData);

		JButton btnUnitsProducible = new JButton("Units Producible");
		btnUnitsProducible.setForeground(Color.WHITE);
		btnUnitsProducible.setBackground(new Color(25, 25, 112));
		btnUnitsProducible.setBounds(361, 434, 147, 28);
		frame.getContentPane().add(btnUnitsProducible);


		workstationS = new JTextField();
		workstationS.setColumns(10);
		workstationS.setBounds(33, 275, 202, 28);
		frame.getContentPane().add(workstationS);

		workstationN = new JTextField();
		workstationN.setColumns(10);
		workstationN.setBounds(33, 361, 202, 28);
		frame.getContentPane().add(workstationN);

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

	private JTextField getWorkstationS() {
		return this.workstationS;
	}

	private JTextField getWorkstationN() {
		return this.workstationN;
	}

	private JTextField getIDField() {
		return this.IDField;
	}

	private JTextField getECollectedField() {
		return this.ECollectedField;
	}

	private JTextField getESpoiltField() {
		return this.ESpoiltField;
	}

	private JTextField getEBrokenField() {
		return this.EBrokenField;
	}

	public String toString() {
		return "Eggs Collected: " + getEggsCollected() + " " + getEggsBroken() + " " + getEggsBroken();
	}

	private int getEggsCollected() {
		return eggsCollected;
	}

	private void setEggsCollected(int eggsCollected) {
		this.eggsCollected = eggsCollected;
	}

	public int getEggsSpoiled() {
		return eggsSpoiled;
	}

	private void setEggsSpoiled(int eggsSpoiled) {
		this.eggsSpoiled = eggsSpoiled;
	}

	private int getEggsBroken() {
		return eggsBroken;
	}

	private void setEggsBroken(int eggsBroken) {
		this.eggsBroken = eggsBroken;
	}

}
