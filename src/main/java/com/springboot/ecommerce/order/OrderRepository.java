package com.springboot.ecommerce.order;

import com.springboot.ecommerce.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderDate(LocalDate orderDate);

    @Query("SELECT NEW com.springboot.ecommerce.dto.OrderDto(o.orderDate, SUM(o.totalAmount)) " +
            "FROM Order o " +
            "WHERE o.orderDate BETWEEN :startDate AND :endDate " +
            "GROUP BY o.orderDate " +
            "ORDER BY SUM(o.totalAmount) DESC " +
            "LIMIT 1")
    OrderDto getMaxSellDayInRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT NEW com.springboot.ecommerce.dto.OrderDto(:date, COALESCE(SUM(o.totalAmount), 0)) " +
            "FROM Order o " +
            "WHERE o.orderDate = :date"
    )
    OrderDto getTotalSaleAmountForSpecificDayInSql(@Param("date") LocalDate date);
}
