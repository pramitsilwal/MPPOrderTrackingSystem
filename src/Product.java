
public class Product {
	private int productNumber;
	private String productDesc;
	private double price;
	//private ProductCategory category;
	
	public Product(int productNumber, String productDesc, double price)
	{
		this.productNumber=productNumber;
		this.productDesc=productDesc;
		this.price=price;		
	}
	
	
	
	public void printProduct()
	{
		System.out.println("Product Number :"+ this.productNumber+
				"\nProduct Description :"
				+this.productDesc+"\nPrice :$"+this.price);
	}
	
	
}
