package com.msvc.inventario;

import com.msvc.inventario.model.Inventario;
import com.msvc.inventario.repository.InventarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventarioRepository inventarioRepository){
		return args -> {
			Inventario inventario = new Inventario();
			inventario.setCodigoSku("iphone_12");
			inventario.setCantidad(20);
			inventarioRepository.save(inventario);

			inventario = new Inventario();
			inventario.setCodigoSku("iphone_13_PRO");
			inventario.setCantidad(50);
			inventarioRepository.save(inventario);

		};
	}

}
