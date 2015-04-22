import java.util.HashMap;


public class Stock {
	HashMap<Product, Integer> stock=new HashMap<Product,Integer>();
	
	public void addProduct(Product p, Integer qty)
	{
		stock.put(p, qty);
	}
	
	public boolean removeProduct(Product p, Integer removeQty )
	{
		//stock.remove(p);
		//System.out.println("Deducting Product Qty");
		if(stock.containsKey(p))
		{
			Integer currentStock = stock.get(p);
			if(removeQty > currentStock){
				return false;
			}
			else{
				stock.put(p, stock.get(p)-removeQty);			
				return true;
			}
		}
		return false;
	}
	
	public boolean isProductListed(Product p){
		return stock.containsKey(p);
	}
	
	public HashMap <Product, Integer> getStock(){
		return this.stock;
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
	
	public void viewBrief(){
		for (Product p:stock.keySet())
		{
			
			System.out.println(p.getProductBrief()+" Quantity "+stock.get(p));
			//System.out.println();
			
		}
	}
}

