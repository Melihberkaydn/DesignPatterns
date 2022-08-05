package FacadePattern.ecommerce;

public class Shipping {

	private final String address;

	public Shipping(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

}
