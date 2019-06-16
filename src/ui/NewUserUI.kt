package ui

import database.DBConnect
import user.Subordinate
import user.Supervisor
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

class NewUserUI
/**
 * Create the application.
 */
@Throws(IOException::class)
constructor() {

    internal var details = ArrayList<String>()
    private var empIDField: JTextField? = null
    var frame: JFrame? = null
        private set
    private var fNameField: JTextField? = null
    private var lNameField: JTextField? = null
    private var emailField: JTextField? = null
    private var phoneField: JTextField? = null
    private var letterSWField: JTextField? = null
    private var positionField: JTextField? = null
    private val writeTable = FileWriter("src/resources/user Info.txt", StandardCharsets.UTF_8, true)
    private val bw = BufferedWriter(writeTable)
    private val out = PrintWriter(bw)
    private val formatStr = "%-30s %-30s %-30s %-30s %-20s %-15s%n"
    private val write = DBConnect()


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

        val lblNewLabel2 = JLabel("Last Name")
        lblNewLabel2.font = Font("Arial", Font.BOLD, 15)
        lblNewLabel2.setBounds(33, 246, 108, 14)
        frame!!.contentPane.add(lblNewLabel2)

        fNameField = JTextField()
        fNameField!!.setBounds(33, 201, 202, 23)
        frame!!.contentPane.add(fNameField)
        fNameField!!.columns = 10


        val btnEditUser = JButton("EDIT USER")
        btnEditUser.foreground = Color.WHITE
        btnEditUser.background = Color(25, 25, 112)
        btnEditUser.setBounds(317, 419, 127, 33)
        frame!!.contentPane.add(btnEditUser)
        btnEditUser.addActionListener {

            frame!!.dispose()
            var edit: EditUserUI? = null
            try {
                edit = EditUserUI()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            if (edit != null) {
                edit.frame!!.setLocationRelativeTo(null)
                edit.frame!!.isVisible = true
            }
        }

        val date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
        val now = LocalDateTime.now()

        val lblNewLabel4 = JLabel(date.format(now))
        lblNewLabel4.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel4.setBounds(175, 112, 206, 14)
        frame!!.contentPane.add(lblNewLabel4)
        // Add pop up message to Add user to show data has been added successfully.
        val saveBtn = JButton("ADD USER")
        saveBtn.foreground = Color.WHITE
        saveBtn.background = Color(25, 25, 112)
        saveBtn.setBounds(317, 375, 127, 33)
        frame!!.contentPane.add(saveBtn)
        out.print(String.format(formatStr, "Employee ID", "First Name", "Last Name", "Email Address", "Phone Number", "Position"))
        saveBtn.addActionListener {
            when {
                letterSWField!!.text.equals("s", ignoreCase = true) -> {
                    details.add(empIDField!!.text)
                    details.add(fNameField!!.text)
                    details.add(lNameField!!.text)
                    details.add(emailField!!.text)
                    details.add(phoneField!!.text)
                    details.add(positionField!!.text)

                    out.print(String.format(formatStr, details[0], details[1], details[2],
                            details[3], details[4], details[5]))
                    Supervisor.instance

                    write.writeToDBUser(empIDField!!.text, details[1], details[2], details[3],
                            details[4], details[5])

                }
                letterSWField!!.text.equals("w", ignoreCase = true) -> {

                    details.add(empIDField!!.text)
                    details.add(fNameField!!.text)
                    details.add(lNameField!!.text)
                    details.add(emailField!!.text)
                    details.add(phoneField!!.text)
                    details.add(positionField!!.text)
                    out.print(String.format(formatStr, details[0], details[1], details[2],
                            details[3], details[4], details[5]))

                    write.writeToDBUser(empIDField!!.text, details[1], details[2], details[3],
                            details[4], details[5])

                    Subordinate()


                }
                else -> {
                    println("Please select the correct letters")
                    println(String(CharArray(50)).replace("\u0000", "\r\n"))

                }
            }

            JOptionPane.showMessageDialog(frame, "user added", "SLEMS",
                    JOptionPane.INFORMATION_MESSAGE, ImageIcon(javaClass.getResource("/resources/check-mark.png")))

            out.close()
        }


        val label1 = JLabel("First Name")
        label1.font = Font("Arial", Font.BOLD, 15)
        label1.setBounds(33, 176, 108, 14)
        frame!!.contentPane.add(label1)

        lNameField = JTextField()
        lNameField!!.columns = 10
        lNameField!!.setBounds(33, 272, 202, 23)
        frame!!.contentPane.add(lNameField)

        val lblEmailAddress = JLabel("Email Address")
        lblEmailAddress.font = Font("Arial", Font.BOLD, 15)
        lblEmailAddress.setBounds(33, 317, 108, 14)
        frame!!.contentPane.add(lblEmailAddress)

        emailField = JTextField()
        emailField!!.columns = 10
        emailField!!.setBounds(33, 342, 202, 23)
        frame!!.contentPane.add(emailField)

        val lblPhoneNumber = JLabel("Phone Number")
        lblPhoneNumber.font = Font("Arial", Font.BOLD, 15)
        lblPhoneNumber.setBounds(33, 387, 108, 14)
        frame!!.contentPane.add(lblPhoneNumber)

        phoneField = JTextField()
        phoneField!!.columns = 10
        phoneField!!.setBounds(33, 411, 202, 23)
        frame!!.contentPane.add(phoneField)

        val lblPleaseEnterSupervisor = JLabel("Please Enter [S]upervisor or [W]orker")
        lblPleaseEnterSupervisor.horizontalAlignment = SwingConstants.CENTER
        lblPleaseEnterSupervisor.font = Font("Arial", Font.BOLD, 15)
        lblPleaseEnterSupervisor.setBounds(276, 176, 268, 14)
        frame!!.contentPane.add(lblPleaseEnterSupervisor)

        letterSWField = JTextField()
        letterSWField!!.columns = 10
        letterSWField!!.setBounds(276, 202, 202, 23)
        frame!!.contentPane.add(letterSWField)

        val lblPleaseEnterEmployee = JLabel("Please Enter Employee ID")
        lblPleaseEnterEmployee.horizontalAlignment = SwingConstants.LEFT
        lblPleaseEnterEmployee.font = Font("Arial", Font.BOLD, 15)
        lblPleaseEnterEmployee.setBounds(276, 247, 268, 14)
        frame!!.contentPane.add(lblPleaseEnterEmployee)

        empIDField = JTextField()
        empIDField!!.columns = 10
        empIDField!!.setBounds(279, 273, 202, 23)
        frame!!.contentPane.add(empIDField)

        val label2 = JLabel("Please Enter Position")
        label2.horizontalAlignment = SwingConstants.LEFT
        label2.font = Font("Arial", Font.BOLD, 15)
        label2.setBounds(276, 318, 268, 14)
        frame!!.contentPane.add(label2)

        positionField = JTextField()
        positionField!!.columns = 10
        positionField!!.setBounds(276, 343, 202, 23)
        frame!!.contentPane.add(positionField)

        val lblNewLabel3 = JLabel("CREATE NEW USER ")
        lblNewLabel3.foreground = SystemColor.windowBorder
        lblNewLabel3.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel3.font = Font("Arial", Font.BOLD, 18)
        lblNewLabel3.setBounds(162, 137, 219, 28)
        frame!!.contentPane.add(lblNewLabel3)

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
