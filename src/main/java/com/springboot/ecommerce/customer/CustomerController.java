package com.springboot.ecommerce.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getCustomers() {
        logger.info("Call getCustomers");
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        logger.info("Call getCustomer");
        return customerService.getCustomer(id);
    }

    @PostMapping("/")
    public Customer createCustomer(@RequestBody Customer customer) {
        logger.info("Call createCustomer");
        return customerService.saveCustomer(customer);
    }
}
