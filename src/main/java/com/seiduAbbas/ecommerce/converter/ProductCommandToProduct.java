package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.domain.Product;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandToProduct implements Converter<ProductCommand, Product> {

   private  final  LineItemCommandToLineItem lineItemCommandToLineItem;

    public ProductCommandToProduct(LineItemCommandToLineItem lineItemCommandToLineItem) {
        this.lineItemCommandToLineItem = lineItemCommandToLineItem;
    }

    @Synchronized
    @Nullable
    @Override
    public Product convert(ProductCommand productCommand) {

        if (productCommand == null){
            return  null;
        }
        Product product = new Product();
        product.setId(productCommand.getId());
        product.setName(productCommand.getName());
        product.setProductState(productCommand.getProductState());
        product.setProductType(productCommand.getProductType());
        product.setPrice(productCommand.getPrice());

        if (productCommand.getLineItemCommands() != null && productCommand.getLineItemCommands().size() > 0){
            productCommand.getLineItemCommands()
                    .forEach(lineItem -> product.getLineItems().add(lineItemCommandToLineItem.convert(lineItem)));
        }
        return product;
    }
}
