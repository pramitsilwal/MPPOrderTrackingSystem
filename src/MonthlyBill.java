import java.util.List;


public class MonthlyBill {
	private int year;
	private int month;
	private List<Order> monthlyOrder;
	private String entityName;
	public MonthlyBill(int year, int month, List<Order> monthlyOrder,
			String entityName) {
		super();
		this.year = year;
		this.month = month;
		this.monthlyOrder = monthlyOrder;
		this.entityName = entityName;
	}

	
}
