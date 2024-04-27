package com.springboot.ecommerce.product;

import com.springboot.ecommerce.dto.ProductDto;
import com.springboot.ecommerce.order.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
class ProductService {

    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    ProductService(ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductDto> getTopSellingProductsOfAllTime(int limit) {
        return orderItemRepository.findTopSellingProductsOfAllTimeBasedOnSaleAmount(limit);
    }

    public List<ProductDto> getTopSellingProductsOfLastMonth(int limit) {
        LocalDate lastMonth = LocalDate.now();
        LocalDate startOfLastMonth = lastMonth.withDayOfMonth(1);
        LocalDate endOfLastMonth = lastMonth.withDayOfMonth(lastMonth.lengthOfMonth());

        return orderItemRepository.findTopSellingProductsOfLastMonthBasedOnNumberOfSales(limit, startOfLastMonth, endOfLastMonth);
    }
}
