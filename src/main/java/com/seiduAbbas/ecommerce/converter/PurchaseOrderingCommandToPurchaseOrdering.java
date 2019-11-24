package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderingCommandToPurchaseOrdering  implements Converter<PurchaseOrderCommand, PurchaseOrdering> {

    private  final  LineItemCommandToLineItem lineItemCommandToLineItem;

    public PurchaseOrderingCommandToPurchaseOrdering(LineItemCommandToLineItem lineItemCommandToLineItem) {
        this.lineItemCommandToLineItem = lineItemCommandToLineItem;
    }

    @Synchronized
    @Nullable
    @Override
    public PurchaseOrdering convert(PurchaseOrderCommand purchaseOrderCommand) {
        if (purchaseOrderCommand == null){
            return  null;
        }

        PurchaseOrdering purchaseOrdering = new PurchaseOrdering();
        purchaseOrdering.setId(purchaseOrderCommand.getId());
        purchaseOrdering.setTotalCost(purchaseOrderCommand.getTotalCost());

        if (purchaseOrderCommand.getLineItems()!= null && purchaseOrderCommand.getLineItems().size() > 0){
            purchaseOrderCommand.getLineItems().forEach(lineItemCommand -> purchaseOrdering.getLineItems()
                    .add(lineItemCommandToLineItem.convert(lineItemCommand)));
        }
        return purchaseOrdering;
    }
}
