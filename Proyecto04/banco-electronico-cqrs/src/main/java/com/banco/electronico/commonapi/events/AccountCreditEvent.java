package com.banco.electronico.commonapi.events;

import com.banco.electronico.commonapi.enums.AccountStatus;
import com.banco.electronico.commonapi.enums.TransactionType;
import lombok.Getter;

public class AccountCreditEvent extends BaseEvent <String>{

    @Getter
    private String currency;

    @Getter
    private Double amount;

    public AccountCreditEvent(String id, String currency, Double amount) {
        super(id);
        this.currency = currency;
        this.amount = amount;
    }
}
