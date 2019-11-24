package com.seiduAbbas.ecommerce.domain;


import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer   implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String province;
    private String email;
    private  String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Set<PurchaseOrdering> purchaseOrderings = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Set<ShippingSlip> shippingSlips = new HashSet<>();

    public Customer(String kofi, String s, String london, String s1, String s2) {
    }

    public Customer addPurchaseOrder(PurchaseOrdering purchaseOrder){
        purchaseOrder.setCustomer(this);
        this.purchaseOrderings.add(purchaseOrder);
        return this;
    }

    public Customer addShippingSlip(ShippingSlip shippingSlip){
        shippingSlip.setCustomer(this);
        this.shippingSlips.add(shippingSlip);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }

}



