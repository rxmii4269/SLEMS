package data

import java.util.*

class ExternalEggSupplier {
    var externalEggSupplier = ArrayList<String>()


    override fun toString(): String {
        val builder = StringBuilder()
        for (value in externalEggSupplier) {
            builder.append(value).append(" ")
        }

        return "External Egg Suppliers:\n $builder"
    }
}

