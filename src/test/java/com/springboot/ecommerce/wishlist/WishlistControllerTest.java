package com.springboot.ecommerce.wishlist;

import com.springboot.ecommerce.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WishlistControllerTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishlistController wishlistController;

    private List<Product> products;

    @BeforeEach
    void setUp() {

        products = new ArrayList<>();
        Product product1 = new Product(1L, "Sample Product 1", "This is a sample product", new BigDecimal("99.99"), 100);
        Product product2 = new Product(2L, "Sample Product 2", "This is a sample product", new BigDecimal("99.99"), 100);
        products.add(product1);
        products.add(product2);
    }

    @Test
    void getWishlistForCustomer() {

        Long customerId = 1L;
        when(wishlistService.getWishlistForCustomer(customerId)).thenReturn(products);
        List<Product> result = wishlistController.getWishlistForCustomer(customerId);
        assertEquals(products.size(), result.size());
    }
}