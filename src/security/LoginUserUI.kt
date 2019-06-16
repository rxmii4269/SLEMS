package security

import ui.HomeUI
import java.awt.Color
import java.awt.Font
import java.awt.SystemColor
import javax.swing.*

class LoginUserUI {

    private var username: String? = null
    //	public String getLoginName(){ return getUserN
    var frame: JFrame? = null
        private set
    private var password: JPasswordField? = null
    private var usernameField: JTextField? = null
    private var passWord = ""

    init {
        initialize()
    }

    /**
     * Initialize the contents of the frame.
     */
    fun initialize() {
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
        lblNewLabel.setBounds(30, 45, 500, 48)
        frame!!.contentPane.add(lblNewLabel)

        val lblNewLabel1 = JLabel("MANAGEMENT SYSTEM")
        lblNewLabel1.foreground = SystemColor.controlDkShadow
        lblNewLabel1.horizontalAlignment = SwingConstants.CENTER
        lblNewLabel1.font = Font("Ebrima", Font.BOLD, 22)
        lblNewLabel1.setBounds(140, 89, 300, 23)
        frame!!.contentPane.add(lblNewLabel1)

        val lblNewLabel2 = JLabel("Username ")
        lblNewLabel2.font = Font("Arial", Font.PLAIN, 18)
        lblNewLabel2.setBounds(127, 163, 108, 14)
        frame!!.contentPane.add(lblNewLabel2)

        password = JPasswordField()
        password!!.setBounds(127, 274, 310, 43)
        frame!!.contentPane.add(password)

        setUsername(JTextField())
        usernameField!!.setBounds(127, 188, 310, 43)
        frame!!.contentPane.add(getUsername())
        usernameField!!.columns = 10


        val lblPassword = JLabel("passWord ")
        lblPassword.font = Font("Arial", Font.PLAIN, 18)
        lblPassword.setBounds(127, 249, 108, 14)
        frame!!.contentPane.add(lblPassword)

        val btnLogin = JButton("LOGIN ")
        frame!!.rootPane.defaultButton = btnLogin
        btnLogin.foreground = Color.WHITE
        btnLogin.background = Color(25, 25, 112)
        btnLogin.addActionListener {

            val password = password!!.password
            for (s in password) {
                val tmp = passWord
                passWord = tmp + s
            }

            username = getUsername()!!.text
            if (passWord.equals("admin", ignoreCase = true) && username!!.equals("Supervisor", ignoreCase = true)) {
                JOptionPane.showMessageDialog(frame, "Login Successful" + "\n " + "Welcome SuperVisor", "SLEMS SUPERVISOR",
                        JOptionPane.INFORMATION_MESSAGE, ImageIcon(javaClass.getResource("/resources/check-mark.png")))


                frame!!.dispose()
// Add HomePage Launch for Supervisor
                val home = HomeUI()
                home.frame?.setLocationRelativeTo(null)
                home.frame?.isVisible = true

            } else if (passWord.equals("worker", ignoreCase = true) && username!!.equals("Subordinate", ignoreCase = true)) {
                JOptionPane.showMessageDialog(frame, "Login Successful" + "\n " + "Welcome Worker", "SLEMS WORKER",
                        JOptionPane.INFORMATION_MESSAGE, ImageIcon(javaClass.getResource("check-mark.png")))
                setText()
                getUsername()!!.text = null

                frame!!.dispose()

                val home = HomeUI()
                home.frame?.setLocationRelativeTo(null)
                home.frame?.isVisible = true

            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Login Details", "Login Error",
                        JOptionPane.ERROR_MESSAGE)
                setText()
                getUsername()!!.text = null
                getUsername()!!.grabFocus()
            }

        }
        btnLogin.setBounds(199, 374, 168, 34)
        frame!!.contentPane.add(btnLogin)


        val btnExit = JButton("Exit")

        btnExit.foreground = Color.WHITE
        btnExit.background = Color(25, 25, 112)
        btnExit.setBounds(281, 430, 131, 28)
        btnExit.addActionListener {
            frame = JFrame("Exit")
            if ((JOptionPane.showConfirmDialog(frame, "Confirm Exit", "Login Systems",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
                getUsername()!!.text = null
                password!!.text = null
                System.exit(0)
            } else {
                getUsername()!!.grabFocus()
            }

        }
        frame!!.contentPane.add(btnExit)

        val btnReset = JButton("Reset")
        btnReset.foreground = Color.WHITE
        btnReset.background = Color(25, 25, 112)
        btnReset.setBounds(140, 430, 131, 28)
        btnReset.addActionListener {
            getUsername()!!.text = null
            password!!.text = null
            getUsername()!!.grabFocus()
        }
        frame!!.contentPane.add(btnReset)
    }

    private fun getUsername(): JTextField? {
        return usernameField
    }

    private fun setUsername(username: JTextField) {
        this.usernameField = username
    }

}

private fun setText() {

}


