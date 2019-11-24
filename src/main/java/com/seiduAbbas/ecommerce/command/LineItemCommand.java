package com.seiduAbbas.ecommerce.command;

import com.seiduAbbas.ecommerce.domain.Product;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import com.seiduAbbas.ecommerce.enums.MembershipType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class LineItemCommand {

    private Long id;
    private Long productId;
    private Long lineItemId;
    private Long purchaseOrderingId;
    private PurchaseOrdering purchaseOrdering;
    private int quantity;
    private MembershipType  membershipType;
}
