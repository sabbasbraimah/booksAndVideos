package com.seiduAbbas.ecommerce.repository;

import com.seiduAbbas.ecommerce.domain.LineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends CrudRepository<LineItem, Long> {
}
