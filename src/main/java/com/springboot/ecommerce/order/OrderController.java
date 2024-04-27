package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/orders")
class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/total-sales-today")
    public OrderDto getTotalSaleAmountForCurrentDay() {
        logger.info("Call getTotalSaleAmountForCurrentDay");
        return orderService.getTotalSaleAmountForSpecificDay(LocalDate.now());
    }

    @GetMapping("/max-sale-day")
    public OrderDto getMaxSaleDayInRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        logger.info("Call getMaxSaleDayInRange");
        return orderService.getMaxSellDayInRange(startDate, endDate);
    }

}
