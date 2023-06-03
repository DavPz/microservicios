package com.msvc.usuario.service;

import com.msvc.usuario.entities.Calificacion;
import com.msvc.usuario.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);

    List<Usuario> getAllUsuarios();

    Usuario getUsuario(String usuarioID);

    Calificacion updateCalificacion( Calificacion calificacion);

    void deleteCalificacion (String calificacionId);

}
