package com.spring.cqrs.command.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductoRestModel {

    private String idProducto;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;

}
