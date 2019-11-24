package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.domain.Product;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand> {

    private final LineItemToLineItemCommand lineItemToLineItemCommand;

    public ProductToProductCommand(LineItemToLineItemCommand lineItemToLineItemCommand) {
        this.lineItemToLineItemCommand = lineItemToLineItemCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public ProductCommand convert(Product product) {
        if (product == null) {
            return null;
        }
        final ProductCommand productCommand = new ProductCommand();
        productCommand.setId(product.getId());
        productCommand.setName(product.getName());
        productCommand.setProductType(product.getProductType());
        productCommand.setProductState(product.getProductState());
        productCommand.setPrice(product.getPrice());

        if (product.getLineItems() != null && product.getLineItems().size() > 0){
            product.getLineItems().stream().forEach(lineItem ->
                    productCommand.getLineItemCommands().add(lineItemToLineItemCommand.convert(lineItem)));
        }
        return productCommand;
    }
}