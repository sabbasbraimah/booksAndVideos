package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.CustomerCommand;
import com.seiduAbbas.ecommerce.domain.Customer;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerCommand implements Converter<Customer, CustomerCommand> {

    private final PurchaseOrderingToPurchaseOrderingCommand purchaseOrderingToPurchaseOrderingCommand;
    private final AccountToAccountCommand accountToAccountCommand;
    public CustomerToCustomerCommand(PurchaseOrderingToPurchaseOrderingCommand purchaseOrderingToPurchaseOrderingCommand, AccountToAccountCommand accountToAccountCommand){
        this.purchaseOrderingToPurchaseOrderingCommand = purchaseOrderingToPurchaseOrderingCommand;
        this.accountToAccountCommand = accountToAccountCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public CustomerCommand convert(Customer customer) {
        if (customer == null) {
            return null;
        }
        final CustomerCommand customerCommand = new CustomerCommand();
        customerCommand.setId(customer.getId());
        customerCommand.setFirstName(customer.getFirstName());
        customerCommand.setLastName(customer.getLastName());
        customerCommand.setAddressLine1(customer.getAddressLine1());
        customerCommand.setAddressLine2(customer.getAddressLine2());
        customerCommand.setCity(customer.getCity());
        customerCommand.setPostCode(customer.getPostCode());
        customerCommand.setEmail(customer.getEmail());
        customerCommand.setAccountCommand(accountToAccountCommand.convert(customer.getAccount()));

        if (customer.getPurchaseOrderings() != null && customer.getPurchaseOrderings().size() > 0){
            customer.getPurchaseOrderings()
                    .forEach(purchaseOrdering -> customerCommand.getPurchaseOrderCommands()
                            .add(purchaseOrderingToPurchaseOrderingCommand.convert(purchaseOrdering)));
        }

        return customerCommand;
    }
}

