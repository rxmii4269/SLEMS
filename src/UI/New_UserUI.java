package UI;

import Database.DBConnect;
import User.Subordinate;
import User.Supervisor;

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

public class New_UserUI {

	ArrayList<String> details = new ArrayList<>();
	private JTextField EmpIDField;
	private JFrame frame;
	private JTextField FNameField;
	private JTextField LNameField;
	private JTextField EmailField;
	private JTextField phoneField;
	private JTextField LetterSWField;
	private JTextField PositionField;
	private FileWriter writeTable = new FileWriter("src/resources/User Info.txt", StandardCharsets.UTF_8, true);
	private BufferedWriter bw = new BufferedWriter(writeTable);
	private PrintWriter out = new PrintWriter(bw);
	private String formatStr = "%-30s %-30s %-30s %-30s %-20s %-15s%n";
	private DBConnect write = new DBConnect();


	/**
	 * Create the application.
	 */
	public New_UserUI() throws IOException {
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

		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(33, 246, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);

		FNameField = new JTextField();
		FNameField.setBounds(33, 201, 202, 23);
		frame.getContentPane().add(FNameField);
		FNameField.setColumns(10);


		JButton btnEditUser = new JButton("EDIT USER");
		btnEditUser.setForeground(Color.WHITE);
		btnEditUser.setBackground(new Color(25, 25, 112));
		btnEditUser.setBounds(317, 419, 127, 33);
		frame.getContentPane().add(btnEditUser);
		btnEditUser.addActionListener(e -> {

			getFrame().dispose();
			Edit_UserUI edit = null;
			try {
				edit = new Edit_UserUI();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (edit != null) {
				edit.getFrame().setLocationRelativeTo(null);
				edit.getFrame().setVisible(true);
			}
		});

		DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		JLabel lblNewLabel_4 = new JLabel(date.format(now));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(175, 112, 206, 14);
		frame.getContentPane().add(lblNewLabel_4);
		// Add pop up message to Add User to show data has been added successfully.
		JButton saveBtn = new JButton("ADD USER");
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setBackground(new Color(25, 25, 112));
		saveBtn.setBounds(317, 375, 127, 33);
		frame.getContentPane().add(saveBtn);
		out.print(String.format(formatStr, "Employee ID", "First Name", "Last Name", "Email Address", "Phone Number", "Position"));
		saveBtn.addActionListener(e -> {
			if (getLetterSWField().getText().equalsIgnoreCase("s")) {
				details.add(getEmpIDField().getText());
				details.add(getFNameField().getText());
				details.add(getLNameField().getText());
				details.add(getEmailField().getText());
				details.add(getPhoneField().getText());
				details.add(getPositionField().getText());

				out.print(String.format(formatStr, details.get(0), details.get(1), details.get(2),
						details.get(3), details.get(4), details.get(5)));
				Supervisor.getInstance();

				write.writeToDBUser(getEmpIDField().getText(), details.get(1), details.get(2), details.get(3),
						details.get(4), details.get(5));

			} else if (getLetterSWField().getText().equalsIgnoreCase("w")) {

				details.add(getEmpIDField().getText());
				details.add(getFNameField().getText());
				details.add(getLNameField().getText());
				details.add(getEmailField().getText());
				details.add(getPhoneField().getText());
				details.add(getPositionField().getText());
				assert writeTable != null;
				out.print(String.format(formatStr, details.get(0), details.get(1), details.get(2),
						details.get(3), details.get(4), details.get(5)));

				write.writeToDBUser(getEmpIDField().getText(), details.get(1), details.get(2), details.get(3),
						details.get(4), details.get(5));

				Subordinate subordinate = new Subordinate(getEmpIDField().getText(), getFNameField().getText(), getLNameField().getText(),
						Long.parseLong(getPhoneField().getText()));


			} else {
				System.out.println("Please select the correct letters");
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));

			}

			JOptionPane.showMessageDialog(getFrame(), "User added", "SLEMS",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/resources/check-mark.png")));

			out.close();
		});


		JLabel label_1 = new JLabel("First Name");
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(33, 176, 108, 14);
		frame.getContentPane().add(label_1);

		LNameField = new JTextField();
		LNameField.setColumns(10);
		LNameField.setBounds(33, 272, 202, 23);
		frame.getContentPane().add(LNameField);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmailAddress.setBounds(33, 317, 108, 14);
		frame.getContentPane().add(lblEmailAddress);

		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(33, 342, 202, 23);
		frame.getContentPane().add(EmailField);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoneNumber.setBounds(33, 387, 108, 14);
		frame.getContentPane().add(lblPhoneNumber);

		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(33, 411, 202, 23);
		frame.getContentPane().add(phoneField);

		JLabel lblPleaseEnterSupervisor = new JLabel("Please Enter [S]upervisor or [W]orker");
		lblPleaseEnterSupervisor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterSupervisor.setFont(new Font("Arial", Font.BOLD, 15));
		lblPleaseEnterSupervisor.setBounds(276, 176, 268, 14);
		frame.getContentPane().add(lblPleaseEnterSupervisor);

		LetterSWField = new JTextField();
		LetterSWField.setColumns(10);
		LetterSWField.setBounds(276, 202, 202, 23);
		frame.getContentPane().add(LetterSWField);

		JLabel lblPleaseEnterEmployee = new JLabel("Please Enter Employee ID");
		lblPleaseEnterEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseEnterEmployee.setFont(new Font("Arial", Font.BOLD, 15));
		lblPleaseEnterEmployee.setBounds(276, 247, 268, 14);
		frame.getContentPane().add(lblPleaseEnterEmployee);

		EmpIDField = new JTextField();
		EmpIDField.setColumns(10);
		EmpIDField.setBounds(279, 273, 202, 23);
		frame.getContentPane().add(EmpIDField);

		JLabel label_2 = new JLabel("Please Enter Position");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Arial", Font.BOLD, 15));
		label_2.setBounds(276, 318, 268, 14);
		frame.getContentPane().add(label_2);

		PositionField = new JTextField();
		PositionField.setColumns(10);
		PositionField.setBounds(276, 343, 202, 23);
		frame.getContentPane().add(PositionField);

		JLabel lblNewLabel_3 = new JLabel("CREATE NEW USER ");
		lblNewLabel_3.setForeground(SystemColor.windowBorder);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(162, 137, 219, 28);
		frame.getContentPane().add(lblNewLabel_3);

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
		return frame;
	}

	private JTextField getFNameField() {
		return FNameField;
	}

	private JTextField getLNameField() {
		return LNameField;
	}

	private JTextField getEmailField() {
		return EmailField;
	}

	private JTextField getPhoneField() {
		return phoneField;
	}

	private JTextField getPositionField() {
		return PositionField;
	}

	private JTextField getLetterSWField() {
		return LetterSWField;
	}

	private JTextField getEmpIDField() {
		return EmpIDField;
	}


}
