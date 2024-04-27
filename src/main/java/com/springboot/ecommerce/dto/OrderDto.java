package com.springboot.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OrderDto {
    private LocalDate maxSaleDate;
    private BigDecimal maxSaleAmount;
}
