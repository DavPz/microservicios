package com.spring.cqrs.command.repository;

import com.spring.cqrs.command.data.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,String> {
}
