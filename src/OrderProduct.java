import java.util.Date;


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
	
	public OrderProduct(Product product, boolean shipped, Date date, int quantity, double productPrice) {
		this.product = product;
		this.shipped = shipped;
		this.shippingDate = date;
		this.quantity = quantity;
		this.totalProductPrice = productPrice;
	}	
	public String printOrderProduct()
	{
		return ("Product :"+product.getProductDesc()
				+"\nShipped:"+this.shipped
				+"\nShipping Date:"+this.shippingDate
				+"\nQuantity:"+this.quantity
				+"\nTotal Product Price:"+this.totalProductPrice);
	}
}
