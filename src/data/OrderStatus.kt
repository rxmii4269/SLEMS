package data

enum class OrderStatus(val Name: String) {
    Closed("Closed"),
    Delivered("Delivered"),
    New("New"),
    OnHold("onHold");


    companion object {

        fun findByName(Name: String): OrderStatus {
            for (o in values()) {
                if (Name.equals(o.Name, ignoreCase = true)) {
                    return o
                }
            }
            return valueOf(Name)
        }

    }
}

