package ui

import java.awt.Color
import java.awt.EventQueue
import java.awt.Font
import java.awt.SystemColor
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.*

class EditUserUI
/**
 * Create the application.
 */
@Throws(IOException::class)
internal constructor() {

    internal var frame: JFrame? = null
        private set

    init {
        initialize()
    }

    /**
     * Initialize the contents of the frame.
     */
    @Throws(IOException::class)
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
        lblNewLabel1.setBounds(158, 89, 246, 23)
        frame!!.contentPane.add(lblNewLabel1)

        val lblNewLabel2 = JLabel("Last Name")
        lblNewLabel2.font = Font("Arial", Font.BOLD, 15)
        lblNewLabel2.setBounds(32, 333, 108, 14)
        frame!!.contentPane.add(lblNewLabel2)

        val textField = JTextField()
        textField.setBounds(32, 299, 202, 23)
        frame!!.contentPane.add(textField)
        textField.columns = 10

        val btnLogin = JButton("EDIT USER")
        btnLogin.foreground = Color.WHITE
        btnLogin.background = Color(25, 25, 112)
        btnLogin.setBounds(304, 368, 154, 38)
        frame!!.contentPane.add(btnLogin)

        val label1 = JLabel("First Name")
        label1.font = Font("Arial", Font.BOLD, 15)
        label1.setBounds(32, 274, 108, 14)
        frame!!.contentPane.add(label1)

        val textField1 = JTextField()
        textField1.columns = 10
        textField1.setBounds(32, 358, 202, 23)
        frame!!.contentPane.add(textField1)

        val lblEmailAddress = JLabel("Email Address")
        lblEmailAddress.font = Font("Arial", Font.BOLD, 15)
        lblEmailAddress.setBounds(32, 392, 108, 14)
        frame!!.contentPane.add(lblEmailAddress)

        val textField2 = JTextField()
        textField2.columns = 10
        textField2.setBounds(32, 417, 202, 23)
        frame!!.contentPane.add(textField2)

        val lblPhoneNumber = JLabel("Phone Number")
        lblPhoneNumber.font = Font("Arial", Font.BOLD, 15)
        lblPhoneNumber.setBounds(289, 276, 108, 14)
        frame!!.contentPane.add(lblPhoneNumber)

        val textField3 = JTextField()
        textField3.columns = 10
        textField3.setBounds(289, 301, 202, 23)
        frame!!.contentPane.add(textField3)

        val lblPleaseEnterEmployee = JLabel("Please Enter Employee ID")
        lblPleaseEnterEmployee.horizontalAlignment = SwingConstants.LEFT
        lblPleaseEnterEmployee.font = Font("Arial", Font.BOLD, 15)
        lblPleaseEnterEmployee.setBounds(32, 216, 215, 14)
        frame!!.contentPane.add(lblPleaseEnterEmployee)

        val textField5 = JTextField()
        textField5.columns = 10
        textField5.setBounds(35, 242, 212, 23)
        frame!!.contentPane.add(textField5)

        val lblEnterYourPosition = JLabel("Enter your Position")
        lblEnterYourPosition.horizontalAlignment = SwingConstants.LEFT
        lblEnterYourPosition.font = Font("Arial", Font.BOLD, 15)
        lblEnterYourPosition.setBounds(286, 218, 268, 14)
        frame!!.contentPane.add(lblEnterYourPosition)

        val textField6 = JTextField()
        textField6.columns = 10
        textField6.setBounds(286, 244, 202, 23)
        frame!!.contentPane.add(textField6)


        // Add Action Listener and pop up message to show that it was a successful.
        val lblNewLabel3 = JLabel("EDIT USER")
        lblNewLabel3.foreground = SystemColor.windowBorder
        lblNewLabel3.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel3.font = Font("Arial", Font.BOLD, 18)
        lblNewLabel3.setBounds(168, 123, 219, 28)
        frame!!.contentPane.add(lblNewLabel3)

        val lblChooseUserTo = JLabel("Choose user to Edit ")
        lblChooseUserTo.horizontalAlignment = SwingConstants.CENTER
        lblChooseUserTo.setBounds(178, 156, 193, 14)
        frame!!.contentPane.add(lblChooseUserTo)
        val user = NewUserUI()
        val array = user.details.toTypedArray()
        val comboBox = JComboBox(array)
        comboBox.isEditable = true
        comboBox.background = Color.WHITE
        comboBox.setBounds(178, 178, 193, 29)
        frame!!.contentPane.add(comboBox)

        val btnBack = JButton("BACK")
        btnBack.addActionListener {

            frame!!.dispose()
            var previous: NewUserUI? = null
            try {
                previous = NewUserUI()
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

        val date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
        val now = LocalDateTime.now()

        val lblNewLabel4 = JLabel(date.format(now))
        lblNewLabel4.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel4.setBounds(175, 112, 206, 14)
        frame!!.contentPane.add(lblNewLabel4)
    }

    companion object {

        /**
         * Launch the application.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                try {
                    val window = EditUserUI()
                    window.frame!!.setLocationRelativeTo(null)
                    window.frame!!.isVisible = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}