import java.util.List;


public class MonthlyBill {
	private int year;
	private int month;
	private List<Order> monthlyOrders;
	private String entityName;
	public MonthlyBill(int year, int month, List<Order> monthlyOrder,
			String entityName) {
		super();
		this.year = year;
		this.month = month;
		this.monthlyOrders = monthlyOrder;
		this.entityName = entityName;
	}
	public List<Order> getMonthlyOrders() {
		return monthlyOrders;
	}
	
	

	
}
