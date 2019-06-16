package ui

import java.awt.Color
import java.awt.EventQueue
import java.awt.Font
import java.awt.SystemColor
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.*

class EditSupplierUI
/**
 * Create the application.
 */
internal constructor() {

    internal var frame: JFrame? = null
        private set

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
        frame!!.isFocusable = true
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
        lblNewLabel1.setBounds(158, 89, 260, 23)
        frame!!.contentPane.add(lblNewLabel1)


        val label1 = JLabel("Company Name")
        label1.font = Font("Arial", Font.BOLD, 15)
        label1.setBounds(300, 149, 115, 14)
        frame!!.contentPane.add(label1)

        val companyName = JTextField()
        companyName.setBounds(300, 174, 202, 23)
        frame!!.contentPane.add(companyName)
        companyName.columns = 10

        val lblEmailAddress = JLabel("Email Address")
        lblEmailAddress.font = Font("Arial", Font.BOLD, 15)
        lblEmailAddress.setBounds(300, 268, 108, 14)
        frame!!.contentPane.add(lblEmailAddress)

        val emailField = JTextField()
        emailField.columns = 10
        emailField.setBounds(300, 293, 202, 23)
        frame!!.contentPane.add(emailField)

        val lblPhoneNumber = JLabel("Phone Number")
        lblPhoneNumber.font = Font("Arial", Font.BOLD, 15)
        lblPhoneNumber.setBounds(300, 327, 108, 14)
        frame!!.contentPane.add(lblPhoneNumber)

        val phoneField = JTextField()
        phoneField.columns = 10
        phoneField.setBounds(300, 352, 202, 23)
        frame!!.contentPane.add(phoneField)

        val lblFarmAddress = JLabel("Farm Address")
        lblFarmAddress.font = Font("Arial", Font.BOLD, 15)
        lblFarmAddress.setBounds(300, 384, 108, 14)
        frame!!.contentPane.add(lblFarmAddress)

        val fAddressField = JTextField()
        fAddressField.columns = 10
        fAddressField.setBounds(300, 409, 202, 23)
        frame!!.contentPane.add(fAddressField)

        val btnAddSupplier = JButton("MAKE EDIT")
        btnAddSupplier.addActionListener { }
        btnAddSupplier.foreground = Color.BLACK
        btnAddSupplier.background = Color(25, 25, 112)
        btnAddSupplier.setBounds(325, 443, 140, 23)
        frame!!.contentPane.add(btnAddSupplier)

        val date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
        val now = LocalDateTime.now()

        val lblNewLabel4 = JLabel(date.format(now))
        lblNewLabel4.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel4.setBounds(175, 112, 206, 14)
        frame!!.contentPane.add(lblNewLabel4)

        val comboBox = JComboBox<Any>()
        comboBox.setBounds(43, 231, 193, 29)
        frame!!.contentPane.add(comboBox)

        val lblToEditA = JLabel("Choose Supplier to Edit ")
        lblToEditA.horizontalAlignment = SwingConstants.CENTER
        lblToEditA.setBounds(43, 209, 193, 14)
        frame!!.contentPane.add(lblToEditA)

        val btnBack = JButton("BACK")
        btnBack.addActionListener {

            frame!!.dispose()
            var previous: NewExtSupplierUI? = null
            try {
                previous = NewExtSupplierUI()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            if (previous != null) {
                previous.frame!!.setLocationRelativeTo(null)
                previous.frame!!.isVisible = true
            }

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
                    val window = EditSupplierUI()
                    window.frame!!.setLocationRelativeTo(null)
                    window.frame!!.isVisible = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}