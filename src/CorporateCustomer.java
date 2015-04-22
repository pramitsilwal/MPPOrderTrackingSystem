import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CorporateCustomer extends Customer {

	private String contactName;
	private String entityName;
	private double creditLimit;
	private HashMap<Integer, MonthlyBill> invoiceHistory;
	public void addMonthlyBill(int month, Order order){
		if(invoiceHistory.containsKey(month)){
			List orderList = invoiceHistory.get(month).getMonthlyOrders();
			orderList.add(order);
		}
		else{
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(order);
			invoiceHistory.put(month, new MonthlyBill(2015,month, orderList,this.entityName));
		}
	}
	
	public HashMap getInvoice()
	{
		return this.invoiceHistory;
	}
	
	public CorporateCustomer(int customerId,String entityName, String contactName, String email, String contactNumber, String shippingAddress, String billingAddress, OrderProcessor orderProcessor, CreditRating rating, double creditLimit){
		this.customerId=customerId;
		this.entityName = entityName;
		this.contactName = contactName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.shippingAddress = shippingAddress;
		this.billingAddress  = billingAddress;
		invoiceHistory = new HashMap<Integer,MonthlyBill>();
		this.orderProcessor = orderProcessor;
		this.creditRating = rating;
		this.creditLimit = creditLimit;
	}
	
	@Override
	public Order makeOrder(HashMap<Product, Integer> products, OrderType type) {		
		return orderProcessor.placeOrder(products, this, type);			
		}
	@Override
	protected String getName() {
		return entityName;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	@Override
	public void printCustomer() {
		System.out.println("Customer Id:"+this.customerId
				+"\nCorporate Name:"+this.entityName
				+"\nEmail:"+this.email
				+"\nContact:"+this.contactNumber
				+"\nShipping Address:"+this.shippingAddress
				+"\nBilling Address:"+this.billingAddress
				//+"\nOrder Processor:"+this.orderProcessor
				+"\nCredit Rating:"+this.creditRating
				+"\nCredit Limit:"+this.creditLimit
				+"\nPoints:"+this.points)
				;
		
	}
	@Override
	public void printBrief() {
		System.out.println("ID: " + this.customerId + "Customer Name: "+ this.entityName + " Type: CORPORATE");
		
	}
	
	@Override
	public  void printOrderList()
	{
		for(Order o:orderList)
		{
			o.printOrder();
		}
	}
	
	

	}


