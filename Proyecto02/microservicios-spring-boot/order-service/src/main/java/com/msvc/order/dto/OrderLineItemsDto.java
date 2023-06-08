package com.msvc.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {

    private Long id;
    private String codigoSku;
    private BigDecimal precio;
    private Integer cantidad;

}
