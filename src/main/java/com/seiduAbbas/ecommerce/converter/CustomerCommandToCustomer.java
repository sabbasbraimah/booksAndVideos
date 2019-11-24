package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.domain.Account;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomerCommandToCustomer implements Converter<CustomerCommand, Customer> {

    private  final PurchaseOrderingCommandToPurchaseOrdering  purchaseOrderingCommandToPurchaseOrdering;
    private  final AccountCommandToAccount accountCommandToCustomer;
    public CustomerCommandToCustomer(PurchaseOrderingCommandToPurchaseOrdering purchaseOrderingCommandToPurchaseOrdering, AccountCommandToAccount accountCommandToCustomer) {
        this.purchaseOrderingCommandToPurchaseOrdering = purchaseOrderingCommandToPurchaseOrdering;
        this.accountCommandToCustomer = accountCommandToCustomer;
    }

    @Synchronized
    @Nullable
    @Override
    public Customer convert(CustomerCommand command) {
        if ( command == null)
            return  null;
        Customer customer = new Customer();
        customer.setId(command.getId());
        customer.setFirstName(command.getFirstName());
        customer.setLastName(command.getLastName());
        customer.setAddressLine1(command.getAddressLine1());
        customer.setAddressLine2(command.getAddressLine2());
        customer.setCity(command.getCity());
        customer.setPostCode(command.getPostCode());
        customer.setEmail(command.getEmail());
        customer.setAccount(accountCommandToCustomer.convert(command.getAccountCommand()));

        if (command.getPurchaseOrderCommands() != null && command.getPurchaseOrderCommands().size() > 0){
            command.getPurchaseOrderCommands()
                    .forEach(purchaseOrderCommand -> customer.getPurchaseOrderings()
                            .add(purchaseOrderingCommandToPurchaseOrdering.convert(purchaseOrderCommand)));
        }
        return customer;
    }
}