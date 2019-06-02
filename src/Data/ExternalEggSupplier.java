package Data;

import java.util.ArrayList;

public class ExternalEggSupplier {
	public ArrayList<String> externalEggSupplier = new ArrayList<>();

	public ExternalEggSupplier() {

	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (String value : externalEggSupplier) {
			builder.append(value).append(" ");
		}

		return "External Egg Suppliers:\n " + builder.toString();
	}
}

