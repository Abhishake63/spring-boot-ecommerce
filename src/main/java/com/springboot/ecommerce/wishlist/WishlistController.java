package com.springboot.ecommerce.wishlist;

import com.springboot.ecommerce.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
class WishlistController {

    private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);
    private WishlistService wishlistService;

    WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/{customerId}")
    public List<Product> getWishlistForCustomer(@PathVariable Long customerId) {
        logger.info("Call getWishlistForCustomer");
        return wishlistService.getWishlistForCustomer(customerId);
    }
}
