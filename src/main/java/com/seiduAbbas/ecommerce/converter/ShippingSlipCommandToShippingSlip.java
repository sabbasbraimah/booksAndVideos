package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.ShippingSlipCommand;
import com.seiduAbbas.ecommerce.domain.ShippingSlip;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShippingSlipCommandToShippingSlip implements Converter<ShippingSlipCommand, ShippingSlip> {
    @Override
    public ShippingSlip convert(ShippingSlipCommand shippingSlipCommand) {
        if (shippingSlipCommand == null) {
            return null;
        }
        ShippingSlip shippingSlip = new ShippingSlip();
        shippingSlip.setId(shippingSlipCommand.getId());
        shippingSlip.setItemsOrdered(shippingSlipCommand.getItemsOrdered());
        shippingSlip.setQuantityOfItems(shippingSlipCommand.getQuantityOfItems());
        shippingSlip.setCustomerId(shippingSlipCommand.getCustomerId());
        shippingSlip.setHomeAddress(shippingSlipCommand.getHomeAddress());
        shippingSlip.setTimeCreated(shippingSlipCommand.getTimeCreated());
        shippingSlip.setItemsIncluded(shippingSlipCommand.getItemsIncluded());
        return shippingSlip;
    }
}
