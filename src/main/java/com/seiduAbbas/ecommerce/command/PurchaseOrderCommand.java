package com.seiduAbbas.ecommerce.command;

import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.LineItem;
import com.seiduAbbas.ecommerce.domain.ShippingSlip;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
public class PurchaseOrderCommand {

    private Long id;
    private Long customerId;
    private Long lineItemId;
    private Customer customer;
    private BigDecimal totalCost;
    private boolean membershipRequest;
    private ShippingSlip shippingSlip;
    private List<LineItemCommand> lineItems;
        }
