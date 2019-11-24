package com.seiduAbbas.ecommerce.repository;

import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrdering, Long> {
}
