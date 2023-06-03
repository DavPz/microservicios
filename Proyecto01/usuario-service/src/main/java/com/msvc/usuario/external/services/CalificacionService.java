package com.msvc.usuario.external.services;

import com.msvc.usuario.entities.Calificacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "CALIFICACION-SERVICE")
public interface CalificacionService {

    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(Calificacion calificacion);

    @PostMapping("calificaciones/actualizarCalificacion")
    public Calificacion actualizarCalificacion(@RequestBody Calificacion calificacion);

    @GetMapping("calificaciones/{calificacionId}")
    public Calificacion getCalificacion(@PathVariable String calificacionId);

    @DeleteMapping("calificaciones/{calificacionId}")
    public void eliminarCalificacion(@PathVariable String calificacionId);

}
