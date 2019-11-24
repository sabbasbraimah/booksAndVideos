package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import java.util.Set;

public interface CustomerService {

    Set<Customer> getCustomers();

    Customer findById(Long id) ;

    CustomerCommand findCommandById(Long l);

    CustomerCommand saveCustomerCommand(CustomerCommand customerCommand);
}