package com.springboot.ecommerce.product;

import com.springboot.ecommerce.dto.ProductDto;
import com.springboot.ecommerce.orderitem.OrderItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;
    private OrderItemRepository orderItemRepository;

    ProductService(ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<Product> getAllProducts() {
        logger.info("Call getAllProducts");
        return productRepository.findAll();
    }

    public List<ProductDto> getTopSellingProductsOfAllTime(int limit) {
        logger.info("Call getTopSellingProductsOfAllTime");
        return orderItemRepository.findTopSellingProductsOfAllTimeBasedOnSaleAmount(limit);
    }

    public List<ProductDto> getTopSellingProductsOfLastMonth(int limit) {
        logger.info("Call getTopSellingProductsOfLastMonth");
        LocalDate lastMonth = LocalDate.now();
        LocalDate startOfLastMonth = lastMonth.withDayOfMonth(1);
        LocalDate endOfLastMonth = lastMonth.withDayOfMonth(lastMonth.lengthOfMonth());

        return orderItemRepository.findTopSellingProductsOfLastMonthBasedOnNumberOfSales(limit, startOfLastMonth, endOfLastMonth);
    }
}
