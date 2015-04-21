import java.util.ArrayList;
import java.util.List;


public class Order {
	private final String SHIPPED = "Shipped";
	private final String PENDING = "Pending";
	private List<OrderProduct> items;
	private OrderType orderType;
	private String status;
	private double orderTotal;
	private double discount;
	public Order(OrderType orderType) {
		this.orderType = orderType;
		items = new ArrayList<OrderProduct>();
	}
	
	public void addProduct(Product p, int quantity, Customer customer){
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

	
}
