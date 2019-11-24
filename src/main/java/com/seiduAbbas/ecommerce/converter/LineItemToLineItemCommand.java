package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LineItemToLineItemCommand implements Converter<LineItem, LineItemCommand> {

    @Synchronized
    @Nullable
    @Override
    public LineItemCommand convert(LineItem lineItem) {
        if (lineItem == null) {
            return null;
        }
        final LineItemCommand lineItemCommand = new LineItemCommand();
        lineItemCommand.setId(lineItem.getId());
        lineItemCommand.setQuantity(lineItem.getQuantity());
        lineItemCommand.setMembershipType(lineItem.getMembershipType());
        return lineItemCommand;
    }
}