package com.springboot.ecommerce.order;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> findByOrderDate(LocalDate orderDate) {
        return orderRepository.findByOrderDate(orderDate);
    }

    public List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }
}
