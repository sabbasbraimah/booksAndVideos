package com.seiduAbbas.ecommerce.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
public class AccountCommand {

    private Long id;
    private Long customerId;
    private String email;
    private String password;
    private String repeatPassword;
    private boolean member;
    private LocalDateTime dateCreated;
}
