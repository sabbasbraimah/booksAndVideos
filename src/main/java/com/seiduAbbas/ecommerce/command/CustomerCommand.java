package com.seiduAbbas.ecommerce.command;

import com.seiduAbbas.ecommerce.domain.Account;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
public class CustomerCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String email;
    private Long accountId;
    private  Long productId;
    private AccountCommand accountCommand;
    private Set<PurchaseOrderCommand> purchaseOrderCommands = new HashSet<>();
    private Set<ShippingSlipCommand> shippingSlipCommands = new HashSet<>();
}
