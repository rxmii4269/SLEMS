package ui

import data.Egg
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
import javax.swing.*

class EnterDataUI
/**
 * Create the application.
 */
@Throws(IOException::class)
internal constructor() {
    internal var frame: JFrame? = null
        private set
    private var idField: JTextField? = null
    private var eCollectedField: JTextField? = null
    private var eSpoiltField: JTextField? = null
    private var eBrokenField: JTextField? = null
    private var workstationS: JTextField? = null
    private var workstationN: JTextField? = null
    private val writeTable = FileWriter("src/resources/data.txt", StandardCharsets.UTF_8, true)
    private val bw = BufferedWriter(writeTable)
    private val out = PrintWriter(bw)
    private val product = FileWriter("src/resources/Product.txt", StandardCharsets.UTF_8, true)
    private val pw = BufferedWriter(product)
    private val pout = PrintWriter(pw)
    private val formatter = "%-30s %-30s %-30s%n"
    private val formatStr = "%-30s %-30s %-30s %-15s %-25s %-20s%n"
    private var eggsSpoiled: Int = 0
    private var eggsCollected: Int = 0
    private var eggsBroken: Int = 0

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

        val lblNewLabel2 = JLabel("Enter Workstation Section:")
        lblNewLabel2.font = Font("Arial", Font.BOLD, 15)
        lblNewLabel2.setBounds(33, 250, 202, 14)
        frame!!.contentPane.add(lblNewLabel2)

        idField = JTextField()
        idField!!.setBounds(33, 201, 202, 28)
        frame!!.contentPane.add(idField)
        idField!!.columns = 10

        val lblEnterYourId = JLabel("Enter your ID Number:")
        lblEnterYourId.font = Font("Arial", Font.BOLD, 15)
        lblEnterYourId.setBounds(33, 176, 180, 14)
        frame!!.contentPane.add(lblEnterYourId)

        val lblEmailAddress = JLabel("Enter Workstation Number:")
        lblEmailAddress.font = Font("Arial", Font.BOLD, 15)
        lblEmailAddress.setBounds(33, 336, 202, 14)
        frame!!.contentPane.add(lblEmailAddress)

        val lblPleaseEnterSupervisor = JLabel("Enter Eggs Collected:")
        lblPleaseEnterSupervisor.horizontalAlignment = SwingConstants.LEFT
        lblPleaseEnterSupervisor.font = Font("Arial", Font.BOLD, 15)
        lblPleaseEnterSupervisor.setBounds(295, 205, 174, 23)
        frame!!.contentPane.add(lblPleaseEnterSupervisor)

        eCollectedField = JTextField()
        eCollectedField!!.columns = 10
        eCollectedField!!.setBounds(473, 202, 55, 23)
        frame!!.contentPane.add(eCollectedField)

        val lblPleaseEnterEmployee = JLabel("Enter Eggs Spoilt:")
        lblPleaseEnterEmployee.horizontalAlignment = SwingConstants.LEFT
        lblPleaseEnterEmployee.font = Font("Arial", Font.BOLD, 15)
        lblPleaseEnterEmployee.setBounds(295, 242, 168, 23)
        frame!!.contentPane.add(lblPleaseEnterEmployee)

        val lblEnterEggsBroken = JLabel("Enter Eggs Broken:")
        lblEnterEggsBroken.horizontalAlignment = SwingConstants.LEFT
        lblEnterEggsBroken.font = Font("Arial", Font.BOLD, 15)
        lblEnterEggsBroken.setBounds(295, 282, 161, 21)
        frame!!.contentPane.add(lblEnterEggsBroken)

        val lblNewLabel3 = JLabel("ENTER DAILY DATA ")
        lblNewLabel3.foreground = SystemColor.windowBorder
        lblNewLabel3.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel3.font = Font("Arial", Font.BOLD, 18)
        lblNewLabel3.setBounds(162, 137, 219, 28)
        frame!!.contentPane.add(lblNewLabel3)

        val date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
        val now = LocalDateTime.now()

        val lblNewLabel4 = JLabel(date.format(now))
        lblNewLabel4.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel4.setBounds(175, 112, 206, 14)
        frame!!.contentPane.add(lblNewLabel4)


        eSpoiltField = JTextField()
        eSpoiltField!!.columns = 10
        eSpoiltField!!.setBounds(473, 238, 55, 23)
        frame!!.contentPane.add(eSpoiltField)

        eBrokenField = JTextField()
        eBrokenField!!.columns = 10
        eBrokenField!!.setBounds(473, 280, 55, 23)
        frame!!.contentPane.add(eBrokenField)

        val btnGoHome = JButton("Go Home")
        btnGoHome.addActionListener {

            frame!!.dispose()
            val home = HomeUI()
            home.frame!!.setLocationRelativeTo(null)
            home.frame!!.isVisible = true
        }
        btnGoHome.foreground = Color.WHITE
        btnGoHome.background = Color(25, 25, 112)
        btnGoHome.setBounds(22, 434, 147, 28)
        frame!!.contentPane.add(btnGoHome)

        val btnSaveData = JButton("Save data")
        btnSaveData.foreground = Color.WHITE
        btnSaveData.background = Color(25, 25, 112)
        btnSaveData.setBounds(191, 434, 147, 28)
        btnSaveData.addActionListener {
            eggsSpoiled = Integer.parseInt(eSpoiltField!!.text)
            eggsCollected = Integer.parseInt(eCollectedField!!.text)
            eggsBroken = Integer.parseInt(eBrokenField!!.text)
            Egg()


            out.println(String.format(formatStr, idField!!.text, eCollectedField!!.text,
                    eSpoiltField!!.text, eBrokenField!!.text, workstationS!!.text,
                    workstationN!!.text))
            out.print("\n")

            pout.println(String.format(formatter, "Collected Eggs", "Spoiled Eggs", "Broken Eggs"))
            pout.println(String.format(formatter, eCollectedField!!.text, eSpoiltField!!.text, eBrokenField!!.text))

            val connect = DBConnect()
            connect.writeToDBDailyEggs(idField!!.text, eCollectedField!!.text, eSpoiltField!!.text,
                    eBrokenField!!.text, workstationS!!.text, workstationN!!.text)

            pout.flush()
            pout.close()
            out.close()

            //Check if all fields are filled
            if (idField!!.text == "" || eCollectedField!!.text == "" ||
                    eSpoiltField!!.text == "" || eBrokenField!!.text == "" ||
                    workstationS!!.text == "" || workstationN!!.text == "") {

                JOptionPane.showMessageDialog(frame, "Please Enter All Fields", "Missing data",
                        JOptionPane.ERROR_MESSAGE)
            } else {

                JOptionPane.showMessageDialog(frame, "data saved", "SLEMS",
                        JOptionPane.INFORMATION_MESSAGE, ImageIcon(javaClass.getResource("/resources/check-mark.png")))
            }
        }
        frame!!.contentPane.add(btnSaveData)

        val btnUnitsProducible = JButton("Units Producible")
        btnUnitsProducible.foreground = Color.WHITE
        btnUnitsProducible.background = Color(25, 25, 112)
        btnUnitsProducible.setBounds(361, 434, 147, 28)
        frame!!.contentPane.add(btnUnitsProducible)


        workstationS = JTextField()
        workstationS!!.columns = 10
        workstationS!!.setBounds(33, 275, 202, 28)
        frame!!.contentPane.add(workstationS)

        workstationN = JTextField()
        workstationN!!.columns = 10
        workstationN!!.setBounds(33, 361, 202, 28)
        frame!!.contentPane.add(workstationN)

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

    override fun toString(): String {
        return "Eggs Collected: $eggsCollected $eggsBroken $eggsBroken"
    }

}
