package database

import java.sql.DriverManager
import java.sql.SQLException

class DBConnect {
    private val host = "jdbc:mariadb://localhost:3306/SLEMS"
    private val username = "root"
    private val password = "romyroms"
    private val pHost = "jdbc:postgresql://localhost:5432/slems"
    private val pPassword = "romyroms"
    private val userName = "postgres"


    fun writeToDBCust(customerName: String, phoneNumber: Int, deliveryAddress: String, email: String,
                      quantity: Int, cost: Int) {

        try {
            val con = DriverManager.getConnection(host, username, password)
            val pst = con.prepareStatement("INSERT INTO CustomerData VALUES (?,?,?,?," + "?,?,?)")
            pst.setString(1, null)
            pst.setString(2, customerName)
            pst.setString(3, phoneNumber.toString())
            pst.setString(4, deliveryAddress)
            pst.setString(5, email)
            pst.setString(6, quantity.toString())
            pst.setString(7, cost.toString())
            val conn = DriverManager.getConnection(pHost, userName, pPassword)
            val pstt = conn.prepareStatement("INSERT INTO customerdata VALUES (?,?,?,?," + "?,?,?)")

            pst.executeUpdate()
            pstt.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        }

    }

    fun writeToDBUser(employeeID: String, firstName: String, lastName: String, emailAddress: String,
                      phoneNumber: String, Position: String) {
        try {
            val con = DriverManager.getConnection(host, username, password)
            val pst = con.prepareStatement("insert into Users values (?,?,?,?,?,?)")
            val conn = DriverManager.getConnection(pHost, userName, pPassword)
            val pstt = conn.prepareStatement("INSERT INTO users values (?,?,?,?,?,?)")
            pst.setString(1, employeeID)
            pst.setString(2, firstName)
            pst.setString(3, lastName)
            pst.setString(4, emailAddress)
            pst.setString(5, phoneNumber)
            pst.setString(6, Position)

            pst.executeUpdate()
            pstt.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        }

    }

    fun writeToDBDailyEggs(employeeID: String, collectedEggs: String, spoiledEggs: String, brokenEggs: String,
                           workStationSector: String, workStationNumber: String) {
        try {
            val conn = DriverManager.getConnection(host, username, password)
            val pst = conn.prepareStatement("insert into DailyCollectedEggs values(?,?,?,?,?,?)")
            val con = DriverManager.getConnection(pHost, userName, pPassword)
            val pstt = con.prepareStatement("insert into DailyCollectedEggs values(?,?,?,?,?,?)")
            pst.setString(1, employeeID)
            pst.setString(2, collectedEggs)
            pst.setString(3, spoiledEggs)
            pst.setString(4, brokenEggs)
            pst.setString(5, workStationSector)
            pst.setString(6, workStationNumber)

            pst.executeUpdate()
            pstt.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        }


    }

    fun writeToDBEggSupplier(companyName: String, emailAddress: String, phoneNumber: String, farmAddress: String,
                             amountOfEggs: String) {
        try {
            val conn = DriverManager.getConnection(host, username, password)
            val con = DriverManager.getConnection(pHost, userName, pPassword)
            val pstt = con.prepareStatement("insert into EggSupplier values (?,?,?,?,?,?)")
            val pst = conn.prepareStatement("insert into EggSupplier values (?,?,?,?,?,?)")
            pst.setString(1, null)
            pst.setString(2, companyName)
            pst.setString(3, emailAddress)
            pst.setString(4, phoneNumber)
            pst.setString(5, farmAddress)
            pst.setString(6, amountOfEggs)

            pst.executeUpdate()
            pstt.executeUpdate()
        } catch (e: SQLException) {
            println(e.message)
        }

    }
}