package com.seiduAbbas.ecommerce.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShippingSlip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateCreated = LocalDate.now();
    private LocalDate timeCreated = LocalDate.now();
    private Long customerId;
    private Long purchaseOrderId;
    private String homeAddress;
    private int itemsOrdered ;
    private PurchaseOrdering itemsIncluded;
    private int quantityOfItems;
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingSlip that = (ShippingSlip) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
