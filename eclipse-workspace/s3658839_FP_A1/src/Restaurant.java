import java.util.*;
public class Restaurant {
	
	private String category;
	private double deliveryFee;
	private String name;
	private ArrayList<Food>arrFoods;
	
	public Restaurant(String name, String category, double deliveryFee)	{
		
		this.name = name;    
		this.category = category;
		this.deliveryFee = deliveryFee;
		this.arrFoods = new ArrayList<Food>();
	}
	public String getName() {
		return this.name;   
		
	}
	
	public void setArrayFood(ArrayList<Food> arrFood) {
		this.arrFoods = arrFood;
		
	}
	
	public String getCategory() {
		
		return this.category;
	}
	
	

	
}
