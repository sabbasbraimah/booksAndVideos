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


public class ProductToCommand {

    public static final Long Product_ID = 1L;
    public static final Long LineItemID = 3L;
    public static final Long  LineItemID2= 4L;
    public  static final BigDecimal PRICE = new BigDecimal(20.00);
    public  final Set<LineItem> LINE_ITEMS = new HashSet<>();
    public static final ProductType PRODUCT_TYPE = ProductType.BOOK;
    public static final ProductState PRODUCT_STATE = ProductState.PHYSICAL;

    ProductToProductCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new ProductToProductCommand(new LineItemToLineItemCommand() );
      
    }
    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Product()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Product product = new Product();

        product.setId(Product_ID);
        product.setPrice(new BigDecimal(20));
        product.setName("Morning Sights");
        product.setProductType(ProductType.BOOK);
        product.setProductState(ProductState.PHYSICAL);

        LineItem lineItem1 = new LineItem();
        lineItem1.setId(LineItemID);

        LineItem lineItem2 = new LineItem();
        lineItem2.setId(LineItemID2);

        product.getLineItems().add(lineItem1);
        product.getLineItems().add(lineItem2);

        //when
        ProductCommand command = converter.convert(product);

        LineItemCommand lineItemCommand = new LineItemCommand();
        Set<LineItemCommand >lineItemCommandSet = new   HashSet<>();
        lineItemCommandSet.add(lineItemCommand);
        command.setLineItemCommands(lineItemCommandSet);
        //then
        assertNotNull(command);
        assertEquals(Product_ID, command.getId());
        assertEquals(PRICE, product.getPrice());
        assertEquals("Morning Sights", command.getName());
        assertEquals(PRODUCT_STATE, command.getProductState());
        assertEquals(PRODUCT_TYPE, command.getProductType());
        assertNotNull(lineItem1);
        assertNotNull(lineItem2);
        assertEquals(LineItemID, lineItem1.getId());
        assertEquals(LineItemID2, lineItem2.getId());
        assertEquals(1, command.getLineItemCommands().size());
        assertEquals(2, product.getLineItems().size());
    }
}
