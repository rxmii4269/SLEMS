package user

import java.io.Serializable

class Supervisor private constructor(firstName: String?, lastName: String?, employeeID: String?, emailAddress: String?, phoneNumber: Int, position: Position?) : User(), Serializable {

    init {
        Supervisor.firstName = firstName
        Supervisor.lastName = lastName
        Supervisor.employeeID = employeeID
        Supervisor.position = position
        Supervisor.emailAddress = emailAddress
        Supervisor.phoneNumber = phoneNumber


        if (soleInstance != null) {
            throw RuntimeException("Use the getInstance() method to get the single instance of this class.")
        }
    }

    companion object {
        private var firstName: String? = null
        private var lastName: String? = null
        private var employeeID: String? = null
        private var position: Position? = null
        private var emailAddress: String? = null
        private var phoneNumber: Int = 0


        @Volatile
        private var soleInstance: Supervisor? = null

        val instance: Supervisor?
            get() {
                if (soleInstance == null) {
                    synchronized(Supervisor::class.java) {
                        if (soleInstance == null)
                            soleInstance = Supervisor(firstName, lastName, employeeID, emailAddress, phoneNumber, position)
                    }
                }
                return soleInstance
            }
    }


}
