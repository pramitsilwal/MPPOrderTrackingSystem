
public class Main {
public static void main(String args[])
{
	Health h=new Health(2);
	Other o=new Other(5);
	Computer c=new Computer(1);
	AudioVideo v=new AudioVideo(4);
	h.getPoint();
	
	Product p1=new Product(2,"Pepsi",2.5);
	Product p2=new Product(3,"Dew",1);
	Product p3=new Product(4,"Dr.Pepper",3.5);
	//p.printProduct();
	o.addProduct(p3);
	o.addProduct(p2);
	o.addProduct(p1);
	
	//o.printProductList();
	
	Product h1=new Product(2,"Vitamin C capsule",12.5);
	Product h2=new Product(3,"Parasitamole",5.75);
	Product h3=new Product(4,"Medi1",3.5);
	
	h.addProduct(h1);
	h.addProduct(h2);
	h.addProduct(h3);
	
	Stock s=new Stock();
	s.addStock(p1, 3);
	s.addStock(p2, 4);
	s.addStock(h1, 500);
	s.addStock(h2,10);
	s.addStock(h3, 5);
	s.viewStock();
	s.removeStock(p1, 1);
	s.viewStock();
	

	}
}
