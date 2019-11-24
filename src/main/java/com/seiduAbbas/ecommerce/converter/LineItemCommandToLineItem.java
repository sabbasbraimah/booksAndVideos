package com.seiduAbbas.ecommerce.converter;


import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LineItemCommandToLineItem implements Converter<LineItemCommand, LineItem> {

    @Synchronized
    @Nullable
    @Override
    public LineItem convert(LineItemCommand command) {
       if ( command == null){
           return null;
       }
      final  LineItem lineItem =  new LineItem();
       lineItem.setId(command.getId());
       lineItem.setQuantity(command.getQuantity());
       lineItem.setMembershipType(command.getMembershipType());
        return lineItem;
    }

}
