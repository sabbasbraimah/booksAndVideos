package com.seiduAbbas.ecommerce.repository;

import com.seiduAbbas.ecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
