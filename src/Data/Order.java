package Data;

public class Order {
	private long product;

	public Order(long product) {
		this.product = product;
	}

	Order() {

	}

	private long calcCost() {
		return (long) (getPCost() * getProduct());
	}

	private long calcGCT() {
		return (long) (calcCost() * getGCT());
	}

	private double getGCT() {
		return 0.165;
	}

	public long total() {
		return (calcCost() + calcGCT());
	}


	private long getProduct() {
		return product;
	}

	private float getPCost() {
		return 600;
	}

	public String toString() {
		return "Orders amount: " + "$" + this.total() + OrderStatus.findByName("Active");
	}

}
