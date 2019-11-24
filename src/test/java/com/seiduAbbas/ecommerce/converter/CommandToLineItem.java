package com.seiduAbbas.ecommerce.converter;


import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import com.seiduAbbas.ecommerce.enums.MembershipType;


import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;


public class CommandToLineItem {

    public static final Product PRODUCT = new Product();
    public static final Long QUANTITY = 1L ;
    public static final Long ID_VALUE = new Long(1L);
    public static final MembershipType MEMBERSHIP_TYPE = MembershipType.BOOK;
    private  final PurchaseOrdering PURCHASE_ORDER = new PurchaseOrdering();


    LineItemCommandToLineItem converter;

    @Before
    public void setUp() throws Exception {
        converter = new LineItemCommandToLineItem();
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new LineItemCommand()));
    }

    @Test
    public void testConvertNull() throws Exception {
        //given
        LineItemCommand lineItemCommand = new LineItemCommand();
        lineItemCommand.setId(ID_VALUE);

        lineItemCommand.setQuantity(2);
        lineItemCommand.setMembershipType(MembershipType.BOOK);
        lineItemCommand.setPurchaseOrdering(PURCHASE_ORDER);

        //when
        LineItem lineItem = converter.convert(lineItemCommand);
        //then

        assertEquals(ID_VALUE, lineItemCommand.getId());
        assertEquals(2, lineItemCommand.getQuantity());
        assertNotNull( lineItemCommand.getMembershipType());
        assertNotNull(lineItemCommand.getPurchaseOrdering());
    }
}
