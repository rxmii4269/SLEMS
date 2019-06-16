package ui

import data.ExternalEggSupplier
import data.ExternalEggSupply
import database.DBConnect
import java.awt.Color
import java.awt.Font
import java.awt.SystemColor
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.swing.*

internal class NewExtSupplierUI
/**
 * Create the application.
 */
@Throws(IOException::class)
constructor() {

    var frame: JFrame? = null
        private set
    private var companyName: JTextField? = null
    private var amtEggField: JTextField? = null
    private var eEmailField: JTextField? = null
    private var ePhoneField: JTextField? = null
    private var efAddressField: JTextField? = null
    private val writeTable = FileWriter("src/resources/Supplier Info.txt", StandardCharsets.UTF_8, true)
    private val bw = BufferedWriter(writeTable)
    private val out = PrintWriter(bw)
    private val externalEggSupplier = ExternalEggSupplier()
    private val details = ArrayList<String>()
    private val formatStr = "%-30s %-30s %-30s %-20s %-20s%n"

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

        companyName = JTextField()
        companyName!!.setBounds(49, 184, 202, 23)
        frame!!.contentPane.add(companyName)
        companyName!!.columns = 10


        val label1 = JLabel("Company Name")
        label1.font = Font("Arial", Font.BOLD, 15)
        label1.setBounds(49, 159, 120, 14)
        frame!!.contentPane.add(label1)


        val lblEmailAddress = JLabel("Email Address")
        lblEmailAddress.font = Font("Arial", Font.BOLD, 15)
        lblEmailAddress.setBounds(49, 218, 108, 14)
        frame!!.contentPane.add(lblEmailAddress)

        eEmailField = JTextField()
        eEmailField!!.columns = 10
        eEmailField!!.setBounds(49, 244, 202, 23)
        frame!!.contentPane.add(eEmailField)

        val lblPhoneNumber = JLabel("Phone Number")
        lblPhoneNumber.font = Font("Arial", Font.BOLD, 15)
        lblPhoneNumber.setBounds(49, 280, 120, 14)
        frame!!.contentPane.add(lblPhoneNumber)

        ePhoneField = JTextField()
        ePhoneField!!.columns = 10
        ePhoneField!!.setBounds(49, 306, 202, 23)
        frame!!.contentPane.add(ePhoneField)

        val lblNewLabel3 = JLabel("EXTERNAL SUPPLIERS")
        lblNewLabel3.foreground = SystemColor.windowBorder
        lblNewLabel3.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel3.font = Font("Arial", Font.BOLD, 18)
        lblNewLabel3.setBounds(168, 132, 219, 28)
        frame!!.contentPane.add(lblNewLabel3)

        val lblFarmAddress = JLabel("Farm Address")
        lblFarmAddress.font = Font("Arial", Font.BOLD, 15)
        lblFarmAddress.setBounds(49, 342, 108, 14)
        frame!!.contentPane.add(lblFarmAddress)

        efAddressField = JTextField()
        efAddressField!!.columns = 10
        efAddressField!!.setBounds(49, 368, 202, 23)
        frame!!.contentPane.add(efAddressField)

        val lblNewLabel2 = JLabel("Amount of Eggs")
        lblNewLabel2.font = Font("Arial", Font.BOLD, 15)
        lblNewLabel2.setBounds(49, 404, 202, 14)
        frame!!.contentPane.add(lblNewLabel2)

        amtEggField = JTextField()
        amtEggField!!.columns = 10
        amtEggField!!.setBounds(49, 430, 202, 23)
        frame!!.contentPane.add(amtEggField)

        val btnEditExistingSuppliers = JButton("Edit Existing Suppliers")
        btnEditExistingSuppliers.foreground = Color.WHITE
        btnEditExistingSuppliers.background = Color(25, 25, 112)
        btnEditExistingSuppliers.setBounds(334, 279, 168, 34)
        frame!!.contentPane.add(btnEditExistingSuppliers)
        btnEditExistingSuppliers.addActionListener {

            frame!!.dispose()
            val edit = EditSupplierUI()
            edit.frame!!.isVisible = true
        }

        val btnDeleteSupplier = JButton("Delete Supplier")
        btnDeleteSupplier.foreground = Color.WHITE
        btnDeleteSupplier.background = Color(25, 25, 112)
        btnDeleteSupplier.setBounds(334, 220, 168, 34)
        frame!!.contentPane.add(btnDeleteSupplier)
        btnDeleteSupplier.addActionListener {

            frame!!.dispose()
            val delete = DeleteSupplierUI()
            delete.frame!!.setLocationRelativeTo(null)
            delete.frame!!.isVisible = true

        }

        val date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
        val now = LocalDateTime.now()

        val lblNewLabel4 = JLabel(date.format(now))
        lblNewLabel4.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel4.setBounds(175, 112, 206, 14)
        frame!!.contentPane.add(lblNewLabel4)

        val button2 = JButton("Add Supplier")
        button2.foreground = Color.WHITE
        button2.background = Color(25, 25, 112)
        button2.setBounds(334, 350, 168, 23)
        button2.addActionListener {
            out.print(String.format(formatStr, "Company Name", "Email Address", "Phone Number", "Farm Address", "Amount of Eggs"))
            details.add(companyName!!.text)
            details.add(eEmailField!!.text)
            details.add(ePhoneField!!.text)
            details.add(efAddressField!!.text)
            details.add(amtEggField!!.text)
            externalEggSupplier.externalEggSupplier.add(companyName!!.text)
            externalEggSupplier.externalEggSupplier.add(eEmailField!!.text)
            externalEggSupplier.externalEggSupplier.add(ePhoneField!!.text)
            externalEggSupplier.externalEggSupplier.add(efAddressField!!.text)
            externalEggSupplier.externalEggSupplier.add(amtEggField!!.text)
            ExternalEggSupply(amtEggField!!.text)

            out.print(String.format(formatStr, details[0], details[1], details[2],
                    details[3], details[4]))
            out.close()
            val connect = DBConnect()
            connect.writeToDBEggSupplier(details[0], details[1], details[2], details[3],
                    details[4])
            JOptionPane.showMessageDialog(frame, "Supplier added", "SLEMS",
                    JOptionPane.INFORMATION_MESSAGE, ImageIcon(javaClass.getResource("/resources/check-mark.png")))


        }
        frame!!.contentPane.add(button2)

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

}

