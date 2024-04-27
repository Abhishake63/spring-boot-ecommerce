package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private List<Order> findByOrderDate(LocalDate orderDate) {
        logger.info("Call findByOrderDate");
        return orderRepository.findByOrderDate(orderDate);
    }

    // Designed this function in this way so that we can reuse this block to get total sale amount of any day
    public OrderDto getTotalSaleAmountForSpecificDay(LocalDate date) {
        logger.info("Call getTotalSaleAmountForSpecificDay");
        List<Order> ordersForCurrentDay = findByOrderDate(date);
        BigDecimal totalSaleAmount = ordersForCurrentDay.stream()
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new OrderDto(date, totalSaleAmount);
    }

    // We can do the same thing by a jpa custom query, it is not used but kept it anyway
    public OrderDto getTotalSaleAmountForSpecificDayInSql(LocalDate date) {
        logger.info("Call getTotalSaleAmountForSpecificDayInSql");
        return orderRepository.getTotalSaleAmountForSpecificDayInSql(date);
    }

    public OrderDto getMaxSellDayInRange(LocalDate startDate, LocalDate endDate) {
        logger.info("Call getMaxSellDayInRange");
        return orderRepository.getMaxSellDayInRange(startDate, endDate);
    }
}
