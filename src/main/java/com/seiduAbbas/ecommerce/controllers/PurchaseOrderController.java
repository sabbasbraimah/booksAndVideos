package com.seiduAbbas.ecommerce.controllers;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.converter.PurchaseOrderingCommandToPurchaseOrdering;
import com.seiduAbbas.ecommerce.service.CustomerService;
import com.seiduAbbas.ecommerce.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;
    private  final CustomerService customerService;
    private final PurchaseOrderingCommandToPurchaseOrdering  purchasPurchaseOrderingCommandToPurchaseOrdering;




    public PurchaseOrderController(PurchaseOrderService purchaseOrderService,
                                   CustomerService customerService, PurchaseOrderingCommandToPurchaseOrdering purchasPurchaseOrderingCommandToPurchaseOrdering) {
        this.purchaseOrderService = purchaseOrderService;
        this.customerService = customerService;

        this.purchasPurchaseOrderingCommandToPurchaseOrdering = purchasPurchaseOrderingCommandToPurchaseOrdering;
    }


    @GetMapping
    @RequestMapping("customer/{customerId}/purchaseOrder/{id}/show"  )
    public String showPurchaseOrder(@PathVariable String customerId, @PathVariable String id, Model model)  {
        model.addAttribute("purchaseOrdering", purchaseOrderService.findByCustomerIdAndPurchaseOrderId(Long.valueOf(customerId),
                Long.valueOf(id)) );
        return "customer/purchaseOrder/show";
    }

    @GetMapping
    @RequestMapping(value="customer/{customerId}/purchaseOrders")
    public String getPurchaseOrders ( @PathVariable String customerId,  ModelMap model){
        model.addAttribute("customers", customerService.findCommandById(Long.valueOf(customerId)));
        return "customer/purchaseOrder/purchaseorders";
    }

    @GetMapping
    @RequestMapping("customer{customerId}/purchaseOrder/new")
    public String newPurchaseOrder( @PathVariable String customerId, Model model){
        CustomerCommand customerCommand = customerService.findCommandById(Long.valueOf(customerId)) ;
        if (customerCommand == null ){
            return null;
        }
       //need to return back parent id for hidden form property
       PurchaseOrderCommand purchaseOrderCommand = new PurchaseOrderCommand();
       purchaseOrderCommand.setCustomerId(customerCommand.getId());
       model.addAttribute("purchaseOrderCommand", purchaseOrderCommand);

       return "customer/purchaseOrder/form";
    }

    @PostMapping("customer/{customerId}/purchaseOrder")
    public String saveOrUpdate( @PathVariable String customerId,   @ModelAttribute PurchaseOrderCommand  purchaseOrderCommand ){
        PurchaseOrderCommand   savedPurchaseOrderCommand    = purchaseOrderService.savePurchaseOrderingCommand(purchaseOrderCommand);
        return "redirect:/customer/" + customerId +"/purchaseOrder/" + savedPurchaseOrderCommand.getId() + "/show" ;

    }

}

