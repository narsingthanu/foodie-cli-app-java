package com.foodie.app.util;

import com.foodie.app.controller.CustomerController;
import com.foodie.app.controller.DishController;
import com.foodie.app.controller.RestaurantController;
import com.foodie.app.controller.OrderController;
import com.foodie.app.repository.CustomerRepository;
import com.foodie.app.repository.DishRepository;
import com.foodie.app.repository.RestaurantRepository;
import com.foodie.app.repository.OrderRepository;
import com.foodie.app.service.CustomerServiceImpl;
import com.foodie.app.service.DishServiceImpl;
import com.foodie.app.service.RestaurantServiceImpl;
import com.foodie.app.service.OrderServiceImpl;

public class Factory {
	public static CustomerRepository getCustomerRepository() {
		return new CustomerRepository();
		}
		public static CustomerServiceImpl getCustomerService() {
			return new CustomerServiceImpl(getCustomerRepository());
		}
		public static CustomerController getCustomerController() {
			return new CustomerController(getCustomerService());
		}
		public static CsvReader getCsvReader() {
			return new CsvReader();
		}
		public static DishRepository getDishRepository() {
			return new DishRepository();
		}
		public static DishServiceImpl getDishService() {
			return new DishServiceImpl(getDishRepository());
		}
		public static DishController getDishController() {
			return new DishController(getDishService());
		}
	public static RestaurantRepository getRestaurantRepository() {
		return new RestaurantRepository();
	}
	public static RestaurantServiceImpl getRestaurantService() {
		return new RestaurantServiceImpl(getRestaurantRepository());
	}
	public static RestaurantController getRestaurantController() {
		return new RestaurantController(getRestaurantService());
	}
	public static OrderRepository getOrderRepository() {
		return new OrderRepository();
	}
	public static OrderServiceImpl getOrderService() {
		return new OrderServiceImpl(getOrderRepository());
	}
	public static OrderController getOrderController() {
		return new OrderController(getOrderService());
	}
}
