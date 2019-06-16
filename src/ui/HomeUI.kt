package ui

import report.Report
import security.LoginUserUI
import java.awt.Color
import java.awt.EventQueue
import java.awt.Font
import java.awt.SystemColor
import java.io.IOException
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Paths
import javax.swing.*

class HomeUI {
    var frame: JFrame? = null
        private set

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
        frame!!.setBounds(100, 100, 570, 550)
        frame!!.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame!!.isResizable = false
        frame!!.isFocusable = true
        frame!!.contentPane.layout = null

        val label = JLabel("WELCOME TO ")
        label.foreground = SystemColor.controlDkShadow
        label.horizontalAlignment = SwingConstants.CENTER
        label.font = Font("Ebrima", Font.BOLD, 24)
        label.setBounds(10, 22, 554, 23)
        frame!!.contentPane.add(label)

        val lblNewLabel = JLabel("SUPER FRESH EGGS")
        lblNewLabel.foreground = Color(25, 25, 112)
        lblNewLabel.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel.font = Font("Poetsen One", Font.BOLD, 40)
        lblNewLabel.setBounds(70, 42, 408, 48)
        frame!!.contentPane.add(lblNewLabel)
        val lblNewLabel1 = JLabel("MANAGEMENT SYSTEM")
        lblNewLabel1.foreground = SystemColor.controlDkShadow
        lblNewLabel1.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel1.font = Font("Ebrima", Font.BOLD, 22)
        lblNewLabel1.setBounds(80, 84, 386, 23)
        frame!!.contentPane.add(lblNewLabel1)

        val lblNewLabel3 = JLabel("HOME SCREEN")
        lblNewLabel3.foreground = SystemColor.windowBorder
        lblNewLabel3.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel3.font = Font("Arial", Font.BOLD, 25)
        lblNewLabel3.setBounds(159, 118, 219, 28)
        frame!!.contentPane.add(lblNewLabel3)

        val btnNewButton = JButton("Add/Edit  user")
        btnNewButton.foreground = Color.WHITE
        btnNewButton.background = Color(25, 25, 112)
        btnNewButton.addActionListener {

            frame!!.dispose()
            var addUser: NewUserUI? = null
            try {
                addUser = NewUserUI()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            if (addUser != null) {
                addUser.frame!!.setLocationRelativeTo(null)
                addUser.frame!!.isVisible = true
            }
        }
        btnNewButton.setBounds(386, 180, 142, 29)
        frame!!.contentPane.add(btnNewButton)

        val btnExternalSup = JButton("Add/ Edit Supplier")
        btnExternalSup.addActionListener {

            frame!!.dispose()
            var supplierUI: NewExtSupplierUI? = null
            try {
                supplierUI = NewExtSupplierUI()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            if (supplierUI != null) {
                supplierUI.frame!!.setLocationRelativeTo(null)
                supplierUI.frame!!.isVisible = true
            }
        }
        btnExternalSup.foreground = Color.WHITE
        btnExternalSup.background = Color(25, 25, 112)
        btnExternalSup.setBounds(386, 231, 142, 28)
        frame!!.contentPane.add(btnExternalSup)

        val btnAddOrders = JButton("Add Order")
        btnAddOrders.addActionListener {
            frame!!.dispose()
            val order = NewOrderUI()
            order.frame!!.setLocationRelativeTo(null)
            order.frame!!.isVisible = true
        }
        btnAddOrders.foreground = Color.WHITE
        btnAddOrders.background = Color(25, 25, 112)
        btnAddOrders.setBounds(386, 309, 142, 29)
        frame!!.contentPane.add(btnAddOrders)

        val textArea = JTextArea()
        textArea.background = UIManager.getColor("Button.background")
        textArea.foreground = Color.BLACK
        textArea.setBounds(23, 157, 340, 301)
        frame!!.contentPane.add(textArea)


        val btnViewSuppliers = JButton("View Suppliers")
        btnViewSuppliers.foreground = Color.WHITE
        btnViewSuppliers.background = Color(25, 25, 112)
        btnViewSuppliers.setBounds(386, 270, 142, 28)
        frame!!.contentPane.add(btnViewSuppliers)

        val btnUpdateInventory = JButton("Add/Edit Inventory")
        btnUpdateInventory.foreground = Color.WHITE
        btnUpdateInventory.background = Color(25, 25, 112)
        btnUpdateInventory.setBounds(386, 383, 142, 27)
        btnUpdateInventory.addActionListener {

            frame!!.dispose()
            var data: EnterDataUI? = null
            try {
                data = EnterDataUI()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            if (data != null) {
                data.frame!!.setLocationRelativeTo(null)
                data.frame!!.isVisible = true
            }
        }
        frame!!.contentPane.add(btnUpdateInventory)

        val btnGenerateReport1 = JButton("Generate report")
        btnGenerateReport1.foreground = Color.WHITE
        btnGenerateReport1.background = Color(25, 25, 112)
        btnGenerateReport1.setBounds(386, 421, 142, 27)
        btnGenerateReport1.addActionListener {
            var report: Report? = null
            try {
                report = Report()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            if (report != null) {
                try {
                    report.generateReport()
                } catch (ex: IOException) {
                    ex.printStackTrace()
                }

            }
            JOptionPane.showMessageDialog(frame, "report Successfully Created", "SLEMS",
                    JOptionPane.INFORMATION_MESSAGE, ImageIcon(HomeUI::class.java.getResource("/resources/check-mark.png")))


        }
        frame!!.contentPane.add(btnGenerateReport1)

        val btnLogout = JButton("LOGOUT")
        btnLogout.foreground = Color.BLACK
        btnLogout.background = Color.WHITE
        btnLogout.addActionListener {

            frame!!.dispose()
            val login = LoginUserUI()
            login.frame!!.setLocationRelativeTo(null)
            login.frame!!.isVisible = true
        }

        btnLogout.setBounds(455, 8, 89, 23)
        frame!!.contentPane.add(btnLogout)

        val btnViewOrders1 = JButton("View Orders")
        btnViewOrders1.foreground = Color.WHITE
        btnViewOrders1.background = Color(25, 25, 112)
        btnViewOrders1.setBounds(386, 349, 142, 27)
        frame!!.contentPane.add(btnViewOrders1)
        btnViewOrders1.addActionListener {
            try {
                val content = String(Files.readAllBytes(Paths.get("./Customer Info.txt")))
                textArea.append(content)
                textArea.font = Font("Arial", Font.PLAIN, 12)

            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            try {

                textArea.read(InputStreamReader(
                        javaClass.getResourceAsStream("./Customer Info.txt")), null)

            } catch (f: Exception) {
                f.printStackTrace()
            }
        }
    }

    companion object {

        /**
         * Launch the application.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                try {
                    val window = HomeUI()
                    window.frame!!.isVisible = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

}
