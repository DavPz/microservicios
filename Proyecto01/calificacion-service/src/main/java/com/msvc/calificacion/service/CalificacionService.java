package com.msvc.calificacion.service;

import com.msvc.calificacion.entity.Calificacion;

import java.util.List;

public interface CalificacionService {

    Calificacion create(Calificacion calificacion);

    List<Calificacion> getCalificaciones();

    Calificacion getCalificacion(String calificacionId);

    List<Calificacion> getCalificacionByUsuarioId(String usuarioId);

    List<Calificacion> getCalificacionesByHotelId(String hotelId);

    Calificacion actualizarCalificacion(Calificacion calificacion);

    void deleteCalificacion(String calificacionId);
}
