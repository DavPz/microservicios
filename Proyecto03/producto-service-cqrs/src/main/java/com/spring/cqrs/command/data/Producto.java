package com.spring.cqrs.command.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Producto {

    @Id
    private String idProducto;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;

}
