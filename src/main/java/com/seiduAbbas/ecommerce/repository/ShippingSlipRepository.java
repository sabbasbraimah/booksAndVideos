package com.seiduAbbas.ecommerce.repository;

import com.seiduAbbas.ecommerce.domain.ShippingSlip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingSlipRepository  extends CrudRepository<ShippingSlip, Long> {
}
