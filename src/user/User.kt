package user

import security.LoginUserUI

open class User {


    private fun login() {
        val login = LoginUserUI()
        login.frame!!.setLocationRelativeTo(null)
        login.frame!!.isVisible = true
    }

    enum class Position {
        Supervisor,
        Subordinate


    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val user = User()
            user.login()

        }
    }
}


