package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.MaxSaleDayResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
class OrderController {

    private OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/total-sales-today")
    public BigDecimal getTotalSaleAmountForCurrentDay() {
        LocalDate currentDate = LocalDate.now();
        List<Order> ordersForCurrentDay = orderService.findByOrderDate(currentDate);

        BigDecimal totalSaleAmount = ordersForCurrentDay.stream()
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalSaleAmount;
    }

    @GetMapping("/max-sale-day")
    public ResponseEntity<MaxSaleDayResponse> getMaxSaleDayInRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        List<Order> ordersInRange = orderService.findByOrderDateBetween(startDate, endDate);

        LocalDate maxSaleDate = ordersInRange.stream()
                .map(Order::getOrderDate)
                .max(LocalDate::compareTo)
                .orElse(null);

        BigDecimal maxSaleAmount = ordersInRange.stream()
                .filter(order -> order.getOrderDate().equals(maxSaleDate))
                .map(Order::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        MaxSaleDayResponse response = new MaxSaleDayResponse(maxSaleDate, maxSaleAmount);
        return ResponseEntity.ok(response);
    }

}
