import java.util.HashMap;


public class Stock {
	HashMap<Product, Integer> stock=new HashMap<Product,Integer>();
	
	public void addStock(Product p, Integer qty)
	{
		stock.put(p, qty);
	}
	
	public boolean removeStock(Product p, Integer removeQty )
	{
		//stock.remove(p);
		System.out.println("Deducting Product Qty");
		if(stock.containsKey(p))
		{
			stock.put(p, stock.get(p)-removeQty);
			return true;
		}
		return false;
	}
	
	public void viewStock()
	{
		System.out.println("==================Stock=========================");
		//
		for (Product p:stock.keySet())
		{
			p.printProduct();
			System.out.println("Quantity "+stock.get(p));
			System.out.println();
			
		}
		//p.printProduct();
		//System.out.println(stock.keySet());
		System.out.println("===================End==========================");
	}
	
}

