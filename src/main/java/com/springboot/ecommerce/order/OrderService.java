package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
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

    private List<Order> findByOrderDate(LocalDate orderDate) {
        return orderRepository.findByOrderDate(orderDate);
    }

    private List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    public OrderDto getTotalSaleAmountForCurrentDay() {

        LocalDate currentDate = LocalDate.now();
        List<Order> ordersForCurrentDay = findByOrderDate(currentDate);
        BigDecimal totalSaleAmount = ordersForCurrentDay.stream()
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new OrderDto(currentDate, totalSaleAmount);
    }

    public OrderDto getMaxSellDayInRange(LocalDate startDate, LocalDate endDate) {

        List<Order> ordersInRange = findByOrderDateBetween(startDate, endDate);
        LocalDate maxSaleDate = ordersInRange.stream()
                .map(Order::getOrderDate)
                .max(LocalDate::compareTo)
                .orElse(null);
        BigDecimal maxSaleAmount = ordersInRange.stream()
                .filter(order -> order.getOrderDate().equals(maxSaleDate))
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new OrderDto(maxSaleDate, maxSaleAmount);
    }
}
