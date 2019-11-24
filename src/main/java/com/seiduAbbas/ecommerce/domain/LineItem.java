package com.seiduAbbas.ecommerce.domain;

import com.seiduAbbas.ecommerce.enums.MembershipType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class LineItem  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private Product product;
    @Enumerated(value = EnumType.STRING)
    private MembershipType membershipType;
    @ManyToOne
    @JoinColumn(name = "puchase_ordering_id")
    private PurchaseOrdering purchaseOrdering;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return id.equals(lineItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
