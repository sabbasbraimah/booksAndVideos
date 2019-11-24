package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.LineItemCommand;
import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import com.seiduAbbas.ecommerce.repository.CustomerRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseOrderingToPurchaseOrderingCommand implements Converter<PurchaseOrdering, PurchaseOrderCommand> {

    private final LineItemToLineItemCommand lineItemToLineItemCommand;
    private final CustomerRepository customerRepository;

    public PurchaseOrderingToPurchaseOrderingCommand(LineItemToLineItemCommand lineItemToLineItemCommand, CustomerRepository customerRepository) {
        this.lineItemToLineItemCommand = lineItemToLineItemCommand;
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseOrderCommand convert(PurchaseOrdering purchaseOrdering) {

        if (purchaseOrdering == null) {
            throw new RuntimeException(null + " PurchaseOrdering");
        }
        PurchaseOrderCommand purchaseOrderCommand = new PurchaseOrderCommand();
        purchaseOrderCommand.setId(purchaseOrdering.getId());
        if (purchaseOrdering.getCustomer() != null) {
            purchaseOrderCommand.setCustomerId(purchaseOrdering.getCustomer().getId());
        }

        List<LineItemCommand> lineItemList = new ArrayList<>();
        purchaseOrderCommand.setLineItems(lineItemList);

        if (purchaseOrdering.getLineItems() != null && purchaseOrdering.getLineItems().size() > 0) {
            purchaseOrdering.getLineItems().forEach(lineItem -> purchaseOrderCommand.getLineItems()
                    .add(lineItemToLineItemCommand.convert(lineItem)));
        }
            return purchaseOrderCommand;
        }
    }

