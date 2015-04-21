import java.util.ArrayList;
import java.util.List;


public class ProductCatalog {
	List<Product> customerFacingCatalog;
	public ProductCatalog(){
		customerFacingCatalog = new ArrayList<Product>();
		//add live products here. hardcode for demo!
	}
	public List<Product> getCustomerFacingCatalog() {
		return customerFacingCatalog;
	}
	public void setCustomerFacingCatalog(List<Product> customerFacingCatalog) {
		this.customerFacingCatalog = customerFacingCatalog;
	}
	
	public void addProduct(Product p){
		customerFacingCatalog.add(p);
	}
}
