import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Health extends ProductCategory {

	private final double point=1;
	public Health(int id, String name)
	{
		categoryId=id;
		this.name = name;
	}
	
	
	@Override
	public double getPoint() {
		return this.point;
	}



	

}
