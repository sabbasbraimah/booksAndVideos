package com.seiduAbbas.ecommerce.converter;

import com.seiduAbbas.ecommerce.command.AccountCommand;
import com.seiduAbbas.ecommerce.domain.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountCommand implements Converter<Account,AccountCommand > {
    @Override
    public AccountCommand convert(Account account ){

        if(account == null ) {
            return null;
        }
        AccountCommand accountCommand = new AccountCommand();
        accountCommand.setId(account.getId());
        accountCommand.setMember(account.isMember());
        accountCommand.setDateCreated(account.getDateCreated());
        accountCommand.setPassword(account.getPassword());
        accountCommand.setRepeatPassword(account.getRepeatPassword());
        accountCommand.setEmail(account.getEmail());
        return accountCommand;
    }
}
