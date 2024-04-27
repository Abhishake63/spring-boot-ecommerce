package com.springboot.ecommerce.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderDate(LocalDate orderDate);
    List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
}