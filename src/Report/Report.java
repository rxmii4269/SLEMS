package Report;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
	private DateTimeFormatter date = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy HH:mm:ss");
	private LocalDateTime now = LocalDateTime.now();
	private FileWriter writeTable = new FileWriter("src/resources/Report.txt", StandardCharsets.UTF_8);
	private BufferedWriter bw = new BufferedWriter(writeTable);
	private PrintWriter out = new PrintWriter(bw);
	private BufferedReader supplier = new BufferedReader(new FileReader("Supplier Info.txt"));
	private BufferedReader customer = new BufferedReader(new FileReader("Customer Info.txt"));
	private BufferedReader product = new BufferedReader(new FileReader("Product.txt"));


	/*Report(ExternalEggSupplier externalEggSupplier, Customer customerArray,Product product, Egg egg) throws IOException {
		this.externalEggSupplier = externalEggSupplier;
		this.customerArray = customerArray;
		this.product = product;
		this.egg = egg;
	}*/
	public Report() throws IOException {

	}

	public void generateReport() throws IOException {
		out.println("Created by " + "Supervisor ");
		out.println("Compiled on: " + getDate().format(now) + "\n\n");
		String count;
		while ((count = supplier.readLine()) != null) {
			out.println(count);
		}
		out.println("\n");
		while ((count = customer.readLine()) != null) {
			out.println(count);
		}
		out.println("\n");

		while ((count = product.readLine()) != null) {
			out.println(count);
		}
		out.flush();
		out.close();
		supplier.close();
	}


	private DateTimeFormatter getDate() {
		return date;
	}


}