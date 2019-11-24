package com.seiduAbbas.ecommerce.controllers;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @RequestMapping("/customer/show/{id}")
    public String showById(@PathVariable String id, Model model)  {
        model.addAttribute("customer", customerService.findById(Long.valueOf(id)));
        return "customer/show";
    }

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public String getCustomers(Model model){
        model.addAttribute("customers", customerService.getCustomers());
        return "/customer/customerList";
    }

    @GetMapping
    @RequestMapping("customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new CustomerCommand());
        return "customer/customerform";
    }



    @GetMapping
    @RequestMapping("customer/{id}/update")
    public String updateCustomer(@PathVariable String id, Model model){
        model.addAttribute("customer",customerService.findCommandById(Long.valueOf(id)));
        return  "customerform";
    }

    @PostMapping("customer")
    public String saveOrUpdate(@ModelAttribute CustomerCommand customerCommand ){
        CustomerCommand savedCustomerCommand    = customerService.saveCustomerCommand(customerCommand);
        return "redirect:/customer/show/"+ savedCustomerCommand.getId() ;
    }

}


