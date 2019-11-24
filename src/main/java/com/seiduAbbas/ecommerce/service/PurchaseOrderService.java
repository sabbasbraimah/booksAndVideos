package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.domain.Account;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;

import java.util.Set;

public interface PurchaseOrderService  {

   // Set<PurchaseOrdering> getAllPurchaseOrdering();

   // PurchaseOrderCommand findPurchaseOrderingById(Long id) ;

    PurchaseOrderCommand findByCustomerIdAndPurchaseOrderId(Long customerId, Long purchaseOrderId);

    PurchaseOrderCommand savePurchaseOrderingCommand(PurchaseOrderCommand purchaseOrderCommand);


}
