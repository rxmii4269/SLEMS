package Data;

public enum OrderStatus {
	Closed("Closed"),
	Delivered("Delivered"),
	New("New"),
	OnHold("onHold");
	private String name;

	OrderStatus(String name) {
		this.name = name;

	}

	public static OrderStatus findByName(String name) {
		for (OrderStatus o : OrderStatus.values()) {
			if (name.equalsIgnoreCase(o.getName())) {
				return o;
			}
		}
		return OrderStatus.valueOf(OrderStatus.class, name);
	}

	public String getName() {
		return name;
	}

}
