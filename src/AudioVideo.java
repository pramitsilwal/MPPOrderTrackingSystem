import java.util.ArrayList;
import java.util.List;


public class AudioVideo extends ProductCategory {
	private final double point=0.50;
	public AudioVideo(int id, String name)
	{
		categoryId=id;
		this.name = name;
	}
	
	
	@Override
	public double getPoint() {
		// TODO Auto-generated method stub
		return this.point;
	}
	
	
}
