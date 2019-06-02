package UI;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Delete_UserUI {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	private Delete_UserUI() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Delete_UserUI window = new Delete_UserUI();
				window.frame.setLocationRelativeTo(null);
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

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(184, 424, 193, 29);
		frame.getContentPane().add(comboBox);

		JLabel lblToEditA = new JLabel("Choose User to Delete");
		lblToEditA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToEditA.setHorizontalAlignment(SwingConstants.CENTER);
		lblToEditA.setBounds(184, 399, 193, 14);
		frame.getContentPane().add(lblToEditA);

		JTextField textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(58, 129, 450, 257);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(e -> {

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
}