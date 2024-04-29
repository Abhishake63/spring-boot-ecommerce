package com.springboot.ecommerce.product;

import com.springboot.ecommerce.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private List<ProductDto> productDtoList;
    private final int limit = 5;

    @BeforeEach
    void setUp() {
        productDtoList = Collections.singletonList(new ProductDto(1L, "Sample Product",
                "This is a sample product description", new BigDecimal("99.99"),
                100, new BigDecimal("1000.00"), 100L));
    }

    @Test
    void getTopSellingProductsOfAllTime() {

        when(productService.getTopSellingProductsOfAllTime(limit)).thenReturn(productDtoList);
        List<ProductDto> result = productController.getTopSellingProductsOfAllTime(limit);
        assertEquals(productDtoList.size(), result.size());
    }

    @Test
    void getTopSellingProductsOfLastMonth() {

        when(productService.getTopSellingProductsOfLastMonth(limit)).thenReturn(productDtoList);
        List<ProductDto> result = productController.getTopSellingProductsOfLastMonth(limit);
        assertEquals(productDtoList.size(), result.size());
    }
}