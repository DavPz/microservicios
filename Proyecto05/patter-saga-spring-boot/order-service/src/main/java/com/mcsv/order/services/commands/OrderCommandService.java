package com.mcsv.order.services.commands;

import com.mcsv.order.dtos.commands.OrderCreateDTO;

import java.util.concurrent.CompletableFuture;

public interface OrderCommandService {

    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreatedDTO);
}
