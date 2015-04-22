import java.util.List;


public class MonthlyBill {
	private int year;
	private int month;
	private List<Order> monthlyOrders;
	private String entityName;
	public MonthlyBill(int year, int month, List<Order> monthlyOrder,
			String entityName) {		
		this.year = year;
		this.month = month;
		this.monthlyOrders = monthlyOrder;
		this.entityName = entityName;
	}
	public List<Order> getMonthlyOrders() {
		return monthlyOrders;
	}
	
	public void printMonthlyBill()
	{
		System.out.println("Year:"+this.year+"\nMonth:"+this.month);
		for(Order o:monthlyOrders)
		{
			o.printOrder();
		}
	}
	
	

	
}
