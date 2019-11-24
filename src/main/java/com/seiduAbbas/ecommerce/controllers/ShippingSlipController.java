package com.seiduAbbas.ecommerce.controllers;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.command.ShippingSlipCommand;
import com.seiduAbbas.ecommerce.converter.CustomerCommandToCustomer;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import com.seiduAbbas.ecommerce.service.CustomerService;
import com.seiduAbbas.ecommerce.service.PurchaseOrderService;
import com.seiduAbbas.ecommerce.service.ShippingSlipService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

public class ShippingSlipController {

    private final ShippingSlipService shippingSlipService;
    private final CustomerService customerService;
    private  final PurchaseOrderService purchaseOrderService;
    private final CustomerCommandToCustomer customerCommandToCustomer;

    public ShippingSlipController(ShippingSlipService shippingSlipService, CustomerService customerService,
                                  PurchaseOrderService purchaseOrderService,
                                  CustomerCommandToCustomer customerCommandToCustomer) {
        this.shippingSlipService = shippingSlipService;
        this.customerService = customerService;
        this.purchaseOrderService = purchaseOrderService;
        this.customerCommandToCustomer = customerCommandToCustomer;
    }


    @RequestMapping(value="customer/purchaseOrder//shippingSlips", method = RequestMethod.GET)
    public String getShippingSlips( Model model){
        model.addAttribute( "shippingSlips ", shippingSlipService.getAllShippingSlips() );
        return "customer/purchaseOrder/purchaseorders";
    }

/**
    @GetMapping
    @RequestMapping("customer/{customerId}/purchaseOrder/{purchaseOrderId}/{id}/show")
    public String showShippingSlip(@PathVariable String customerId, @PathVariable String  purchaseOrderId,
                                   @PathVariable String  id  ,Model model)  {

        model.addAttribute("shippingSlip",
                shippingSlipService
                        .getShippingSlipByCustomerIdAndPurchaseOrderIdAbdShippingSlipIdId( Long.valueOf(customerId),
                                Long.valueOf( purchaseOrderId ),  Long.valueOf(id) ) );
        return "customer/purchaseOrder/shippingSlip/show";
    }


    @RequestMapping("shippingSlip/new")
    public String newShippingSlip(Model model){
        model.addAttribute("shippingSlip", new ShippingSlipCommand());
        return " customer/purchaseOrder/shippingSlip/form";
    }
    @PostMapping("shippingSlip")
    public String saveOrUpdate(@ModelAttribute ShippingSlipCommand  ShippingSlipCommand ){
        ShippingSlipCommand   saveShippingSlipCommand    = shippingSlipService.createNewShippingSlip(ShippingSlipCommand);
        return "redirect:/customer/purchaseOrder/shippingSlip/show/" + saveShippingSlipCommand.getId();
    }
    **/
}
