package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("SELECT NEW com.springboot.ecommerce.dto.ProductDto(p.id, p.name, p.description, p.price, p.stockQuantity, SUM(oi.quantity * oi.price), SUM(oi.quantity)) "
            + "FROM OrderItem oi "
            + "JOIN Order o ON oi.order = o "
            + "JOIN Product p ON oi.product = p "
            + "GROUP BY p.id "
            + "ORDER BY SUM(oi.quantity * oi.price) DESC "
            + "LIMIT :limit")
    List<ProductDto> findTopSellingProductsOfAllTime(@Param("limit") int limit);

    @Query("SELECT NEW com.springboot.ecommerce.dto.ProductDto(p.id, p.name, p.description, p.price, p.stockQuantity, SUM(oi.quantity * oi.price), SUM(oi.quantity)) "
            + "FROM OrderItem oi "
            + "JOIN Order o ON oi.order = o "
            + "JOIN Product p ON oi.product = p "
            + "WHERE o.orderDate BETWEEN :startDate AND :endDate "
            + "GROUP BY p.id "
            + "ORDER BY SUM(oi.quantity) DESC "
            + "LIMIT :limit")
    List<ProductDto> findTopSellingProductsOfLastMonth(@Param("limit") int limit,
                                                        @Param("startDate") LocalDate startDate,
                                                        @Param("endDate") LocalDate endDate);
}
