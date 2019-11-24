package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.converter.PurchaseOrderingCommandToPurchaseOrdering;
import com.seiduAbbas.ecommerce.converter.PurchaseOrderingToPurchaseOrderingCommand;
import com.seiduAbbas.ecommerce.domain.*;
import com.seiduAbbas.ecommerce.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
public class PurchaseOrderServiceImp implements PurchaseOrderService {

    private   final PurchaseOrderingToPurchaseOrderingCommand purchaseOrderingTo;
    private  final PurchaseOrderingCommandToPurchaseOrdering purchaseOrderingCommandTo;
    private final CustomerRepository  customerRepository;


    public PurchaseOrderServiceImp(PurchaseOrderingToPurchaseOrderingCommand purchaseOrderingTo,
                                   PurchaseOrderingCommandToPurchaseOrdering purchaseOrderingCommandTo,
                                   CustomerRepository customerRepository) {
        this.purchaseOrderingTo = purchaseOrderingTo;
        this.purchaseOrderingCommandTo = purchaseOrderingCommandTo;
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseOrderCommand findByCustomerIdAndPurchaseOrderId(Long customerId, Long purchaseOrderId) {
        Optional<Customer>  customerOptional =customerRepository.findById(customerId);
        if (!customerOptional.isPresent() ){
            throw new RuntimeException(" ");
        }
        Customer returnedCustomer = customerOptional.get();

        Optional<PurchaseOrderCommand>purchaseOrderCommand = returnedCustomer.getPurchaseOrderings()
                    .stream().filter(purchaseOrdering -> purchaseOrdering.getId().equals(purchaseOrderId))
                    .map(purchaseOrdering -> purchaseOrderingTo.convert(purchaseOrdering)).findFirst();

        if (!purchaseOrderCommand.isPresent()){
            throw new RuntimeException( purchaseOrderId +" for Purchase Order not found");
        }
        return  purchaseOrderCommand.get();
    }

    @Override
    @Transactional
    public PurchaseOrderCommand savePurchaseOrderingCommand(PurchaseOrderCommand purchaseOrderCommand) {
        Optional<Customer> customerOptional = customerRepository.findById(purchaseOrderCommand.getCustomerId());
        if (!customerOptional.isPresent()) {
            log.error("Customer not found for id: " +purchaseOrderCommand.getId() );
            return new PurchaseOrderCommand();
        }
        else {
            Customer customer = customerOptional.get();
            Optional<PurchaseOrdering> optionalPurchaseOrderCommand = customer.getPurchaseOrderings()
                    .stream().filter(purchaseOrdering -> purchaseOrdering.getId().equals(purchaseOrderCommand.getId())).findFirst();

            if (optionalPurchaseOrderCommand.isPresent()) {
            PurchaseOrdering purchaseOrdering = optionalPurchaseOrderCommand.get();

            purchaseOrdering.setTotalCost(purchaseOrderCommand.getTotalCost());
            purchaseOrdering.setLineItemId(purchaseOrderCommand.getLineItemId());
            purchaseOrdering.setMembershipRequest(purchaseOrderCommand.isMembershipRequest());

            ShippingSlip shippingSlip = new ShippingSlip();
            shippingSlip.setCustomerId(purchaseOrderCommand.getCustomerId());
            purchaseOrdering.setShippingSlip(shippingSlip);
            customer.addShippingSlip(shippingSlip);
            customer.addPurchaseOrder(purchaseOrdering);

            }
             else {
                //Use the purchaseOrderCommand sent from the form to create a new purchaseOrdering
                // and use it to set up a relationship with the customer now
                PurchaseOrdering purchaseOrdering = purchaseOrderingCommandTo.convert(purchaseOrderCommand);

                //set up the relationship with customer now
                purchaseOrdering.setCustomer(customer);
                purchaseOrdering.setCustomerId(purchaseOrderCommand.getCustomerId());
                // lineItem needs to be explicitly  set as it is a relational field not an inherent field of purchase order.
                purchaseOrdering.setLineItemId(purchaseOrderCommand.getLineItemId());
                customer.addPurchaseOrder(purchaseOrdering);
            }

             Customer savedCustomer = customerRepository.save(customer);
             Optional<PurchaseOrdering> savedPurchaseOrderOptional = savedCustomer.getPurchaseOrderings().stream()
                .filter(purchaseOrdering -> purchaseOrdering.getId().equals(purchaseOrderCommand.getId()))
                .findFirst();

             if (! savedPurchaseOrderOptional.isPresent()){
                 savedPurchaseOrderOptional = savedCustomer.getPurchaseOrderings().stream()
                        .filter(purchaseOrdering -> purchaseOrdering.getCustomerId().equals(purchaseOrderCommand.getCustomerId()))
                         .filter(purchaseOrdering -> purchaseOrdering.getLineItemId().equals(purchaseOrderCommand.getLineItemId()))
                         .filter(purchaseOrdering -> purchaseOrdering.getTotalCost().equals(purchaseOrderCommand.getTotalCost()))
                         .findFirst();
             }
        return   purchaseOrderingTo.convert(savedPurchaseOrderOptional.get());

    }
    }

}




