package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.LineItem;

import java.util.Set;

public interface LineItemService {

    //Set<LineItem> getAllLineItems();
    //LineItemCommand findCommandById(Long l);
    LineItemCommand saveLineItemCommand(LineItemCommand lineItemCommand);
    LineItemCommand findByProductIdAndLineItemId(Long productId, Long lineItemId);
}
