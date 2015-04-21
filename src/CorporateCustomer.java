import java.util.ArrayList;
import java.util.List;


public class CorporateCustomer extends Customer {

	private String contactName;
	private String entityName;
	private List<MonthlyBill> invoiceHistory;
	public void addMonthlyBill(MonthlyBill mb){
		invoiceHistory.add(mb);
	}
	public CorporateCustomer(String entityName, String contactName, String email, String contactNumber, String shippingAddress, String billingAddress){
		this.entityName = entityName;
		this.contactName = contactName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.shippingAddress = shippingAddress;
		this.billingAddress  = billingAddress;
		invoiceHistory = new ArrayList<MonthlyBill>();
	}
	
	@Override
	public void makeOrder() {
		

	}

}
