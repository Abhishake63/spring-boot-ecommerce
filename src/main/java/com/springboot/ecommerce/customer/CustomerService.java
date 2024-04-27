package com.springboot.ecommerce.customer;

import com.springboot.ecommerce.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CustomerService {

    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + id));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // update and delete methods
}