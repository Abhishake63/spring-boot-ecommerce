package com.springboot.ecommerce.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OrderItemService {

    private static final Logger logger = LoggerFactory.getLogger(OrderItemService.class);
    private final OrderItemRepository orderItemRepository;

    OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        logger.info("Call getAllOrderItems");
        return orderItemRepository.findAll();
    }
}
