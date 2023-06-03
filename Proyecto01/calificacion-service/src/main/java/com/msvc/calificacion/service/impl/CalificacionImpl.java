package com.msvc.calificacion.service.impl;

import com.msvc.calificacion.entity.Calificacion;
import com.msvc.calificacion.repository.CalificacionRepository;
import com.msvc.calificacion.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionImpl implements CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public Calificacion create(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> getCalificaciones() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion getCalificacion(String calificacionId) {
        return calificacionRepository.findByCalificacionId(calificacionId);
    }

    @Override
    public List<Calificacion> getCalificacionByUsuarioId(String usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotelId(String hotelId) {
        return calificacionRepository.findByHotelId(hotelId);
    }

    @Override
    public Calificacion actualizarCalificacion(Calificacion newCalificacion) {
        Calificacion calificacion = calificacionRepository.findByCalificacionId(newCalificacion.getCalificacionId());
        calificacion.setCalificacionId(newCalificacion.getCalificacionId());
        calificacion.setObservaciones(newCalificacion.getObservaciones());
        calificacion.setCalificacion(newCalificacion.getCalificacion());

        return  calificacionRepository.save(calificacion);
    }

    @Override
    public void deleteCalificacion(String calificacionId) {
        Calificacion calificacion = calificacionRepository.findByCalificacionId(calificacionId);
        calificacionRepository.delete(calificacion);
    }
}
