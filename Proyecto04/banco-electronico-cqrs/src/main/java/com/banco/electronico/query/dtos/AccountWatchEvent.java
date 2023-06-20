package com.banco.electronico.query.dtos;

import com.banco.electronico.commonapi.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountWatchEvent {

    private Instant instant;

    private String accountId;

    private Double currentBalance;

    private TransactionType type;

    private Double transactionAmount;

}
