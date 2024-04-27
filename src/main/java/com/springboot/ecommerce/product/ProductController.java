package com.springboot.ecommerce.product;

import com.springboot.ecommerce.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/top-selling/all-time")
    public List<ProductDto> getTopSellingProductsOfAllTime(@RequestParam int limit) {
        logger.info("Call getTopSellingProductsOfAllTime");
        return productService.getTopSellingProductsOfAllTime(limit);
    }

    @GetMapping("/top-selling/last-month")
    public List<ProductDto> getTopSellingProductsOfLastMonth(@RequestParam int limit) {
        logger.info("Call getTopSellingProductsOfLastMonth");
        return productService.getTopSellingProductsOfLastMonth(limit);
    }
}
