package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.converter.CustomerCommandToCustomer;
import com.seiduAbbas.ecommerce.converter.CustomerToCustomerCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerCommandToCustomer customerCommandToCustomer;
   private final CustomerToCustomerCommand customerToCustomerCommand;
    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerCommandToCustomer customerCommandToCustomer,
                              CustomerToCustomerCommand customerToCustomerCommand,
                              CustomerRepository customerRepository) {
        this.customerCommandToCustomer = customerCommandToCustomer;
        this.customerToCustomerCommand = customerToCustomerCommand;
        this.customerRepository = customerRepository;
    }

    @Override
    public Set<Customer> getCustomers() {
        log.debug("Getting all customers from the database");
        Set<Customer> customerSet = new HashSet<>();
        customerRepository.findAll().iterator().forEachRemaining(customerSet::add);
        log.debug("Converting Customer objects to CustomerDTOn objects");
        return customerSet;
    }
    @Override
    public Customer findById(Long id)  {
        Optional<Customer> optionalCustomer =  customerRepository.findById(id);
        if (!optionalCustomer.isPresent()){
           throw new RuntimeException("Cannot find id :" + id);
        }
        return optionalCustomer.get();
    }

    @Override
    public CustomerCommand findCommandById(Long l) {
        return null;
    }

    @Override
    @Transactional
    public CustomerCommand saveCustomerCommand(CustomerCommand customerCommand) {
        Customer customer = customerCommandToCustomer.convert(customerCommand);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerCommand returnCommand =customerToCustomerCommand.convert(savedCustomer);
        return returnCommand;
    }

    /**
    @Override
    public CustomerCommand findCommandById(Long l) {
        return customerToCustomerCommand.convert(findById(l));
    }

    @Override
    public CustomerCommand findCommandById(Long id){
        return   customerToCustomerCommand.convert(getCustomerById(id));
    }

**/


}