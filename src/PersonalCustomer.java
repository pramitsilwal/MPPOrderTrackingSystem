
public class PersonalCustomer extends Customer {
	private String firstName;
	private String lastName;
	
	public PersonalCustomer(String firstName, String lastName, String email, String contactNumber, String shippingAddress, String billingAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}
	

	@Override
	public void makeOrder() {

	}

}
