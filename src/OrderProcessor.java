import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class OrderProcessor {

	private Stock companyStock;
	public OrderProcessor(Stock stock){
		companyStock = stock;
	}
	public Order placeOrder(HashMap<Product, Integer> products, Customer customer, OrderType type ) {
		if(customer instanceof PersonalCustomer){
			return placeOrderByType(products, customer, true);
		}
		else if (customer instanceof CorporateCustomer){
			switch(customer.getCreditRating()){
			case POOR :
				return placeOrderByType(products, customer, true);
				//break;
			case GOOD:
				if(type == OrderType.PREPAID){
					return placeOrderByType(products, customer, true);
				}
				else {
				    return	placeCreditOrder(products, customer);
				}
				//break;
			case EXCELLENT :
				if(type == OrderType.PREPAID){
					return placeOrderByType(products, customer, true);
				}
				else {
					return placeCreditOrder(products, customer);
				}
				
				//break;
			
			
			}
			
		}
		return null;
	}
	
	private Order placeCreditOrder(HashMap<Product, Integer> products, Customer customer){
		//Credit order can be placed only by corporate customer, check if customer is eligible based on credit limit
		double totalOrderPrice = 0.0;
		for (Product p : products.keySet()){
			totalOrderPrice += (p.getPrice() * products.get(p));
		}
		if (((CorporateCustomer) customer).getCreditLimit() < totalOrderPrice){
			
			return placeOrderByType(products, customer, true);
		}
		else{
			return placeOrderByType(products, customer, false);
		}
	}
	
	private Order placeOrderByType(HashMap<Product, Integer> products, Customer customer, boolean prepaid){
		Order customerOrder;
		if(prepaid){
			customerOrder = new Order(OrderType.PREPAID);
		}
		else{
			customerOrder = new Order(OrderType.CREDIT);
		}
		double customerPoints = customer.getPoints();
		for (Product product: products.keySet()){
			if(companyStock.isProductListed(product)){
				int quantity = products.get(product);
				boolean willProductShip = companyStock.removeProduct(product,quantity );	
				Date shippingDate = willProductShip ? Calendar.getInstance().getTime() : null;
				OrderProduct op = new OrderProduct(product, willProductShip, shippingDate, quantity, (product.getPrice() * (double) quantity));
				customer.addPoint(product.getPoint());
				customerOrder.addProduct(op);
			}
			
		}
		if (customerPoints >=25){
			customerOrder.setDiscount(0.40);
			customer.setPoints(0);
		}
		customerOrder.finalize();
		shipOrder(customerOrder,customer);
		customer.addOrder(customerOrder);
		if(!prepaid){
			if (customer instanceof CorporateCustomer){
				((CorporateCustomer) customer).addMonthlyBill(Calendar.getInstance().getTime().getMonth(), customerOrder);
			}
		}
		return customerOrder;
	}
	
	private void shipOrder(Order order, Customer customer){
		for(OrderProduct op : order.getItems()){
			if(op.isShipped()){
				System.out.println("Shipping Product "+ op.getProduct().getProductDesc() + " to " + customer.getEntityName());
			}
		}
	}

}
