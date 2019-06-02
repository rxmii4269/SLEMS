package Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Customer {

	public ArrayList<String> customerArray = new ArrayList<>();
	private String customerName;
	private String phoneNum;
	private String deliveryAddress;
	private FileWriter writeTable = new FileWriter("Customer Info.txt", StandardCharsets.UTF_8, true);
	private BufferedWriter bw = new BufferedWriter(writeTable);
	private PrintWriter out = new PrintWriter(bw);
	private String emailAddress;
	private int amt;


	public Customer(String custName, String phoneNum, String address, String email, int amt) throws IOException {
		this.customerName = custName;
		this.phoneNum = phoneNum;
		this.deliveryAddress = address;
		this.emailAddress = email;
		this.amt = amt;
	}

	public void customerInfo() {
		String formatStr = "%-30s %-30s %-30s %-30s %-30s %-25s%n";
		out.print(String.format(formatStr, "Customer Name", "Customer Phone Number", "Delivery Address", "Email Address", "Order Quantity", "Cost"));
		Order order = new Order(getAmt());
		out.print(String.format(formatStr, getCustomerName(), getPhoneNum(), getDeliveryAddress(), getEmailAddress(), getAmt(), order.total()));
		out.close();
	}

	private String getCustomerName() {
		return customerName;
	}

	private String getPhoneNum() {
		return phoneNum;
	}

	private String getDeliveryAddress() {
		return deliveryAddress;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (String value : customerArray) {
			builder.append(value).append(" ");
		}

		return "Customer Data:\n " + builder.toString();
	}

	private String getEmailAddress() {
		return emailAddress;
	}

	private int getAmt() {
		return amt;
	}

}
