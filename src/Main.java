
public class Main {
public static void main(String args[])
{
	//Health health=new Health(2,"Health");
	//Other other=new Other(5, "Other");
	//Computer computer=new Computer(1,"Computer");
	//AudioVideo audioVideo=new AudioVideo(4,"Audio Video");
	
	// product (product Id, Product Desc, Price , ProductCategory.COMPUTER)
	Product o1=new Product(2,"Pepsi",2.5, ProductCategory.OTHER);
	Product o2=new Product(3,"Dew",1, ProductCategory.OTHER);
	Product o3=new Product(4,"Dr.Pepper",3.5, ProductCategory.OTHER);
	//p.printProduct();

	//o.printProductList();
	
	Product h1=new Product(5,"Vitamin C capsule",12.5, ProductCategory.HEALTH);
	Product h2=new Product(6,"Parasitamole",5.75, ProductCategory.HEALTH);
	Product h3=new Product(7,"Medi1",3.5, ProductCategory.HEALTH);
	
	Product c1=new Product(8,"Dell",100.99, ProductCategory.COMPUTER);
	Product c2=new Product(9,"HP",500.75, ProductCategory.COMPUTER);
	Product c3=new Product(10,"Asus",300.5, ProductCategory.COMPUTER);
	
	Product a1=new Product(11,"ACDC",25.5, ProductCategory.AUDIOVIDEO);
	Product a2=new Product(12,"GNR",35.75,ProductCategory.AUDIOVIDEO);
	Product a3=new Product(13,"Nirvana",30.5, ProductCategory.AUDIOVIDEO);
	
	
	
	
	
	Stock stock=new Stock();
	stock.addProduct(o1, 3);
	stock.addProduct(o2, 4);
	stock.addProduct(o3, 10);
	stock.addProduct(h1, 500);
	stock.addProduct(h2,10);
	stock.addProduct(h3, 5);
	stock.addProduct(c1, 10);
	stock.addProduct(c2, 15);
	stock.addProduct(c3, 17);
	stock.addProduct(a1, 25);
	stock.addProduct(a2, 5);
	stock.addProduct(a3, 2);
	
	stock.viewStock();
	//s.removeProduct(p1, 1);
	//s.viewStock();
	OrderProcessor orderProcessor=new OrderProcessor(stock);
	
	Customer c=new CorporateCustomer(1,"Dreams & ideas", "Mr John Smith", "xyz@dreamsandideas.com", "6149852365", "1000 N 4th Street",
			"1000 N 4th Street", orderProcessor, CreditRating.GOOD, 50);
	
	
	

	}
}
