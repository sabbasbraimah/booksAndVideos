package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.AccountCommand;
import com.seiduAbbas.ecommerce.domain.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class AccountCommandToAccount implements Converter<AccountCommand, Account> {
    @Override
    public Account convert(AccountCommand accountCommand) {

        if(accountCommand == null ) {
            return null;
        }
        Account account = new Account();
        account.setId(accountCommand.getId());
        account.setMember(accountCommand.isMember());
        account.setDateCreated(accountCommand.getDateCreated());
        account.setPassword(accountCommand.getPassword());
        account.setRepeatPassword(accountCommand.getRepeatPassword());
        account.setEmail(accountCommand.getEmail());
        return account;
    }
}
