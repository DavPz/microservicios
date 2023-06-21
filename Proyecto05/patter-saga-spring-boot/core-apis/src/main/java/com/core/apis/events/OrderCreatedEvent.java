package com.core.apis.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderCreatedEvent {

    private String orderId;

    private String itemType;

    private BigDecimal price;

    private String currency;

    private String orderStatus;

}
