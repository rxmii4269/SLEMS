package data

class Order(private var product: Long) {

    private val gct: Double
        get() = 0.165

    private val pCost: Float
        get() = 600f

    private fun calcCost(): Long {
        return (pCost * product).toLong()
    }

    private fun calcGCT(): Long {
        return (calcCost() * gct).toLong()
    }

    fun total(): Long {
        return calcCost() + calcGCT()
    }

    override fun toString(): String {
        return "Orders amount: " + "$" + this.total() + OrderStatus.findByName("Active")
    }

}
