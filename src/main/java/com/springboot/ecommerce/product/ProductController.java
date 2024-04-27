package com.springboot.ecommerce.product;

import com.springboot.ecommerce.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/top-selling")
    public List<ProductDto> getTopSellingProductsOfAllTime(@RequestParam int limit) {
        return productService.getTopSellingProductsOfAllTime(limit);
    }

    @GetMapping("/top-selling/last-month")
    public List<ProductDto> getTopSellingProductsOfLastMonth(@RequestParam int limit) {
        return productService.getTopSellingProductsOfLastMonth(limit);
    }
}
