package com.foodie.app.service;

import java.util.List;
import java.util.Optional;

import com.foodie.app.exceptions.OrderNotFoundException;
import com.foodie.app.model.Order;
import com.foodie.app.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        super();
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return this.orderRepository.saveOrder(order);
    }

    @Override
    public List<Order> getOrdersByCustomerId(String customerId) {
        return this.orderRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRepository.findOrderById(id);
        if (!orderById.isPresent()) {
            throw new OrderNotFoundException("Order not found with id: " + id);
        }
        return orderById.get();
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderRepository.getAllOrders();
    }
}
