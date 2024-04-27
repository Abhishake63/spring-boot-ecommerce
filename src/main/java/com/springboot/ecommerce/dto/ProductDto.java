package com.springboot.ecommerce.dto;

import com.springboot.ecommerce.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto extends Product {

    private BigDecimal totalSalesInPrice;
    private Long totalSalesInQuantity;

    public ProductDto(Long id, String name, String description, BigDecimal price, Integer stock, BigDecimal totalSalesInPrice, Long totalSalesInQuantity) {
        super(id, name, description, price, stock);
        this.totalSalesInPrice = totalSalesInPrice;
        this.totalSalesInQuantity = totalSalesInQuantity;
    }
}
