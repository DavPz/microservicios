package com.spring.cqrs.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductoCommand {

    @TargetAggregateIdentifier
    private String idProducto;

    private String nombre;

    private BigDecimal precio;

    private Integer cantidad;

}
