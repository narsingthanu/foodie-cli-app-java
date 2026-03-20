package com.foodie.app.controller;

import java.util.List;

import com.foodie.app.exceptions.OrderNotFoundException;
import com.foodie.app.model.Order;
import com.foodie.app.service.OrderServiceImpl;

public class OrderController {
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        super();
        this.orderService = orderService;
    }

    public Order placeOrder(Order order) {
        return this.orderService.saveOrder(order);
    }

    public List<Order> getCustomerOrders(String customerId) {
        return this.orderService.getOrdersByCustomerId(customerId);
    }

    public Order getOrderById(String orderId) throws OrderNotFoundException {
        return this.orderService.getOrderById(orderId);
    }

    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }
}
