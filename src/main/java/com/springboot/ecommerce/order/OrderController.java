package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.OrderDto;
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
    public OrderDto getTotalSaleAmountForCurrentDay() {
        return orderService.getTotalSaleAmountForCurrentDay();
    }

    @GetMapping("/max-sale-day")
    public OrderDto getMaxSaleDayInRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return orderService.getMaxSellDayInRange(startDate, endDate);
    }

}
