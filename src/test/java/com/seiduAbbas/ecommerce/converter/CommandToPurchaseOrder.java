package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;


public class CommandToPurchaseOrder {

/**
    public static final Long PURCHASE_ODER_ID  = 1L;
    public static final CustomerCommand CUSTOMER = new CustomerCommand();
    public static final Long CUSTOMER_ID =  1L;
    public static final Long LINE_ITEM_ID =  1L;
    public static BigDecimal TOTAL_COST = new BigDecimal(20.00);
    private List<LineItem> LINE_ITEM = null;
    private  LineItem lineItem = null;
    private   LineItemCommandToLineItem lineItemCommandToLineItem;
    private  PurchaseOrderingCommandToPurchaseOrdering purchaseOrderingCommandToPurchaseOrdering;
    private  CustomerCommandToCustomer customerCommandToCustomer;


    PurchaseOrderingCommandToPurchaseOrdering converter;

    @Before
    public void setUp() throws Exception {
        converter = new PurchaseOrderingCommandToPurchaseOrdering( new LineItemCommandToLineItem());
        LINE_ITEM = new ArrayList<>();;
        lineItem = new LineItem();
        TOTAL_COST = new BigDecimal(20.00);
        lineItemCommandToLineItem = new LineItemCommandToLineItem();
        purchaseOrderingCommandToPurchaseOrdering =
                new PurchaseOrderingCommandToPurchaseOrdering(new LineItemCommandToLineItem());
        customerCommandToCustomer = new CustomerCommandToCustomer(
                new PurchaseOrderingCommandToPurchaseOrdering(new LineItemCommandToLineItem()));
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new PurchaseOrderCommand() ));
    }

    @Test
    public void testConvertNull() throws Exception {
        //given
        PurchaseOrderCommand purchaseOrderCommand = new PurchaseOrderCommand();
        purchaseOrderCommand.setId(PURCHASE_ODER_ID);
        purchaseOrderCommand.setCustomer( customerCommandToCustomer.convert(CUSTOMER));

        LineItemCommand lineItemCommand = new LineItemCommand();
        lineItemCommand.setId(LINE_ITEM_ID);

        List<LineItemCommand> lineItemCommandListList = new ArrayList<>();
        lineItemCommandListList.add(lineItemCommand);

        purchaseOrderCommand.setLineItems( lineItemCommandListList);
        purchaseOrderCommand.setTotalCost(TOTAL_COST);
        Set<PurchaseOrdering> purchaseOrderings = new HashSet<>();
        CUSTOMER.setPurchaseOrderings(purchaseOrderings);
        CUSTOMER.getPurchaseOrderings().add(purchaseOrderingCommandToPurchaseOrdering.convert(purchaseOrderCommand));

        //when
        PurchaseOrdering purchaseOrdering = converter.convert(purchaseOrderCommand);
        //then
        assertNull(purchaseOrdering.getCustomerId());
        assertEquals(PURCHASE_ODER_ID, purchaseOrdering.getId());
        assertEquals(TOTAL_COST , purchaseOrdering.getTotalCost());
        assertNotNull(purchaseOrdering.getLineItems());
        assertTrue(purchaseOrdering.getLineItems().size() > 0);
        assertNotNull(CUSTOMER);
        assertTrue(CUSTOMER.getPurchaseOrderings().size() > 0);
    }

**/
}
