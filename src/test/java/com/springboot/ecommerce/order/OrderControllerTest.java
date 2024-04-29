package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.OrderDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private OrderDto orderDto;

    @BeforeEach
    void setUp() {
        orderDto = new OrderDto(LocalDate.now(), BigDecimal.valueOf(1000.0));
    }

    @Test
    void getTotalSaleAmountForCurrentDay() {

        when(orderService.getTotalSaleAmountForSpecificDay(any(LocalDate.class))).thenReturn(orderDto);
        OrderDto result = orderController.getTotalSaleAmountForCurrentDay();
        assertEquals(orderDto, result);
    }

    @Test
    void getMaxSaleDayInRange() {

        LocalDate startDate = LocalDate.of(2023, 4, 1);
        LocalDate endDate = LocalDate.of(2023, 4, 30);

        when(orderService.getMaxSellDayInRange(startDate, endDate)).thenReturn(orderDto);
        OrderDto result = orderController.getMaxSaleDayInRange(startDate, endDate);
        assertEquals(orderDto, result);
    }
}