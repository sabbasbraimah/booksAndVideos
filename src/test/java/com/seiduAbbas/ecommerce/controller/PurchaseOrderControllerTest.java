package com.seiduAbbas.ecommerce.controller;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.controllers.PurchaseOrderController;
import com.seiduAbbas.ecommerce.converter.PurchaseOrderingCommandToPurchaseOrdering;
import com.seiduAbbas.ecommerce.service.CustomerService;
import com.seiduAbbas.ecommerce.service.LineItemService;
import com.seiduAbbas.ecommerce.service.PurchaseOrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class PurchaseOrderControllerTest {
    /**
    @Mock
    CustomerService customerService;
    @Mock
    PurchaseOrderService purchaseOrderService;
    PurchaseOrderController purchaseOrderController;
    @Mock
    PurchaseOrderingCommandToPurchaseOrdering purchaseOrderingCommandToPurchaseOrdering
    @Mock
    LineItemService lineItemService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        purchaseOrderController = new PurchaseOrderController(purchaseOrderService, customerService,
                purchaseOrderingCommandToPurchaseOrdering);
        mockMvc = MockMvcBuilders.standaloneSetup(purchaseOrderController).build();
    }


    @Test
    public void testShowPurchaseOrder()throws  Exception {
        //given
        PurchaseOrderCommand purchaseOrderCommand = new PurchaseOrderCommand();
        purchaseOrderCommand.setId(1L);
        CustomerCommand customerCommand = new CustomerCommand();
        customerCommand.setId(1L);


        //when
        when(purchaseOrderService.findByCustomerIdAndPurchaseOrderId(anyLong(), anyLong())).thenReturn(purchaseOrderCommand);

        //then
        mockMvc.perform(get("/customer/1/purchaseOrder/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/purchaseOrder/show"))
                .andExpect(model().attributeExists("purchaseOrdering"));
    }
    **/
}
