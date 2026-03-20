package com.foodie.app.service;

import java.util.List;

import com.foodie.app.exceptions.OrderNotFoundException;
import com.foodie.app.model.Order;

public interface OrderService {
    public Order saveOrder(Order order);
    public List<Order> getOrdersByCustomerId(String customerId);
    public Order getOrderById(String id) throws OrderNotFoundException;
    public List<Order> getAllOrders();
}
