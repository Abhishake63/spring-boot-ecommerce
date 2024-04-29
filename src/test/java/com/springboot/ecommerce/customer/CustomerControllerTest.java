package com.springboot.ecommerce.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

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

        when(customerService.getCustomers()).thenReturn(customers);
        List<Customer> result = customerController.getCustomers();
        assertEquals(customers.size(), result.size());
    }

    @Test
    void getCustomer() {

        when(customerService.getCustomer(1L)).thenReturn(customer);
        Customer result = customerController.getCustomer(1L);
        assertEquals(customer, result);
    }

    @Test
    void createCustomer() {

        when(customerService.saveCustomer(customer)).thenReturn(customer);
        Customer result = customerController.createCustomer(customer);
        assertEquals(customer, result);
    }
}