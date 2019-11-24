package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.converter.LineItemToLineItemCommand;
import com.seiduAbbas.ecommerce.converter.PurchaseOrderingCommandToPurchaseOrdering;
import com.seiduAbbas.ecommerce.converter.PurchaseOrderingToPurchaseOrderingCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import com.seiduAbbas.ecommerce.repository.CustomerRepository;
import com.seiduAbbas.ecommerce.repository.LineItemRepository;
import com.seiduAbbas.ecommerce.repository.PurchaseOrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

public class PurchaseOrderServiceImpTest {
/**
    private LineItemToLineItemCommand lineItemToLineItemCommand;
    private  final PurchaseOrderingToPurchaseOrderingCommand purchaseOrderTo;


    @Mock
    LineItemRepository lineItemRepository;
    @Mock
    PurchaseOrderRepository purchaseOrderRepository;
    @Mock
    CustomerRepository customerRepository;

    PurchaseOrderService purchaseOrderService;

    PurchaseOrderingCommandToPurchaseOrdering purchaseOrderingCommandTo;
    PurchaseOrderingToPurchaseOrderingCommand purchaseOrderingTo;

    //init converters
    public PurchaseOrderServiceImpTest() {
        this.purchaseOrderTo = new PurchaseOrderingToPurchaseOrderingCommand(
                new LineItemToLineItemCommand());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        purchaseOrderService = new PurchaseOrderServiceImp(purchaseOrderingTo,customerRepository );
    }

    @Test
    public void findByCustomerIdAndId() throws Exception {
    }

    @Test
    public void findByCustomerIdAndRecipeIdHappyPath() throws Exception {
        //given
        Customer customer = new Customer();
        customer.setId(1L);

        PurchaseOrdering purchaseOrdering1 = new PurchaseOrdering();
        purchaseOrdering1.setId(1L);

        PurchaseOrdering purchaseOrdering2 = new PurchaseOrdering();
        purchaseOrdering2.setId(2L);

        PurchaseOrdering purchaseOrdering3 = new PurchaseOrdering();
        purchaseOrdering3.setId(3L);

        customer.addPurchaseOrderCommand(purchaseOrdering1);
        customer.addPurchaseOrderCommand(purchaseOrdering2);
        customer.addPurchaseOrderCommand(purchaseOrdering3);

        Optional<Customer> customerOptional = Optional.of(customer);

        when(customerRepository.findById(anyLong())).thenReturn(customerOptional);

        //then
        PurchaseOrderCommand purchaseOrderCommand = purchaseOrderService
                .findByCustomerIdAndPurchaseOrderId(1L, 3L);

        //when
        assertEquals(Long.valueOf(3L), purchaseOrderCommand.getId());
        assertEquals(Long.valueOf(1L), purchaseOrderCommand.getCustomerId());
        verify(customerRepository, times(1)).findById(anyLong());
    }
    **/
}
