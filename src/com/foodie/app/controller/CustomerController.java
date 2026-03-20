package com.foodie.app.controller;

import com.foodie.app.exceptions.CustomerExistException;
import com.foodie.app.model.Customer;
import com.foodie.app.service.CustomerServiceImpl;

public class CustomerController {
	private CustomerServiceImpl customerService;

	public CustomerController(CustomerServiceImpl customerServiceImpl) {
		super();
		this.customerService = customerServiceImpl;
	}
	
	public Customer save(Customer customer) throws CustomerExistException{
		return this.customerService.save(customer);
	}
	
	public Customer login(String id, String password) throws Exception {
		return this.customerService.login(id, password);
	}

}
