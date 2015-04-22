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
	
	public void addProduct(OrderProduct op){
		items.add(op);
	}
	
	public List<OrderProduct> getItems(){
		return items;
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
	
	public void printOrder()
	{
		System.out.println("Order Type: "+this.orderType
				+" Status: "+this.status
				+" Total: "+this.orderTotal
				+" Discount: "+this.discount);
		System.out.println("Items");
		for(OrderProduct op:items)
		{
			System.out.println(op.printOrderProduct());
		}
	}
	
	//update orderTotal and shipped status
	public void finalize(){
		boolean allProductsShipped = true;
		for(OrderProduct item: items){
			orderTotal+= item.getTotalProductPrice();
			allProductsShipped = allProductsShipped && item.isShipped();
		}
		this.status = allProductsShipped ? SHIPPED : PENDING;
	}
	
	

	
}
