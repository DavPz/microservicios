package com.banco.electronico.commonapi.events;

import com.banco.electronico.commonapi.enums.AccountStatus;
import lombok.Getter;

public class AccountCreatedEvent  extends BaseEvent <String>{

    @Getter
    private String currency;

    @Getter
    private Double balance;

    @Getter
    private AccountStatus status;

    public AccountCreatedEvent(String id, String currency, Double balance, AccountStatus status) {
        super(id);
        this.currency = currency;
        this.balance = balance;
        this.status = status;
    }
}
