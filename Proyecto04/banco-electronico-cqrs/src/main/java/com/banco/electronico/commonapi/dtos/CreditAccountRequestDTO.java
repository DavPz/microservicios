package com.banco.electronico.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreditAccountRequestDTO {

    private String accountId;
    private String Currrency;
    private Double amount;

}
