package com.springboot.ecommerce.wishlist;

import com.springboot.ecommerce.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class WishlistService {

    private final WishlistRepository wishlistRepository;

    WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Product> getWishlistForCustomer(Long customerId) {
        List<Wishlist> wishlist = wishlistRepository.findByCustomerId(customerId);
        return wishlist.stream()
                .map(Wishlist::getProduct)
                .collect(Collectors.toList());
    }
}
