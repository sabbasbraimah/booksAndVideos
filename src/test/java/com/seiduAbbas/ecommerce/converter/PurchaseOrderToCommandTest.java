package com.seiduAbbas.ecommerce.converter;


import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.domain.*;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class PurchaseOrderToCommandTest {

/**
    public static final Long PURCHASE_ODER_ID  = 1L;
    public static final Customer CUSTOMER = new Customer();
    public static final Long CUSTOMER_ID =  1L;
    public static final Long LINE_ITEM_ID =  1L;
    public static BigDecimal TOTAL_COST = new BigDecimal(20.00);
    private  List<LineItem> LINE_ITEM = null;
    private  LineItem lineItem = null;
    private   LineItemCommandToLineItem lineItemCommandToLineItem;


    PurchaseOrderingToPurchaseOrderingCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new PurchaseOrderingToPurchaseOrderingCommand( new LineItemToLineItemCommand(), customerRepository);
        LINE_ITEM = new ArrayList<>();;
        lineItem = new LineItem();
        TOTAL_COST = new BigDecimal(20.00);
        lineItemCommandToLineItem = new LineItemCommandToLineItem();
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new PurchaseOrdering()));
    }

    @Test
    public void testConvertNull() throws Exception {
        //given
        PurchaseOrdering purchaseOrdering = new PurchaseOrdering();
        purchaseOrdering.setId(PURCHASE_ODER_ID);
        purchaseOrdering.setCustomer(CUSTOMER);

        LineItem lineItem2 = new LineItem();
        lineItem.setId(LINE_ITEM_ID);
        List<LineItem> lineItemListSet = new ArrayList<>();
        lineItemListSet.add(lineItem2);
        purchaseOrdering.setLineItems( lineItemListSet);
        purchaseOrdering.setTotalCost(TOTAL_COST);
        CUSTOMER.getPurchaseOrderings().add(purchaseOrdering);

        //when
        PurchaseOrderCommand purchaseOrderingCommand = converter.convert(purchaseOrdering);
        //then

        assertEquals(PURCHASE_ODER_ID, purchaseOrderingCommand.getId());
        assertEquals(TOTAL_COST , purchaseOrderingCommand.getTotalCost());
        assertNotNull(purchaseOrderingCommand.getLineItems());
        assertTrue(purchaseOrderingCommand.getLineItems().size() > 0);
        assertNotNull(CUSTOMER);
        assertTrue(CUSTOMER.getPurchaseOrderings().size() > 0);
    }
**/
}
