package com.seiduAbbas.ecommerce.controllers;

import com.seiduAbbas.ecommerce.command.LineItemCommand;

import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.converter.LineItemCommandToLineItem;
import com.seiduAbbas.ecommerce.service.LineItemService;
import com.seiduAbbas.ecommerce.service.ProductService;
import com.seiduAbbas.ecommerce.service.PurchaseOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LineItemController {

    private final LineItemService lineItemService;
    private final ProductService productService;
    private final LineItemCommandToLineItem lineItemCommandToLineItem;
    private  final PurchaseOrderService purchaseOrderService;

    public LineItemController(LineItemService lineItemService, ProductService productService, LineItemCommandToLineItem lineItemCommandToLineItem, PurchaseOrderService purchaseOrderService) {
        this.lineItemService = lineItemService;
        this.productService = productService;
        this.lineItemCommandToLineItem = lineItemCommandToLineItem;
        this.purchaseOrderService = purchaseOrderService;
    }


    //Start from here tomorrow********************************
    @RequestMapping("product/{productId}/lineItem/{id}/show")
    public String showById(@PathVariable String productId, @PathVariable String id,  Model model) {
        model.addAttribute("lineItem",
                lineItemService.findByProductIdAndLineItemId(Long.valueOf(productId),Long.valueOf(id)) );
        return "product/lineItem/show";
    }

    @RequestMapping(value="/product/{productId}/lineItems", method = RequestMethod.GET)
    public String getLineItems(@PathVariable String productId, Model model){
        model.addAttribute("productCommand", productService.findById(Long.valueOf(productId)));
        return "product/lineItem/lineItems";
    }

    @RequestMapping("product/{productId}/lineItem/new")
    public String newLineItem(@PathVariable String productId, Model model){
        ProductCommand productCommand = productService.findCommandById( Long.valueOf(productId));

        LineItemCommand lineItemCommand = new LineItemCommand();
        lineItemCommand.setProductId(Long.valueOf(productId));
        model.addAttribute("lineItemCommand", lineItemCommand);
        model.addAttribute("lineItem", lineItemCommandToLineItem.convert(lineItemCommand));
        return "product/lineItem/form";
    }

    @GetMapping
    @RequestMapping("product/lineItem/{id}/update")
    public String updateProductLineItem(@PathVariable String productId,
                                         @PathVariable String id, Model model){
        model.addAttribute("lineItem", lineItemService.findByProductIdAndLineItemId(Long.valueOf(productId), Long.valueOf(id)));
        return "product/lineItem/form";
    }

    @PostMapping("product/{productId}/lineItem")
    public String saveOrUpdate(@ModelAttribute LineItemCommand lineItemCommand, @PathVariable String productId){
        LineItemCommand savedLineItemCommand = lineItemService.saveLineItemCommand(lineItemCommand);
        return "redirect:/product/" + savedLineItemCommand.getProductId() + "/lineItem/" + savedLineItemCommand.getId() + "/show" ;
    }

}
