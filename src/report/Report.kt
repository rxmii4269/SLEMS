package report

import java.io.*
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Report/*report(ExternalEggSupplier externalEggSupplier, Customer customerArray,Product product, Egg egg) throws IOException {
		this.externalEggSupplier = externalEggSupplier;
		this.customerArray = customerArray;
		this.product = product;
		this.egg = egg;
	}*/
@Throws(IOException::class)
constructor() {
    private val date = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy HH:mm:ss")
    private val now = LocalDateTime.now()
    private val writeTable = FileWriter("src/resources/report.txt", StandardCharsets.UTF_8)
    private val bw = BufferedWriter(writeTable)
    private val out = PrintWriter(bw)
    private val supplier = BufferedReader(FileReader("Supplier Info.txt"))
    private val customer = BufferedReader(FileReader("Customer Info.txt"))
    private val product = BufferedReader(FileReader("Product.txt"))

    @Throws(IOException::class)
    fun generateReport() {
        out.println("Created by " + "Supervisor ")
        out.println("Compiled on: " + date.format(now) + "\n\n")
        val sup = supplier.readLine()
        val cust = customer.readLine()
        val prod = product.readLine()
        sup.lineSequence().forEach { out.println(it) }

        out.println("\n")
        cust.lineSequence().forEach { out.println(it) }
        out.println("\n")
        prod.lineSequence().forEach { out.println(it) }

        out.flush()
        out.close()
        supplier.close()
        customer.close()
        product.close()
    }


}