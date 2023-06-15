package com.spring.cqrs.query.projection;

import com.spring.cqrs.command.data.Producto;
import com.spring.cqrs.command.model.ProductoRestModel;
import com.spring.cqrs.command.repository.ProductoRepository;
import com.spring.cqrs.query.queries.GetProductoQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoProjection {

    @Autowired
    private ProductoRepository productoRepository;

    @QueryHandler
    public List<ProductoRestModel> handle(GetProductoQuery getProductoQuery){
        List<Producto> productos = productoRepository.findAll();
        List<ProductoRestModel> productoRestModels = productos.stream()
                .map(producto -> ProductoRestModel
                        .builder()
                        .cantidad(producto.getCantidad())
                        .precio(producto.getPrecio())
                        .nombre(producto.getNombre())
                        .build()
                ).collect(Collectors.toList());
        return productoRestModels;
    }

}
