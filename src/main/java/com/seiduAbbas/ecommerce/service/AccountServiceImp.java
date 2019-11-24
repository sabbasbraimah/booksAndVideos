package com.seiduAbbas.ecommerce.service;

import com.seiduAbbas.ecommerce.command.AccountCommand;
import com.seiduAbbas.ecommerce.command.PurchaseOrderCommand;
import com.seiduAbbas.ecommerce.converter.AccountCommandToAccount;
import com.seiduAbbas.ecommerce.converter.AccountToAccountCommand;
import com.seiduAbbas.ecommerce.domain.Account;
import com.seiduAbbas.ecommerce.domain.Customer;
import com.seiduAbbas.ecommerce.repository.AccountRepository;
import com.seiduAbbas.ecommerce.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class AccountServiceImp  implements AccountService{

    private final AccountToAccountCommand accountToAccountCommand;
    private  final AccountCommandToAccount  accountCommandToAccount;
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImp(AccountToAccountCommand accountToAccountCommand,
                             AccountCommandToAccount accountCommandToAccount,
                             AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountToAccountCommand = accountToAccountCommand;
        this.accountCommandToAccount = accountCommandToAccount;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }
    @Override
    public Set<Account> getAllAccounts() {
        log.debug("Getting all Accounts from the database");
        Set<Account> accountSet = new HashSet<>();
        accountRepository.findAll().iterator().forEachRemaining(accountSet::add);
        log.debug("Converting Account objects to AccountDTOn objects");
        return accountSet;
    }

    @Override
    public AccountCommand findAccountByCustomerIdAndAccountId(Long customerId, Long accountId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (!customerOptional.isPresent()) {
            throw new RuntimeException("Customer Not Found!");
        }
        Customer customer = customerOptional.get();
        AccountCommand accountCommand = null;
                if(customer.getAccount() != null &&  customer.getAccount() .getId() == accountId) {
                    accountCommand = accountToAccountCommand.convert(customer.getAccount());
                }
                else {
                    Account account = new Account();
                    customer.setAccount(account);
                    accountCommand = accountToAccountCommand.convert(customer.getAccount());
                }
        if( accountCommand == null){
            log.error(" Could not find Account : " + accountCommand);
            throw new RuntimeException("Purchase Order Not Found!");
        }
        return accountCommand;
    }
/**

    @Override
    public AccountCommand createNewAccount(AccountCommand accountCommand) {
        Account account = accountCommandToAccount.convert(accountCommand);
        Account savedAccount = accountRepository.save(account);
        AccountCommand returnCommand = accountToAccountCommand.convert(savedAccount);
        return returnCommand;
    }
    **/
}
