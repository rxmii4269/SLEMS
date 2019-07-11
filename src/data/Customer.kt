package data

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.util.*

class Customer @Throws(IOException::class)
constructor(private val customerName: String, private val phoneNum: String, private val deliveryAddress: String, private val emailAddress: String, private val amt: Int) {

    var customerArray = ArrayList<String>()
    private val writeTable = FileWriter("src/resources/Customer Info.txt", StandardCharsets.UTF_8, true)
    private val bw = BufferedWriter(writeTable)
    private val out = PrintWriter(bw)

    fun customerInfo() {
        val formatStr = "%-30s %-30s %-30s %-30s %-30s %-25s%n"
        out.print(String.format(formatStr, "Customer Name", "Customer Phone Number", "Delivery Address", "Email Address", "Order Quantity", "Cost"))
        val order = Order(amt.toLong())
        out.print(String.format(formatStr, customerName, phoneNum, deliveryAddress, emailAddress, amt, order.total()))
        out.close()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (value in customerArray) {
            builder.append(value).append(" ")
        }

        return "Customer data:\n $builder"
    }

}
