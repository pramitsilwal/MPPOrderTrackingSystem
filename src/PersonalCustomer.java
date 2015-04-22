import java.util.HashMap;


public class PersonalCustomer extends Customer {
	private String firstName;
	private String lastName;
	
	public PersonalCustomer(int customerId, String firstName, String lastName, String email, String contactNumber, String shippingAddress, String billingAddress, OrderProcessor orderProcessor) {
		this.customerId=customerId;
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


	@Override
	public void printCustomer() {
		// TODO Auto-generated method stub
		System.out.println("Customer Id:"+this.customerId
				+"\nFirstname:"+this.firstName
				+"\nLastname:"+this.lastName
				+"\nEmail:"+this.email
				+"\nContact:"+this.contactNumber
				+"\nShipping Address:"+this.shippingAddress
				+"\nBilling Address:"+this.billingAddress
				+"\nOrder Processor:"+this.orderProcessor
				+"\nCredit Rating:"+this.creditRating);
	}

}
