package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.command.ShippingSlipCommand;
import com.seiduAbbas.ecommerce.converter.PurchaseOrderingToPurchaseOrderingCommand;
import com.seiduAbbas.ecommerce.converter.ShippingSlipCommandToShippingSlip;
import com.seiduAbbas.ecommerce.converter.ShippingSlipToShippingSlipCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import com.seiduAbbas.ecommerce.domain.ShippingSlip;
import com.seiduAbbas.ecommerce.repository.CustomerRepository;
import com.seiduAbbas.ecommerce.repository.PurchaseOrderRepository;
import com.seiduAbbas.ecommerce.repository.ShippingSlipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ShippingSlipServiceImp implements ShippingSlipService {

    private ShippingSlipRepository shippingSlipRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final CustomerRepository customerRepository;
    private final ShippingSlipCommandToShippingSlip shippingSlipCommandToShippingSlip;
    private  final ShippingSlipToShippingSlipCommand shippingSlipToShippingSlipCommand;
    private final PurchaseOrderingToPurchaseOrderingCommand purchaseOrderingToPurchaseOrderingCommand;

    public ShippingSlipServiceImp(ShippingSlipRepository shippingSlipRepository,
                                  PurchaseOrderRepository purchaseOrderRepository,
                                  CustomerRepository customerRepository,
                                  ShippingSlipCommandToShippingSlip shippingSlipCommandToShippingSlip,
                                  ShippingSlipToShippingSlipCommand shippingSlipToShippingSlipCommand,
                                  PurchaseOrderingToPurchaseOrderingCommand purchaseOrderingToPurchaseOrderingCommand) {
        this.shippingSlipRepository = shippingSlipRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.customerRepository = customerRepository;
        this.shippingSlipCommandToShippingSlip = shippingSlipCommandToShippingSlip;
        this.shippingSlipToShippingSlipCommand = shippingSlipToShippingSlipCommand;
        this.purchaseOrderingToPurchaseOrderingCommand = purchaseOrderingToPurchaseOrderingCommand;
    }
    @Override
    public Set<ShippingSlip> getAllShippingSlips() {
        log.debug("Getting all ShippingSlips from the database");
        Set<ShippingSlip> shippingSlipSet = new HashSet<>();
        shippingSlipRepository.findAll().iterator().forEachRemaining(shippingSlipSet::add);
        log.debug("Converting ShippingSlip objects to ShippingSlipDTOn objects");
        return shippingSlipSet;
    }
/**
    @Override
    public ShippingSlip findShippingSlipById(Long id) {
         Optional<ShippingSlip> shippingSlipOptional = shippingSlipRepository.findById(id);
        return shippingSlipOptional.orElseGet(()-> new ShippingSlip());
    }

    @Override
    public ShippingSlip getShippingSlipByCustomerIdAndPurchaseOrderIdAbdShippingSlipIdId(Long customerId,
                                                                                         Long purchaseOrderId, Long shippingSlipId)
    {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (!customerOptional.isPresent()) {
            throw new RuntimeException("Customer Not Found!");
        }
        Customer customer = customerOptional.get();
        Optional<PurchaseOrderCommand> purchaseOrderCommandOptional = customer.getPurchaseOrderings().stream()
                .filter(purchaseOrder -> purchaseOrder.getId().equals(purchaseOrderId))
                .map( purchaseOrder -> purchaseOrderingToPurchaseOrderingCommand.convert(purchaseOrder)).findFirst();

        if(!purchaseOrderCommandOptional.isPresent()){
            log.error(" Could not find Purchase Order id : " + purchaseOrderId);
            throw new RuntimeException("Purchase Order Not Found!");
        }
        PurchaseOrderCommand  purchaseOrdering = purchaseOrderCommandOptional.get();
        return purchaseOrdering.getShippingSlip();
    }

    @Override
    @Transactional
    public ShippingSlipCommand createNewShippingSlip(ShippingSlipCommand shippingSlipCommand) {
        ShippingSlip shippingSlip = shippingSlipCommandToShippingSlip.convert(shippingSlipCommand);
        ShippingSlip savedShippingSlip = shippingSlipRepository.save(shippingSlip);
        ShippingSlipCommand returnCommand = shippingSlipToShippingSlipCommand.convert(savedShippingSlip);
        return returnCommand;
    }

    **/
}
