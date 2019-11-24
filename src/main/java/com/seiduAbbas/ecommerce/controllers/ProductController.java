package com.seiduAbbas.ecommerce.controllers;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.exception.ProductNotFoundException;
import com.seiduAbbas.ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @RequestMapping("/product/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.findById(Long.valueOf(id)));
        return "product/show";
    }
    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String getProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "product/products";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new ProductCommand());
        return "product/form";
    }

    @GetMapping
    @RequestMapping("product/{productId}/new")
    public String newCustomerViaProduct( @PathVariable String productId, Model model){
        Product product =  productService.findById(Long.valueOf(productId));
        CustomerCommand customerCommand = new CustomerCommand() ;
        customerCommand.setProductId(Long.valueOf(productId));
        model.addAttribute("customer", customerCommand);
        return "customer/customerform";
    }


    @PostMapping("product")
    public String saveOrUpdate(@ModelAttribute ProductCommand  productCommand ){
        ProductCommand   savedProductDTO    = productService.saveProductCommand(productCommand);
        return "redirect:/product/show/" + savedProductDTO.getId();
    }


}