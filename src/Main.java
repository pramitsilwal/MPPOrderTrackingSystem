import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {

	private static Stock catalogue;
	private static List<Customer> customerList;
	private static Customer currentCustomer;
	private static Scanner input = new Scanner (System.in);
	private static void createStock(){
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

		catalogue = new Stock();
		catalogue.addProduct(o1, 3);
		catalogue.addProduct(o2, 4);
		catalogue.addProduct(o3, 10);
		catalogue.addProduct(h1, 500);
		catalogue.addProduct(h2,10);
		catalogue.addProduct(h3, 5);
		catalogue.addProduct(c1, 10);
		catalogue.addProduct(c2, 15);
		catalogue.addProduct(c3, 17);
		catalogue.addProduct(a1, 25);
		catalogue.addProduct(a2, 5);
		catalogue.addProduct(a3, 2);
		//viewStock();	
	}
	private static void viewStock(){
		catalogue.viewStock();
	}

	private static void selectCustomer(){
		Customer validCustomer = null;
		while(validCustomer == null){
			System.out.println("Select Customer by ID");
			for (Customer c: customerList){
				c.printBrief();
			}

			Integer selection = input.nextInt();
			for (Customer c: customerList ){
				if (c.getCustomerId() == selection){
					validCustomer = c;
				}
			}
		}
		currentCustomer = validCustomer;
	}

	private static void viewCustomer(){
		if(currentCustomer != null){
			currentCustomer.printCustomer();
		}
		else{
			System.out.println("No Customer Selected");
		}
	}

	private static void makeOrder(){
		catalogue.viewBrief();
		System.out.println("Enter -1 to quit selection");
		Integer inputSelection = Integer.MAX_VALUE;
		HashMap<Product, Integer> selectedProduct=new HashMap<Product, Integer>();
		while(inputSelection!=-1){
			System.out.println("Select Product:");		
			inputSelection=input.nextInt();
			if(inputSelection==-1)
			{
				break;
			}
			System.out.println("Select Quantity:");
			Integer qtySelection =input.nextInt();

			if(qtySelection < 1){
				System.out.println("Invalid selection");
			}
			else{
				boolean productFound = false;
				for (Product p: catalogue.getStock().keySet()){
					if (p.getProductNumber() == inputSelection){
						selectedProduct.put(p, qtySelection);
						productFound = true;
						break;
					}
				}
				if (!productFound) System.out.println("Product not valid");
			}
		};

		OrderType ot = OrderType.PREPAID;
		if(currentCustomer instanceof CorporateCustomer){
			System.out.println("Select Order Type");
			input = new Scanner(System.in);
			String orderType = input.nextLine();
			ot = orderType.equalsIgnoreCase("Credit") ? OrderType.CREDIT : OrderType.PREPAID;
		}

		Order currentOrder = currentCustomer.makeOrder(selectedProduct, ot);
		currentOrder.printOrder();
	}

	private static void viewInvoice(){
		if(currentCustomer instanceof CorporateCustomer){
			int inputValue;
			System.out.println("Enter Month:");
			inputValue=input.nextInt();			
			
			CorporateCustomer cc = (CorporateCustomer) currentCustomer;
			if(cc.getInvoice().containsKey(inputValue)){
				MonthlyBill mb = (MonthlyBill)cc.getInvoice().get(inputValue);
				mb.printMonthlyBill();
			}
			
		}
		else {System.out.println("Cannot view Invoice for personal customer.");}
	}

	private static void viewOrders(){
		for(Order o: currentCustomer.orderList)
		{
			o.printOrder();
		}
	}
	private static void viewMainMenu(){
		System.out.println("-----------------MENU------------------");
		System.out.println("Press Q to exit");
		System.out.println("VP: View Products");
		System.out.println("SC: Select Customer");
		System.out.println("VC: View Customer Info");
		System.out.println("MO: Make Order");
		System.out.println("VO: View Orders");
		System.out.println("VI: View Invoice");
	}
	public static void main(String args[])
	{
		//s.removeProduct(p1, 1);
		//s.viewStock();
		createStock();

		OrderProcessor orderProcessor=new OrderProcessor(catalogue);
		CorporateCustomer corpCust1=new CorporateCustomer(1,"Dreams & ideas", "Mr John Smith", "xyz@dreamsandideas.com", "6149852365", "1000 N 4th Street, Fairfield, IA, 52557",
				"1000 N 4th Street", orderProcessor, CreditRating.POOR, 2000);
		CorporateCustomer corpCust2=new CorporateCustomer(2,"Facebook Inc", "Mr Marc Zuckerberg", "zuckie@facebook.net", "7169852365", "333 N Dream Street, Fairfield, IA, 52557",
				"333 N Dream Street", orderProcessor, CreditRating.GOOD, 2000);	

		PersonalCustomer personalCust1 = new PersonalCustomer(3, "Pramit", "Silwal", "silwal123@gmail.com", "784-234-1232", "50 Neridah St, Chatswood, CA 90768", "50 Neridah St, Chatswood, CA 90768", orderProcessor);
		PersonalCustomer personalCust2 = new PersonalCustomer(4, "Lionel", "Messi", "messi@gmail.com", "914-234-1232", "123 Main St, Redwood, CA 91768", "123 Main St, Redwood, CA 91768", orderProcessor);
		customerList = new ArrayList<Customer>();
		customerList.add(corpCust1);
		customerList.add(corpCust2);
		customerList.add(personalCust1);
		customerList.add(personalCust2);


		String inputString;
		Scanner input = new Scanner(System.in);
		do{
			viewMainMenu();
			System.out.println("Select option:");
			inputString = input.nextLine();
			switch (inputString){
			case "Q":
			case "q": System.exit(1);
			case "VP" :
				viewStock();
				break;
			case "SC":
				selectCustomer();
				break;
			case "VC":
				viewCustomer();
				break;
			case "MO":
				makeOrder();
				break;
			case "VO":
				viewOrders();
				break;
			case "VI":
				viewInvoice();
				break;
			default:
				break;
			}
		}while(!inputString.equalsIgnoreCase("Q"));







	}
}
