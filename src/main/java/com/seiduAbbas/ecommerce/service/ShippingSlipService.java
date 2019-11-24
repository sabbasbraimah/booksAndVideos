package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.ShippingSlipCommand;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import com.seiduAbbas.ecommerce.domain.ShippingSlip;

import java.util.Set;

public interface ShippingSlipService {

    Set<ShippingSlip> getAllShippingSlips();

  //  ShippingSlip findShippingSlipById(Long id) ;

  //  ShippingSlip getShippingSlipByCustomerIdAndPurchaseOrderIdAbdShippingSlipIdId(Long customerId,
                                                   //     Long purchaseOrderId, Long shippingSlipId) ;                                                                       ;

   // ShippingSlipCommand createNewShippingSlip(ShippingSlipCommand shippingSlipCommand);

}
