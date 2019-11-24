package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.AccountCommand;
import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.domain.Account;
import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;

import java.util.Set;

public interface AccountService {

    Set<Account> getAllAccounts();

    AccountCommand findAccountByCustomerIdAndAccountId(Long customerId, Long accountId);

   // AccountCommand createNewAccount(AccountCommand accountCommand);

}





