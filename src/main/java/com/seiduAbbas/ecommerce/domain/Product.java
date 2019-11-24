package com.seiduAbbas.ecommerce.domain;


import com.seiduAbbas.ecommerce.enums.ProductState;
import com.seiduAbbas.ecommerce.enums.ProductType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;
    @Enumerated(value = EnumType.STRING)
    private ProductState productState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<LineItem> lineItems = new HashSet<>();


    public Product addLineItem(LineItem lineItem){
        if (lineItem == null){
            throw new RuntimeException("Line Item is null");
        }
        lineItem.setProduct(this);
        this.lineItems.add(lineItem);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
