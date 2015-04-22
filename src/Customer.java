import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public abstract class Customer {

	protected static int CURRENT_ID = 1;
	protected int customerId;
	protected String email;
	protected String contactNumber;
	protected String shippingAddress;
	protected String billingAddress;
	protected double points;
	protected List<Order> orderList = new ArrayList<Order>();
	protected CreditRating creditRating;
	protected OrderProcessor orderProcessor;
	
	
	public CreditRating getCreditRating() {
		return creditRating;
	}
	public String getEntityName(){
		return getName();
	}
	protected abstract String getName();
	
	public void addOrder(Order o){
		orderList.add(o);
	}
	
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public void addPoint(double points){
		this.points += points;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public abstract void makeOrder(HashMap<Product, Integer> products, OrderType type);
}
