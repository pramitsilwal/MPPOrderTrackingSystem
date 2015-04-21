import java.sql.Date;


public class OrderProduct {
	private Product product;
	private boolean shipped;
	private Date shippingDate;
	private int quantity;
	private double totalProductPrice;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public boolean isShipped() {
		return shipped;
	}
	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalProductPrice() {
		return totalProductPrice;
	}
	public void setTotalProductPrice(double totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}
	
	public OrderProduct(Product product, boolean shipped, Date shippingDate, int quantity, double productPrice) {
		super();
		this.product = product;
		this.shipped = shipped;
		this.shippingDate = shippingDate;
		this.quantity = quantity;
		this.totalProductPrice = productPrice;
	}	
	
}