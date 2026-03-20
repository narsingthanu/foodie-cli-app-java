package com.foodie.app.ui;

import java.util.List;
import java.util.Scanner;

import com.foodie.app.controller.CustomerController;
import com.foodie.app.controller.DishController;
import com.foodie.app.controller.RestaurantController;
import com.foodie.app.controller.OrderController;
import com.foodie.app.exceptions.CustomerExistException;
import com.foodie.app.exceptions.RestaurantNotFoundException;
import com.foodie.app.exceptions.OrderNotFoundException;
import com.foodie.app.model.Customer;
import com.foodie.app.model.Dish;
import com.foodie.app.model.Restaurant;
import com.foodie.app.model.Order;
import com.foodie.app.util.Factory;

public class Menu {
  /*  public Menu() {

    }

    public void displayMenuHeader(String header){
        printDashLine();
        String spaces = new String(new char[70]).replace('\0',' ');
        System.out.printf("%-40s %-10s %-40s \n",spaces,header,spaces);
        printDashLine();
    }

    public  void printDashLine(){
        String dashLines = new String(new char[150]).replace('\0','-');
        System.out.println(dashLines);
    }*/

    public void displayMenu(){
          
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("WELCOME TO FOODIE APP");
                System.out.println();
                System.out.println("Please select the option..!");
                System.out.println("---------------------------");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Restaurant Section");
                System.out.println("4. Dishes Section");
                System.out.println("5. Order Section");
                System.out.println("6. Exit");
                System.out.println("Please Enter Your Choice 1 - 6");

                int input = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (input){
                    case 1:
                	    displayRegisterMenu();
                	    break;
                    case 2:
                        displayLoginMenu();
                        break;
                    case 3:
                        displayRestaurantsList();
                        break;
                    case 4:
                    	displayDishesList();
                    	break;
                    case 5:
                        displayOrderMenu();
                        break;
                    case 6 : 
                        System.out.println("Thanks for choosing Foodie App,See you again..!");
                        System.exit(0);
                    default:
                    	System.out.println("Invalid Input.Please enter valid input from 1 - 6");
                }
            }
          }
        private void displayLoginMenu() {
        	 Scanner scanner = new Scanner(System.in);
        	 System.out.println("\n--- Customer Login ---");
             System.out.println("Enter Your Id: ");
             String id = scanner.nextLine();
             System.out.println("Enter Password: ");
             String password = scanner.nextLine();
             
             CustomerController customerController = Factory.getCustomerController();
             try {
            	 Customer loggedInCustomer = customerController.login(id, password);
            	 if(loggedInCustomer != null) {
                     System.out.println("\nLogin Successful!");
                     System.out.println("Welcome, " + loggedInCustomer.getName());
            	 }
             }catch (Exception e) {
            	 System.out.println("Login Failed: " + e.getMessage());
             }
        }
        private void displayRestaurantsList() {
            RestaurantController restaurantController = Factory.getRestaurantController();
            List<Restaurant> restaurantsList = restaurantController.getRestaurantsList();
            String dashesLine = new String(new char[150]).replace('\0', '-');
            displayMenuHeader("Available Restaurants");
            System.out.printf("%-10s %-30s %-50s %-10s\n", "Id", "Name", "Address", "Menu");
            System.out.println(dashesLine);
            restaurantsList.forEach(restaurant -> {
                String menu = String.join(", ", restaurant.getMenu());
                System.out.printf("%-10s %-30s %-50s %-10s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), menu);
            });
            System.out.println("\nEnter Restaurant Id to view details (or press 0 to go back):");
            Scanner scanner = new Scanner(System.in);
            String restaurantId = scanner.nextLine();
            if (!restaurantId.equals("0")) {
                try {
                    Restaurant restaurant = restaurantController.getRestaurantById(restaurantId);
                    System.out.println("\n" + dashesLine);
                    System.out.println("Restaurant: " + restaurant.getName());
                    System.out.println("Address: " + restaurant.getAddress());
                    System.out.println("Menu Items: " + String.join(", ", restaurant.getMenu()));
                    System.out.println(dashesLine);
                } catch (RestaurantNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        private void displayDishesList() {
        	DishController dishController = Factory.getDishController();
        	//System.out.println(dishController.getDishesList());
            List<Dish> dishesList = dishController.getDishesList();
            String dashesLine = new String(new char[150]).replace('\0', '-');
            displayMenuHeader("Dish Items");
            System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
            System.out.println(dashesLine);
            dishesList.forEach(dish -> {
                System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
            });
		
}
		private void displayMenuHeader(String menuHeader) {
			 String dashesLine = new String(new char[150]).replace('\0', '-');
			 System.out.println(dashesLine);
			 String spaces = new String(new char[70]).replace('\0', ' ');
		     System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
		     System.out.println(dashesLine);
			
		}
		private void displayOrderMenu() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n--- Order Management ---");
			System.out.println("1. Place New Order");
			System.out.println("2. View My Orders");
			System.out.println("3. Back to Main Menu");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume the newline
			
			switch (choice) {
				case 1:
					placeNewOrder(scanner);
					break;
				case 2:
					viewMyOrders(scanner);
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
		
		private void placeNewOrder(Scanner scanner) {
			System.out.println("\n--- Place New Order ---");
			System.out.println("Enter Customer ID: ");
			String customerId = scanner.nextLine();
			System.out.println("Enter Restaurant ID: ");
			String restaurantId = scanner.nextLine();
			System.out.println("Enter Dish IDs (comma separated): ");
			String dishIds = scanner.nextLine();
			System.out.println("Enter Total Price: ");
			double totalPrice = scanner.nextDouble();
			
			try {
				// Create order
				Order order = new Order();
				String orderId = "ORD" + System.currentTimeMillis();
				order.setId(orderId);
				order.setTotalPrice(totalPrice);
				
				// Get customer and restaurant details
				RestaurantController restaurantController = Factory.getRestaurantController();
				Restaurant restaurant = restaurantController.getRestaurantById(restaurantId);
				order.setRestaurant(restaurant);
				
				// Save order
				OrderController orderController = Factory.getOrderController();
				Order savedOrder = orderController.placeOrder(order);
				
				System.out.println("\nOrder placed successfully!");
				System.out.println("Order ID: " + savedOrder.getId());
				System.out.println("Total Price: $" + String.format("%.2f", savedOrder.getTotalPrice()));
			} catch (RestaurantNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		
		private void viewMyOrders(Scanner scanner) {
			System.out.println("\n--- My Orders ---");
			System.out.println("Enter Customer ID: ");
			String customerId = scanner.nextLine();
			
			OrderController orderController = Factory.getOrderController();
			List<Order> orders = orderController.getCustomerOrders(customerId);
			
			if (orders.isEmpty()) {
				System.out.println("No orders found for this customer.");
			} else {
				String dashesLine = new String(new char[150]).replace('\0', '-');
				System.out.println(dashesLine);
				System.out.printf("%-15s %-20s %-15s\n", "Order ID", "Restaurant", "Total Price");
				System.out.println(dashesLine);
				orders.forEach(order -> {
					System.out.printf("%-15s %-20s %-15s\n", 
						order.getId(), 
						order.getRestaurant().getName(),
						String.format("$%.2f", order.getTotalPrice()));
				});
				System.out.println(dashesLine);
			}
		}
		private void displayRegisterMenu() {
        	 Scanner scanner = new Scanner(System.in);
             System.out.println("Please Update entering the following details\n");
             System.out.println("Enter Your Id");
             String id = scanner.nextLine();
             System.out.println("Enter Name");
             String name = scanner.nextLine();
             System.out.println("Enter E-mail");
             String email = scanner.nextLine();
             System.out.println("Enter Password");
             String password = scanner.nextLine();
             Customer customer = new Customer();
             customer.setId(id)
                     .setName(name)
                     .setEmail(email)
                     .setPassword(password);
             
             CustomerController customerController = Factory.getCustomerController();
             try {
            	 Customer savedCustomer = customerController.save(customer);
            	 if(savedCustomer != null) {
                 System.out.println("Customer Registration Successful");
                 System.out.println("Details:");
                 System.out.println("Id : " + customer.getCustomerId());
                 System.out.println("Name: " + customer.getName());
                 System.out.println("E-mail: " + customer.getEmail());
                 System.out.println("Password: " + customer.getPassword());
            	 }else {
            		 System.out.println("Some internal error occured , please try again");
            		 displayRegisterMenu();
            	 }
                 
             }catch (CustomerExistException e) {
            	 System.out.println(e.getMessage());
            	 System.out.println("please login using main menu");
            	 displayMenu();
             }
        }

           
               

    
	

}
