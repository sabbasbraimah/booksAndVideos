package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.command.ProductCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.Product;

import java.util.Set;

public interface ProductService {

    Set<Product> getProducts();

    Product findById(Long l);

    ProductCommand findCommandById(Long l);

    ProductCommand saveProductCommand(ProductCommand command);
}

