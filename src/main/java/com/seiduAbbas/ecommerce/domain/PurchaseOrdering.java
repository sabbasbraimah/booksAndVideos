package com.seiduAbbas.ecommerce.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "purchaser_order")
@Entity
public class PurchaseOrdering implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private BigDecimal totalCost;
    private boolean membershipRequest;
    private Long lineItemId;
    private Customer customer;

    @OneToOne
    private ShippingSlip shippingSlip;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrdering")
    private List<LineItem> lineItems = new ArrayList<>();


    public PurchaseOrdering addLineItem(LineItem lineItem){
        if (lineItem == null){
            throw new RuntimeException("Line Item is null");
        }
        lineItem.setPurchaseOrdering(this);
        this.lineItems.add(lineItem);
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrdering that = (PurchaseOrdering) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setCustomer(Customer customer) {
    }
}

