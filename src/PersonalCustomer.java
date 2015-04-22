import java.util.HashMap;


public class PersonalCustomer extends Customer {
	private String firstName;
	private String lastName;
	
	public PersonalCustomer(String firstName, String lastName, String email, String contactNumber, String shippingAddress, String billingAddress, OrderProcessor orderProcessor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.orderProcessor = orderProcessor;
		this.creditRating = CreditRating.POOR;
	}
	

	@Override
	public void makeOrder(HashMap<Product, Integer> products, OrderType type) {
		orderProcessor.placeOrder(products, this, type);
	}


	@Override
	protected String getName() {
		return firstName + " " + lastName;
	}

}
