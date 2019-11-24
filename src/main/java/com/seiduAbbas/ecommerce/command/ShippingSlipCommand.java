package com.seiduAbbas.ecommerce.command;

import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
public class ShippingSlipCommand {

    private Long id;
    private LocalDate dateCreated ;
    private LocalDate timeCreated ;
    private Long customerId;
    private  Long purchaseOrderId;
    private String homeAddress;
    private int itemsOrdered ;
    private PurchaseOrdering itemsIncluded;
    private int quantityOfItems;
    private String shippingSlipUrl;
}
