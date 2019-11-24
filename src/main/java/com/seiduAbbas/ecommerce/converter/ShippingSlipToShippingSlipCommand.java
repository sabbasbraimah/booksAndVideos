package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.ShippingSlipCommand;
import com.seiduAbbas.ecommerce.domain.ShippingSlip;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShippingSlipToShippingSlipCommand implements Converter<ShippingSlip, ShippingSlipCommand> {

    @Override
    public ShippingSlipCommand convert(ShippingSlip shippingSlip) {
        if (shippingSlip == null){
            return null;
        }
        ShippingSlipCommand shippingSlipCommand = new ShippingSlipCommand();
        shippingSlipCommand.setId(shippingSlip.getId());
        shippingSlipCommand.setItemsOrdered(shippingSlip.getItemsOrdered());
        shippingSlipCommand.setQuantityOfItems(shippingSlip.getQuantityOfItems());
        shippingSlipCommand.setCustomerId(shippingSlip.getCustomerId());
        shippingSlipCommand.setHomeAddress(shippingSlip.getHomeAddress());
        shippingSlipCommand.setTimeCreated(shippingSlipCommand.getTimeCreated());
        shippingSlipCommand.setItemsIncluded(shippingSlip.getItemsIncluded());
        return shippingSlipCommand;
    }
}
