
public abstract class ProductCategory {
	int categoryId;
	protected String name;
	public abstract double getPoint();
	public int getCategoryId() {
		return categoryId;
	}
	public String getName() {
		return name;
	}
	

}
