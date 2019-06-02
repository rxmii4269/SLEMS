package Data;

public class ExternalEggSupply extends Egg {
	private int numEggsSupplied = 0;

	public ExternalEggSupply(String numEggsSupplied) {
		this.numEggsSupplied = Integer.parseInt(numEggsSupplied);
	}

	ExternalEggSupply() {
		super();
	}

	private int getNumEggsSupplied() {
		return numEggsSupplied;
	}

	public String toString() {
		return "External Egg Supply \n" + getNumEggsSupplied();
	}

}
