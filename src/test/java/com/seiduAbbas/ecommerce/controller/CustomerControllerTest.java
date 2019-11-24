package com.seiduAbbas.ecommerce.controller;

import com.seiduAbbas.ecommerce.controllers.CustomerController;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class CustomerControllerTest {

    @Mock
    CustomerService customerService;
    CustomerController customerController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerController = new CustomerController(customerService);
    }

    @Test
    public void testGetCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        when(customerService.findById(anyLong())).thenReturn(customer);

        mockMvc.perform(get("/customer/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/show"));
    }
}