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


public class LineItemToCommandTest {

    public static final Product PRODUCT = new Product();
    public static final Long QUANTITY = 1L ;
    public static final Long ID_VALUE = new Long(1L);
    public static final MembershipType MEMBERSHIP_TYPE = MembershipType.BOOK;
    private  final PurchaseOrdering PURCHASE_ORDER = new PurchaseOrdering();


    LineItemToLineItemCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new LineItemToLineItemCommand();
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new LineItem()));
    }

    @Test
    public void testConvertNull() throws Exception {
        //given
        LineItem lineItem = new LineItem();
        lineItem.setId(ID_VALUE);
        lineItem.setProduct(PRODUCT);
        lineItem.setQuantity(2);
        lineItem.setMembershipType(MembershipType.BOOK);
        lineItem.setPurchaseOrdering(PURCHASE_ORDER);

        //when
        LineItemCommand lineItemCommand = converter.convert(lineItem);
        //then
        assertEquals(ID_VALUE, lineItemCommand.getId());
        assertEquals(2, lineItemCommand.getQuantity());
        assertNotNull( lineItemCommand.getMembershipType());
        assertNotNull(lineItemCommand.getPurchaseOrdering());
    }
/**
    @Test
    public void testConvertWithUom() throws Exception {
        //given
        LineItem LineItem = new LineItem();
        LineItem.setId(ID_VALUE);
        LineItem.setOroduct(Oroduct);
        LineItem.setAmount(AMOUNT);
        LineItem.setDescription(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);

        LineItem.setUom(uom);
        //when
        LineItemCommand LineItemCommand = converter.convert(LineItem);
        //then
        assertEquals(ID_VALUE, LineItemCommand.getId());
        assertNotNull(LineItemCommand.getUnitOfMeasure());
        assertEquals(UOM_ID, LineItemCommand.getUnitOfMeasure().getId());
        // assertEquals(Oroduct, LineItemCommand.get);
        assertEquals(AMOUNT, LineItemCommand.getAmount());
        assertEquals(DESCRIPTION, LineItemCommand.getDescription());
    }
**/
}
