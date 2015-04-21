
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
	
	public void setProductNumber(int productNumber)
	{
		this.productNumber=productNumber;
	}
	
	public int getProductNumber()
	{
		return this.productNumber;
	}
	
	public void setProductDesc(String productDesc)
	{
		this.productDesc=productDesc;
	}
	
	public String getProductDesc()
	{
		return this.productDesc;
	}
	
	public void setPrice(double price)
	{
		this.price=price;	
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public void printProduct()
	{
		System.out.println("Product Number :"+ this.productNumber+
				"\nProduct Description :"
				+this.productDesc+"\nPrice :$"+this.price);
	}
	
	
}
