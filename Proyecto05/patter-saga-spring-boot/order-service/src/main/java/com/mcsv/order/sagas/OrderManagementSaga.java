package com.mcsv.order.sagas;

import com.core.apis.commands.CreateInvoiceCommand;
import com.core.apis.commands.CreateShippingCommand;
import com.core.apis.commands.UpdateOrderStatusCommand;
import com.core.apis.events.InvoiceCreatedEvent;
import com.core.apis.events.OrderCreatedEvent;
import com.core.apis.events.OrderShippedEvent;
import com.core.apis.events.OrderUpdateEvent;
import com.mcsv.order.aggregates.OrderStatus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
public class OrderManagementSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        String paymentId = UUID.randomUUID().toString();
        System.out.println("SAGA Invocado");

        //Asociamos la SAGA
        SagaLifecycle.associateWith("paymentId", paymentId);

        System.out.println("Order ID: " + orderCreatedEvent.getOrderId());

        //Enviamos los comandos
        commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.getOrderId()));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
        String shippingId = UUID.randomUUID().toString();

        System.out.println("SOGA continuacion");

        //Asociamos la saga con el Shipping
        SagaLifecycle.associateWith("shipping", shippingId);

        //Enviamos el comando de Shipping
        commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.getOrderId(), invoiceCreatedEvent.getPaymentId()));

    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderShippedEvent orderShippedEvent) {
        commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.getOrderId(), String.valueOf(OrderStatus.SHIPPED)));

    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderUpdateEvent orderUpdateEvent) {
        SagaLifecycle.end();
    }

}
