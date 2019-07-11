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
    private val supplier = BufferedReader(FileReader("src/resources/Supplier Info.txt"))
    private val customer = BufferedReader(FileReader("src/resources/Customer Info.txt"))
    private val product = BufferedReader(FileReader("src/resources/Product.txt"))

    @Throws(IOException::class)
    fun generateReport() {
        out.println("Created by " + "Supervisor ")
        out.println("Compiled on: " + date.format(now) + "\n\n")
        val sup = supplier.readLines()
        val cust = customer.readLines()
        val prod = product.readLines()

        sup.forEach { out.println(it) }
        out.println("\n")
        cust.forEach { out.println(it) }
        out.println("\n")
        prod.forEach { out.print(it + "\n") }
        out.println("\n")

        /*out.println(sup)


        out.println(cust)
        out.println("\n")
        out.println(prod)*/

        out.flush()
        out.close()
        supplier.close()
        customer.close()
        product.close()
    }


}