package ui

import data.Customer
import data.Order
import database.DBConnect
import java.awt.Color
import java.awt.EventQueue
import java.awt.Font
import java.awt.SystemColor
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.*

class NewOrderUI {

    var frame: JFrame? = null
        private set
    private var customerField: JTextField? = null
    private var phoneField: JTextField? = null
    private var emailField: JTextField? = null
    private var deliveryField: JTextField? = null
    private var amtField: JTextField? = null

    /**
     * Create the application.
     */
    init {
        initialize()
    }

    /**
     * Initialize the contents of the frame.
     */
    private fun initialize() {
        frame = JFrame()
        frame!!.contentPane.background = Color.WHITE
        frame!!.setBounds(100, 100, 570, 520)
        frame!!.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame!!.isResizable = false
        frame!!.contentPane.layout = null

        val label = JLabel("WELCOME TO ")
        label.foreground = SystemColor.controlDkShadow
        label.horizontalAlignment = SwingConstants.CENTER
        label.font = Font("Ebrima", Font.BOLD, 24)
        label.setBounds(0, 27, 554, 23)
        frame!!.contentPane.add(label)

        val lblNewLabel = JLabel("SUPER FRESH EGGS")
        lblNewLabel.foreground = Color(25, 25, 112)
        lblNewLabel.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel.font = Font("Poetsen One", Font.BOLD, 40)
        lblNewLabel.setBounds(73, 45, 408, 48)
        frame!!.contentPane.add(lblNewLabel)

        val lblNewLabel1 = JLabel("MANAGEMENT SYSTEM")
        lblNewLabel1.foreground = SystemColor.controlDkShadow
        lblNewLabel1.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel1.font = Font("Ebrima", Font.BOLD, 22)
        lblNewLabel1.setBounds(158, 89, 246, 23)
        frame!!.contentPane.add(lblNewLabel1)

        val phoneLabel = JLabel("Phone Number")
        phoneLabel.font = Font("Arial", Font.BOLD, 15)
        phoneLabel.setBounds(37, 258, 202, 14)
        frame!!.contentPane.add(phoneLabel)

        customerField = JTextField()
        customerField!!.setBounds(37, 224, 202, 23)
        frame!!.contentPane.add(customerField)
        customerField!!.columns = 10

        val lblNewLabel2 = JLabel()
        lblNewLabel2.setBounds(437, 285, 70, 14)
        frame!!.contentPane.add(lblNewLabel2)


        val btnLogin = JButton("CONFIRM ORDER")
        btnLogin.foreground = Color.WHITE
        btnLogin.background = Color(25, 25, 112)
        btnLogin.setBounds(327, 357, 168, 48)
        frame!!.contentPane.add(btnLogin)
        btnLogin.addActionListener {
            val custName = customerField!!.text
            val phoneNum = phoneField!!.text
            val address = deliveryField!!.text
            val email = emailField!!.text
            val amt = Integer.parseInt(amtField!!.text)
            var customer: Customer? = null
            try {
                customer = Customer(custName!!, phoneNum!!, address!!, email!!, amt)
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            customer?.customerArray?.add(custName)
            customer?.customerArray?.add(phoneNum)
            customer?.customerArray?.add(address)
            customer?.customerArray?.add(email)
            customer?.customerArray?.add(amt.toString())
            val order = Order(amt.toLong())
            customer?.customerInfo()
            lblNewLabel2.text = "$" + order.total()
            val write = DBConnect()
            write.writeToDBCust(custName!!, phoneNum!!.toLong(), address!!, email!!, amt, order.total().toInt())
        }


        val lblCustomerName = JLabel("Customer Name")
        lblCustomerName.font = Font("Arial", Font.BOLD, 15)
        lblCustomerName.setBounds(37, 199, 202, 14)
        frame!!.contentPane.add(lblCustomerName)

        val lblDeliveryAddress = JLabel("Delivery Address")
        lblDeliveryAddress.font = Font("Arial", Font.BOLD, 15)
        lblDeliveryAddress.setBounds(37, 373, 202, 14)
        frame!!.contentPane.add(lblDeliveryAddress)

        val lblNewLabel3 = JLabel("NEW ORDER")
        lblNewLabel3.foreground = SystemColor.windowBorder
        lblNewLabel3.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel3.font = Font("Arial", Font.BOLD, 18)
        lblNewLabel3.setBounds(162, 137, 219, 28)
        frame!!.contentPane.add(lblNewLabel3)


        val lblEmailAddress = JLabel("Email Address")
        lblEmailAddress.font = Font("Arial", Font.BOLD, 15)
        lblEmailAddress.setBounds(37, 312, 202, 14)
        frame!!.contentPane.add(lblEmailAddress)

        val lblIfItIs = JLabel("If it is a pick up order, type N/A")
        lblIfItIs.horizontalAlignment = SwingConstants.CENTER
        lblIfItIs.setBounds(37, 420, 202, 14)
        frame!!.contentPane.add(lblIfItIs)

        phoneField = JTextField()
        phoneField!!.columns = 10
        phoneField!!.setBounds(37, 276, 202, 23)
        frame!!.contentPane.add(phoneField)

        emailField = JTextField()
        emailField!!.columns = 10
        emailField!!.setBounds(37, 331, 202, 23)
        frame!!.contentPane.add(emailField)

        deliveryField = JTextField()
        deliveryField!!.columns = 10
        deliveryField!!.setBounds(37, 398, 202, 23)
        frame!!.contentPane.add(deliveryField)

        val lblEnterAmount = JLabel("Enter Amount:")
        lblEnterAmount.font = Font("Arial", Font.BOLD, 15)
        lblEnterAmount.setBounds(313, 228, 135, 14)
        frame!!.contentPane.add(lblEnterAmount)

        amtField = JTextField()
        amtField!!.setBounds(437, 224, 95, 23)
        frame!!.contentPane.add(amtField)
        amtField!!.columns = 10


        val lblTotal = JLabel("Total:")
        lblTotal.font = Font("Arial", Font.BOLD, 15)
        lblTotal.setBounds(313, 285, 135, 14)
        frame!!.contentPane.add(lblTotal)

        val lblEnterType = JLabel("Enter Type")
        lblEnterType.font = Font("Arial", Font.BOLD, 15)
        lblEnterType.setBounds(313, 259, 135, 14)
        frame!!.contentPane.add(lblEnterType)

        val typeBox = JComboBox<String>()
        typeBox.background = Color(255, 255, 255)
        typeBox.setBounds(437, 256, 95, 20)
        frame!!.contentPane.add(typeBox)

        typeBox.addItem("Liquid Eggs")
        typeBox.addItem("Shell Eggs")


        val date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
        val now = LocalDateTime.now()

        val lblNewLabel4 = JLabel(date.format(now))
        lblNewLabel4.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel4.setBounds(175, 112, 206, 14)
        frame!!.contentPane.add(lblNewLabel4)
        val btnBack = JButton("BACK")
        btnBack.addActionListener {

            frame!!.dispose()
            val home = HomeUI()
            home.frame!!.setLocationRelativeTo(null)
            home.frame!!.isVisible = true

        }
        btnBack.background = Color.WHITE
        btnBack.setBounds(10, 11, 89, 23)
        frame!!.contentPane.add(btnBack)
    }

    companion object {

        /**
         * Launch the application.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                try {
                    val window = NewOrderUI()
                    window.frame!!.setLocationRelativeTo(null)
                    window.frame!!.isVisible = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
