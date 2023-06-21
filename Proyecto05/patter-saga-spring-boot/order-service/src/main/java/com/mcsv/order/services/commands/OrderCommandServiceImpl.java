package com.mcsv.order.services.commands;

import com.core.apis.commands.CreateOrderCommand;
import com.mcsv.order.aggregates.OrderStatus;
import com.mcsv.order.dtos.commands.OrderCreateDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderCommandServiceImpl implements OrderCommandService{

    @Autowired
    private CommandGateway commandGateway;


    @Override
    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreatedDTO) {
        return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(),orderCreatedDTO.getItemType(),
                orderCreatedDTO.getPrice(),orderCreatedDTO.getCurrency(), String.valueOf(OrderStatus.CREATED)));
    }
}
