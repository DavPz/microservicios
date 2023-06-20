package com.banco.electronico.commonapi.events;

import lombok.Getter;

public class AccountDebitEvent extends BaseEvent <String>{

    @Getter
    private String currency;

    @Getter
    private Double amount;

    public AccountDebitEvent(String id, String currency, Double amount) {
        super(id);
        this.currency = currency;
        this.amount = amount;
    }
}
