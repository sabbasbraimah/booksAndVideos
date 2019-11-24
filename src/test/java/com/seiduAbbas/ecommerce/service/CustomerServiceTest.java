package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.converter.CustomerCommandToCustomer;
import com.seiduAbbas.ecommerce.converter.CustomerToCustomerCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    CustomerServiceImp customerService;//service to be tested
    CustomerToCustomerCommand customerToCustomerCommand;
    CustomerCommandToCustomer customerCommandToCustomer;
    @Mock
    CustomerRepository customerRepository;//depended on infrastructure service


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImp(customerCommandToCustomer, customerToCustomerCommand,
                customerRepository);
    }
    @Test
    public void getCustomerByIdTest() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);
        Optional<Customer> customerOptional = Optional.of(customer);

        when(customerRepository.findById(anyLong())).thenReturn(customerOptional);

        Customer customerReturned = customerService.findById(1L);

        assertNotNull("Null Customer returned", customerReturned);
        assertEquals(Optional.of(1L).get(), customerReturned.getId());
        verify(customerRepository, times(1)).findById(anyLong());
        verify(customerRepository, never()).findAll();
    }

    @Test
    public void getCustomersTest() throws Exception {

        Customer customer = new Customer();
        customer.setId(2L);
        HashSet customerData = new HashSet();
        customerData.add(customer);

        when(customerService.getCustomers()).thenReturn(customerData);

        Set<Customer> customers = customerService.getCustomers();

        assertEquals(customers.size(), 1);
       // assertTrue(customers.contains(customer.getId() == 2L));

        verify(customerRepository, times(1)).findAll();
        verify(customerRepository, never()).findById(anyLong());
    }

}
