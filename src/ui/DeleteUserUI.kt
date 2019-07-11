package ui

import java.awt.Color
import java.awt.EventQueue
import java.awt.Font
import java.awt.SystemColor
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.*

class DeleteUserUI
/**
 * Create the application.
 */
private constructor() {

    private var frame: JFrame? = null

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

        val comboBox = JComboBox<Any>()
        comboBox.background = Color.WHITE
        comboBox.setBounds(184, 424, 193, 29)
        frame!!.contentPane.add(comboBox)

        val lblToEditA = JLabel("Choose user to Delete")
        lblToEditA.font = Font("Tahoma", Font.BOLD, 11)
        lblToEditA.horizontalAlignment = SwingConstants.CENTER
        lblToEditA.setBounds(184, 399, 193, 14)
        frame!!.contentPane.add(lblToEditA)

        val textField = JTextField()
        textField.background = UIManager.getColor("Button.background")
        textField.setBounds(58, 129, 450, 257)
        frame!!.contentPane.add(textField)
        textField.columns = 10

        val btnBack = JButton("BACK")
        btnBack.addActionListener {

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
                    val window = DeleteUserUI()
                    window.frame!!.setLocationRelativeTo(null)
                    window.frame!!.isVisible = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}