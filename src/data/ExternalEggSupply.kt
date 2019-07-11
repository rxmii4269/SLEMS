package data

class ExternalEggSupply(numEggsSupplied: String) : Egg() {
    private var numEggsSupplied = 0

    init {
        this.numEggsSupplied = Integer.parseInt(numEggsSupplied)
    }

    override fun toString(): String {
        return "External Egg Supply \n$numEggsSupplied"
    }

}
