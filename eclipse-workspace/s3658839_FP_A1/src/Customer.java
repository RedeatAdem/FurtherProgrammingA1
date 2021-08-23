
public class Customer {
	
	private String name;
	private String number;
	
	private Order order;
	
	public Customer() {
		
	}
	
	public Customer(String name, String number) {
		
		this.name = name;
		
		this.number = number;
		
		this.order = new Order();
	}
	
	public String getCustomerName() {
		return this.name;
	}
	
	public String getNumber() {
		return this.number;
	}
	public Order getOrder() {
		return this.order;
	}
}
