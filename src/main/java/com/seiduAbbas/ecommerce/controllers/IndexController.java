package com.seiduAbbas.ecommerce.controllers;
import com.seiduAbbas.ecommerce.service.ProductService;
import com.seiduAbbas.ecommerce.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*
 */
@Slf4j
@Controller
public class IndexController {

    private final ProductService productService;

    public IndexController( ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"", "/", "/index","index.html"})
    public String getIndexPage(Model model) {
        log.debug("Getting Product Index page");
        model.addAttribute("products", productService.getProducts());
        return "index";
    }
}
