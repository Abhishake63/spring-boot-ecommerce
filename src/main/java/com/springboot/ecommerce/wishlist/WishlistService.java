package com.springboot.ecommerce.wishlist;

import com.springboot.ecommerce.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class WishlistService {

    private static final Logger logger = LoggerFactory.getLogger(WishlistService.class);
    private WishlistRepository wishlistRepository;

    WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Product> getWishlistForCustomer(Long customerId) {
        logger.info("Call getWishlistForCustomer");
        List<Wishlist> wishlist = wishlistRepository.findByCustomerId(customerId);
        return wishlist.stream()
                .map(Wishlist::getProduct)
                .collect(Collectors.toList());
    }
}
