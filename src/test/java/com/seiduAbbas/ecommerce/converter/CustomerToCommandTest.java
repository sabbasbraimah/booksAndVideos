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


public class CustomerToCommandTest {
/**

    public static final Long Customer_ID = 1L;
    public static final Long PurchaseOrder_ID = 1L;
    public static final Long AccountID = 3L;
    public static final Long  PurvhaseOrderingID2= 4L;
    public  static final BigDecimal PRICE = new BigDecimal(20.00);

    private

    CustomerToCustomerCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CustomerToCustomerCommand(
                new PurchaseOrderingToPurchaseOrderingCommand(new LineItemToLineItemCommand()), accountToAccountCommand);
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Customer()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Customer customer = new Customer();

        customer.setId(Customer_ID);
        customer.setFirstName("Jerries");
        customer.setLastName("Jays");
        customer.setAddressLine1("S53");
        customer.setAddressLine2("Nkramom--Old Suame");
        customer.setCity("Kumasi");
        customer.setPostCode("NK99 SUA");
        customer.setEmail("jays@hotmaul@com");
        customer.setProvince("Ashanti Region");
        Account account = new Account();
        account.setId(3L);
        customer.setAccount(account);
        
        PurchaseOrdering purchaseOrdering = new PurchaseOrdering();
        purchaseOrdering.setId(1L);
        Set<PurchaseOrdering> purchaseOrderingSet = new HashSet<>();
        purchaseOrderingSet.add(purchaseOrdering);
       
        customer.setPurchaseOrderings(purchaseOrderingSet);

        //when
        CustomerCommand command = converter.convert(customer);

        PurchaseOrdering purchaseOrder = new PurchaseOrdering();
        Set<PurchaseOrdering> purchaseOrderSet = new   HashSet<>();
        purchaseOrderSet.add(purchaseOrder);

        command.setPurchaseOrderings(purchaseOrderSet);
        //then
        assertNotNull(command);
        assertEquals(Customer_ID, command.getId());
        assertEquals("Jerries", command.getFirstName());
        assertEquals("Jays", command.getLastName());
        assertEquals("S53", command.getAddressLine1());
        assertEquals("Nkramom--Old Suame",command.getAddressLine2());
        assertEquals("Kumasi" , command.getCity());
        assertEquals("NK99 SUA", command.getPostCode());
        assertEquals("jays@hotmaul@com",  command.getEmail());
        assertNotNull(purchaseOrdering);
        assertEquals(PurchaseOrder_ID, purchaseOrdering.getId() );
        assertEquals(1 , command.getPurchaseOrderings().size());
        assertNotNull(command.getAccount());
        assertEquals( AccountID, command.getAccount().getId());
    }
   **/
}
