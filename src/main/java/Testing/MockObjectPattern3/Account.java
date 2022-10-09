package Testing.MockObjectPattern3;

import java.util.List;

public class Account {

	private final String name;
	private List<CheckoutMethod> checkoutMethods;

	public Account(String name) {
		this.name = name;
	}

	public boolean checkoutFor(Item item) {
		for (CheckoutMethod method : checkoutMethods) {
			if (method.pay(item)) {
				return true;
			}
		}
		return false;
	}

	public List<CheckoutMethod> getCheckoutMethods() {
		return checkoutMethods;
	}

	public void setCheckoutMethods(List<CheckoutMethod> checkoutMethods) {
		this.checkoutMethods = checkoutMethods;
	}

}
