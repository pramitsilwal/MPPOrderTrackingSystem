import java.util.ArrayList;
import java.util.List;


public class Other extends ProductCategory {
	private double point=0.25;
	List<Product> product=new ArrayList<Product>();
	public Other(int id)
	{
		categoryId=id;
	}
	
	@Override
	public double getPoint() {
		// TODO Auto-generated method stub
		return this.point;
	}
	
	public void addProduct(Product p)
	{
		product.add(p);
	}
	public void printProductList()
	{
		for(Product p:product)
		{
			p.printProduct();
		}
	}
}
