package com.spring.cqrs.command.aggregate;

import com.spring.cqrs.command.commands.CreateProductoCommand;
import com.spring.cqrs.command.events.ProductoCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Aggregate //Esto le dice que esta entidad es administrada por AXON
public class ProductoAggregate {

    @AggregateIdentifier
    private String idProducto;

    private String nombre;

    private BigDecimal precio;

    private Integer cantidad;

    @CommandHandler
    public ProductoAggregate(CreateProductoCommand createProductoCommand){
        ProductoCreatedEvent productoCreatedEvent =
                ProductoCreatedEvent
                        .builder()
                        .build();

        BeanUtils.copyProperties(createProductoCommand,productoCreatedEvent);
        AggregateLifecycle.apply(productoCreatedEvent); //Registramos Eventos

    }

    @EventSourcingHandler //Creaomos el evento
    public void on(ProductoCreatedEvent productoCreatedEvent){
        this.cantidad = productoCreatedEvent.getCantidad();
        this.idProducto = productoCreatedEvent.getIdProducto();
        this.precio = productoCreatedEvent.getPrecio();
        this.nombre = productoCreatedEvent.getNombre();
    }

}
