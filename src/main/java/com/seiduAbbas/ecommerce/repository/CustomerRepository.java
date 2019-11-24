package com.seiduAbbas.ecommerce.repository;

import com.seiduAbbas.ecommerce.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {  }
