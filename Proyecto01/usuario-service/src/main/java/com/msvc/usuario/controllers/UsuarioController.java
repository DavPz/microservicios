package com.msvc.usuario.controllers;


import com.msvc.usuario.entities.Calificacion;
import com.msvc.usuario.entities.Usuario;
import com.msvc.usuario.service.UsuarioService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuarioRequest){
        Usuario usuario = usuarioService.saveUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/actualizarCalificacion")
    public ResponseEntity<Calificacion> actualizarCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.ok(usuarioService.updateCalificacion(calificacion));
    }

    @DeleteMapping("/borrarCalificacion/{calificacionId}")
    public ResponseEntity<String> borrarCalificacion(@PathVariable String calificacionId){
        usuarioService.deleteCalificacion(calificacionId);
        return ResponseEntity.ok("Se realiza correctamente la eliminacion de la calificacion con ID: "+ calificacionId);
    }

    int cantidadIntentos =1 ;
    @GetMapping("/{usuarioId}")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
    @Retry(name = "ratingHotelServices",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String usuarioId){
        log.info("Listar un solo usuario :  UsuarioController");
        log.info("Cantidad de Intentos: {}", cantidadIntentos);
        cantidadIntentos++;
        Usuario usuario = usuarioService.getUsuario(usuarioId);
        return ResponseEntity.ok(usuario);
    }

    public ResponseEntity<Usuario> ratingHotelFallBack(String usuarioId, Exception exception){
        log.info("El Respaldo se ejecuta porque el Servicio esta Inactivo: ", exception.getMessage());
        Usuario usuario = Usuario.builder()
                .email("root@gmail.com")
                .nombre("root")
                .informacion("Este usuario se crea por defecto cuando un servicio se cae")
                .usuarioId("123")
                .build();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
