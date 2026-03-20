package com.foodie.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.foodie.app.model.Order;

public class OrderRepository {
    private List<Order> ordersList;

    public OrderRepository() {
        this.ordersList = new ArrayList<>();
    }

    public List<Order> getAllOrders() {
        return this.ordersList;
    }

    public Order saveOrder(Order order) {
        this.ordersList.add(order);
        return order;
    }

    public Optional<Order> findOrderById(String id) {
        return this.ordersList.stream().filter(order -> order.getId().equals(id)).findFirst();
    }

    public List<Order> findOrdersByCustomerId(String customerId) {
        List<Order> customerOrders = new ArrayList<>();
        this.ordersList.stream()
                .filter(order -> order.getCustomer().getCustomerId().equals(customerId))
                .forEach(customerOrders::add);
        return customerOrders;
    }
}
