
public class Food {
	
	private String foodName;
	private double price;
	
	public Food(String food, double price) {
		this.foodName = food;
		
		this.price = price;
		
		
	}
	
	public double getPrice() {
		return this.price;
		
	}
	
	
	public String getName() {
		return this.foodName;   
		
	}
}
