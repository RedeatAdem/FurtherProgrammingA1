import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
public class MelbourneEats {
	
	ArrayList<Restaurant>arrRestaurants;
	
	Customer customer;
	boolean exit;
	
	
	public  MelbourneEats() throws FileNotFoundException {
	
		this.arrRestaurants = new ArrayList<Restaurant>();
		
		this.exit = false;
//		this.readFileandUploadResToResArrayList();
		this.initializeRestaurants();
		
		for(Restaurant res: this.arrRestaurants) {
//			System.out.println(res.getName());
		}
		this.customer = new Customer("yonas","0444404");
	}
	public void run() throws FileNotFoundException {
		String banner = new String(new char[50]).replace('\u0000', '=');
		
		System.out.println("\n" + "Welcome to Melbourne Eats" + "\n");
		
		String menuType = "MainMenu";
		
		this.showMenu(menuType);
		
		do {
//			String menuSelection = readUserInput();
			System.out.print("Please select: ");
			String menuSelection = readUserInput();
			int menuSelectionNum;
			while(!isNumeric(menuSelection)) {
				System.out.println("Please enter a proper number:");
				menuSelection = readUserInput();
			}
			menuSelectionNum = Integer.parseInt(menuSelection);
			
			
			
			if(menuSelectionNum == 1)
			{
				menuType = "CategoryMenu";
			}
			if(menuSelectionNum == 2)
			{
				menuType = "RestaurantSearchMenu";
			}
			if(menuSelectionNum == 3) {
				menuType = "CheckoutMenu";
			}
			if(menuSelectionNum == 4)
			{
				menuType = "Exit"; 
			}
			switch(menuType) {
			case "MainMenu":
				this.showMenu(menuType);
				break;
			case "CategoryMenu":
				this.showMenu(menuType);
				
				break;
			case "RestaurantSearchMenu":
				this.showMenu(menuType);
				break;
			case "CheckoutMenu":
				this.showMenu(menuType);
				break;
			case "Exit":
				this.exit = true;
				System.out.println("goodbye");
			}
//			printMenu(this.restaurant.getName());
//			
//			String stringInput = readUserInput();
//			
//			// Check the user input and continue with the next iteration
//			// if no input is provided
//			if (stringInput.isEmpty()) {
//				continue;
//				
//			}
//		
//			
//			char input = stringInput.charAt(0);
//			
//			switch (input) {
//				case 'a':
//					this.restaurant.order();
//					
//					break;
//					
//				case 'b':
//					this.restaurant.checkout();
//					break;
//				
//				case 'c':
//					this.exit = true;
//					break;
//				default:
//					System.out.println("Please select a valid menu option.");
//							break;
//							
//			}
			
			while(menuType == "CategoryMenu")
			{
				System.out.print("Please select a category: ");
				menuSelection = readUserInput();
				
				while(!isNumeric(menuSelection)) {
					System.out.println("Please enter a proper number:");
					menuSelection = readUserInput();
				}
				menuSelectionNum = Integer.parseInt(menuSelection);

				if(menuSelectionNum == 1)
				{
					menuType = "Restaurant";
				}
				if(menuSelectionNum == 2)
				{
					menuType = "Cafe";
				}
				if(menuSelectionNum == 3) {
					menuType = "Fast food";
				}
				if(menuSelectionNum == 4)
				{
					menuType = "Exit"; 
				}
					System.out.println("this is what you are passing" + menuType);
				showFoodCategory(menuType);
			
//				switch(menuType) {
//				case "Restaurant":
//					this.showMenu(menuType);
//					break;
//				case "Cafe":
//					this.showMenu(menuType);
//					
//					break;
//				case "FastFood":
//					this.showMenu(menuType);
//					break;
//					
//				case "Exit":
//					this.exit = true;
//					System.out.println("goodbye");
//				}
			}
		} while (!this.exit);	
		
		
		
	
	}
	/**
     * The utility method to print menu options.
     */
	public void initializeRestaurants() throws FileNotFoundException {
		java.io.File file = new java.io.File("Restaurants.txt");
    
    	Scanner scan = new Scanner (file);
    	scan.useDelimiter("\n");
    	
    	while(scan.hasNextLine()) {
    		
    		String token = scan.next();
    		String[] resInfo = token.split(",",4);
    		String stringAmount = resInfo[2].replace("$","");
    		
//    		System.out.println(stringAmount);
    		double deliveryFee = Double.parseDouble(stringAmount);
    		Restaurant restaurant = new Restaurant(resInfo[0],resInfo[1],deliveryFee);
    		ArrayList<Food> arrFoods = new ArrayList<Food>();
    		
    		String food1 = resInfo[3];
    		
    		// split the string by comma so that every food is an element in an array 
    		String[] restaurantFoods = food1.split(",");

    		// for every food that exists in the restaurantFood array do the following for each individual food 
    		for(String restaurantFood : restaurantFoods)	{

    		// split the element in the array by - so that the first element is the food name the second element is the food price
    		String[] foodInfo = restaurantFood.split("-", 2);

    		//declare a variable to contain the food name
    		String foodName = foodInfo[0];

    		// remove the dollar sign from the food price string
    		String strFoodPrice= foodInfo[1].replace("$","");

    		//convert the food price string into a double 
    		double foodPrice = Double.parseDouble(strFoodPrice);

    		// create a new Food class instance and pass the foodName and foodPrice variables as parameters
    		Food food = new Food(foodName,foodPrice);

    		//add the new food class instance to the arrayList of foods that will be passed to the restaurant class
    		arrFoods.add(food);

    		}
    		
    		/*
    		 * split the food by comma
    		 * while there is another food in the array
    		 * split the food string by the dash to get an array with 2 elements, food name,food price
    		 * convert the food price string to a proper number
    		 * parse the number into a double
    		 * create a new food class instance by passing the food name and food price as parameters
    		 * add the new food to the array of foods 
    		 * */
    		restaurant.setArrayFood(arrFoods);
    		this.arrRestaurants.add(restaurant);
    		
    		
    		
    	}
    	
	}
	public static void printMenu(String menuType){
		String banner = new String(new char[50]).replace('\u0000', '=');
		
		switch (menuType) {
			case "MainMenu":
				System.out.printf("   %s%n", "1) Browse by Category");
				System.out.printf("   %s%n", "2) Search by Resturant");
				System.out.printf("   %s%n", "3) Checkout");
				System.out.printf("   %s%n", "4) Exit");
				break;	
			    default:
				System.out.println("Please select a valid menu option.");
						break;
		}
		
	}
	
	/**
     * The utility method to read user input.
     */
    public static String readUserInput() {
	    Scanner sc = new Scanner(System.in);
	    return sc.nextLine();
	}
    public static boolean isNumeric(String strNum) {
    	if(strNum == null) {
    		return false;
    	}
    	try {
    		double d = Double.parseDouble(strNum);
    		
    	}catch(NumberFormatException nfe) {
    		return false;
    	}
    return true;
    }
    
    public void checkout() {
		String banner = new String(new char[50]).replace('\u0000', '=');
				
		this.customer.getOrder().printReceipt();
    	System.out.printf(banner + "\n" + "%s%n","Thanks for ordering with Melbourne eats. Enjoy your meal.");
    	this.exit = true;
    }
    
    public void showMenu(String menuType) throws FileNotFoundException {
    	String banner = new String(new char[50]).replace('\u0000', '=');
		switch(menuType) {
		case "MainMenu":
			
			System.out.println(banner + "\n" + "> Select from main menu " + "\n" + banner);
			this.printMenu(menuType);
			break;
		
		case "CategoryMenu":
			System.out.printf("   %s%n", "1) Restuarnt");
			System.out.printf("   %s%n", "2) Cafe");
			System.out.printf("   %s%n", "3) Fast food");
			System.out.printf("   %s%n", "4) Exit");
			menuType = "category";
			break;
			
		case "RestaurantSearchMenu":
			this.showRestaurants(menuType);
			break;
		case "CheckoutMenu":
			this.checkout();
			break;
		default:
			System.out.println("Please select a valid menu option.");
					break;
}
		
    }
    
    public void showRestaurants(String menuType) throws FileNotFoundException {
    	
    	for(Restaurant res: this.arrRestaurants) {
			System.out.println(res.getName());
		}
    	    
    
	}
    
  public void showFoodCategory(String category) {
	  
	 
		  for(Restaurant res: this.arrRestaurants) {
			
			  if(category.equals(res.getCategory()))	{
				  			 
			  System.out.println(res.getName());
			  }
			}
    }
    
}



