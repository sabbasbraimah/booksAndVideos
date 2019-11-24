package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.domain.Account;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CommandToCustomer {

/**
    public static final Long Customer_ID = 1L;
    public static final Long PurchaseOrder_ID = 1L;
    public static final Long AccountID = 3L;
    public static final Long  PurvhaseOrderingID2= 4L;
    public  static final BigDecimal PRICE = new BigDecimal(20.00);

    CustomerCommandToCustomer converter;

    @Before
    public void setUp() throws Exception {
        converter = new CustomerCommandToCustomer(
                new PurchaseOrderingCommandToPurchaseOrdering(new LineItemCommandToLineItem()), accountCommandToCustomer);
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CustomerCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CustomerCommand customerCommand = new CustomerCommand();

        customerCommand.setId(Customer_ID);
        customerCommand.setFirstName("Jerries");
        customerCommand.setLastName("Jays");
        customerCommand.setAddressLine1("S53");
        customerCommand.setAddressLine2("Nkramom--Old Suame");
        customerCommand.setCity("Kumasi");
        customerCommand.setPostCode("NK99 SUA");
        customerCommand.setEmail("jays@hotmaul@com");

        Account account = new Account();
        account.setId(AccountID);
        customerCommand.setAccount(account);

        PurchaseOrdering purchaseOrdering = new PurchaseOrdering();
        purchaseOrdering.setId(1L);
        Set<PurchaseOrdering> purchaseOrderingSet = new HashSet<>();
        purchaseOrderingSet.add(purchaseOrdering);

        customerCommand.setPurchaseOrderings(purchaseOrderingSet);

        //when
        Customer customer = converter.convert(customerCommand);

        PurchaseOrdering purchaseOrder = new PurchaseOrdering();
        Set<PurchaseOrdering> purchaseOrderSet = new   HashSet<>();
        purchaseOrderSet.add(purchaseOrder);

        customer.setPurchaseOrderings(purchaseOrderSet);
        //then
        assertNotNull(customer);
        assertEquals(Customer_ID, customer.getId());
        assertEquals("Jerries", customer.getFirstName());
        assertEquals("Jays", customer.getLastName());
        assertEquals("S53", customer.getAddressLine1());
        assertEquals("Nkramom--Old Suame",customer.getAddressLine2());
        assertEquals("Kumasi" , customer.getCity());
        assertEquals("NK99 SUA", customer.getPostCode());
        assertEquals("jays@hotmaul@com",  customer.getEmail());
        assertNotNull(purchaseOrdering);
        assertEquals(PurchaseOrder_ID, purchaseOrdering.getId() );
        assertEquals(1 , customer.getPurchaseOrderings().size());
        assertNotNull(customer.getAccount());
        assertEquals( AccountID, account.getId());
    }
**/
}
