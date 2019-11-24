package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.enums.ProductState;
import com.seiduAbbas.ecommerce.enums.ProductType;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CommandToProductTest {


    public static final Long Product_ID = 1L;
    public static final Long LineItemID = 3L;
    public static final Long  LineItemID2= 4L;
    public  static final BigDecimal PRICE = new BigDecimal(20.00);
    public  final Set<LineItem> LINE_ITEMS = new HashSet<>();
    public static final ProductType PRODUCT_TYPE = ProductType.BOOK;
    public static final ProductState PRODUCT_STATE = ProductState.PHYSICAL;

        ProductCommandToProduct converter;

    @Before
    public void setUp() throws Exception {
        converter = new ProductCommandToProduct(new LineItemCommandToLineItem() );

    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new ProductCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        ProductCommand productCommand = new ProductCommand();

        productCommand.setId(Product_ID);
        productCommand.setPrice(new BigDecimal(20));
        productCommand.setName("Morning Sights");
        productCommand.setProductType(ProductType.BOOK);
        productCommand.setProductState(ProductState.PHYSICAL);
       Set<LineItemCommand>lineItemCommandSet = new HashSet<>();
        productCommand.setLineItemCommands(lineItemCommandSet);

        LineItemCommand lineItemCommand1 = new LineItemCommand();
        lineItemCommand1.setId(LineItemID);

        LineItemCommand lineItemCommand2 = new LineItemCommand();
        lineItemCommand2.setId(LineItemID2);

        productCommand.getLineItemCommands().add(lineItemCommand1)   ;       //getLineItems().add(lineItem1);
        productCommand.getLineItemCommands().add(lineItemCommand2);

        //when
        Product product = converter.convert(productCommand);

        LineItem lineItem = new LineItem();
        LineItem lineItem2 = new LineItem();
        lineItem2.setId(111L);
        Set<LineItem >lineItems = new   HashSet<>();
        lineItems.add(lineItem);
        lineItems.add(lineItem2);
        product.setLineItems(lineItems);
        //then
        assertNotNull(product);
        assertEquals(Product_ID, product.getId());
        assertEquals(PRICE, product.getPrice());
        assertEquals("Morning Sights", product.getName());
        assertEquals(PRODUCT_STATE, product.getProductState());
        assertEquals(PRODUCT_TYPE, product.getProductType());
        assertNotNull(lineItemCommand1);
        assertNotNull(lineItemCommand2);
        assertEquals(LineItemID, lineItemCommand1.getId());
        assertEquals(LineItemID2, lineItemCommand2.getId());
        assertEquals(2, product.getLineItems().size());
    }

}
