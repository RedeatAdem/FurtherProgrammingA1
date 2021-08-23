import java.util.*;
public class Order {
	
	private double total;
	private double deliveryFee;
	private ArrayList<Food>items;
	
	public Order() {
		this.items = new ArrayList<Food>();
	}
	
	public void addItem(Food food, int quantity) {
		
		this.items.add(food);
		
	}
	
	public void getItems(Order items) {
		this.getItems(items);
	}
	public void printReceipt() {
		String receipt = "You have ordered the following items\n"
				+ "--------------------------------------------------\n"
				+ "Moeders R.\n"
				+ "2 Fish of the Day $44.00\n"
				+ "2 Mommy's Apple Pie $16.00\n"
				+ "Delivery fee $10.00\n"
				+ "--------------------------------------------------\n"
				+ "Chicken King\n"
				+ "1 Chicken Wings $4.50\n"
				+ "2 Orange Juice $6.00\n"
				+ "Delivery fee $5.00\n"
				+ "--------------------------------------------------\n"
				+ "Order price: $56.40\n"
				+ "Delivery fee: $7.50\n"
				+ "You have saved: $21.60\n"
				+ "Total amount to pay: $63.90\n"
				+ "------------------------------------------";
		System.out.println(receipt);
	}
	
}
