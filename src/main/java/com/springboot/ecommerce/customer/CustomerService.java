package com.springboot.ecommerce.customer;

import com.springboot.ecommerce.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        logger.info("Call getCustomers");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        logger.info("Call getCustomer");
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + id));
    }

    public Customer saveCustomer(Customer customer) {
        logger.info("Call saveCustomer");
        return customerRepository.save(customer);
    }

    // update and delete methods
}