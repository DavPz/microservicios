package com.msvc.calificacion.controllers;

import com.msvc.calificacion.entity.Calificacion;
import com.msvc.calificacion.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.create(calificacion));
    }

    @GetMapping("/{calificacionId}")
    public ResponseEntity<Calificacion> getCalificacion(@PathVariable String calificacionId){
        return ResponseEntity.ok(calificacionService.getCalificacion(calificacionId));
    }

    @GetMapping
    public ResponseEntity<List<Calificacion>> listarCalificaciones(){
        return ResponseEntity.ok(calificacionService.getCalificaciones());
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorUsuarioId(@PathVariable String usuarioId){
        return  ResponseEntity.ok(calificacionService.getCalificacionByUsuarioId(usuarioId));
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorHotelId(@PathVariable String hotelId){
        return  ResponseEntity.ok(calificacionService.getCalificacionesByHotelId(hotelId));
    }

    @PostMapping("/actualizarCalificacion")
    public ResponseEntity<Calificacion> actualizarCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.ok(calificacionService.actualizarCalificacion(calificacion));
    }

    @DeleteMapping("/{calificacionId}")
    public ResponseEntity<String> eliminarCalificacion(@PathVariable String calificacionId){
        calificacionService.deleteCalificacion(calificacionId);
        return ResponseEntity.ok("La Calificacion con ID: "+ calificacionId + " Se borro saticfatoriamente");
    }

    @GetMapping("/prueba")
    public ResponseEntity<String> prueba(){
        return ResponseEntity.ok("Quesito");
    }

}
