package com.springboot.ecommerce.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByCustomerId(Long customerId);
}
