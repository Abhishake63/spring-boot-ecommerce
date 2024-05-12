package com.springboot.ecommerce.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;
    private List<Customer> customers;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPhoneNumber("1234567890");
        customers = Collections.singletonList(customer);
    }

    @Test
    void getCustomers() {
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> result = customerService.getCustomers();
        assertEquals(customers.size(), result.size());
    }

    @Test
    void getCustomer() {
        when(customerRepository.findById(1L)).thenReturn(Optional.ofNullable(customer));
        Customer result = customerService.getCustomer(1L);
        assertEquals(customer, result);
    }

    @Test
    void saveCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer result = customerService.saveCustomer(customer);
        assertEquals(customer, result);
    }
}