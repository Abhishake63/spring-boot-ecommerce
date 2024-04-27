package com.springboot.ecommerce.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }
}
