package com.personajesDisney.Repository.personaje;

import com.personajesDisney.entity.Personaje;

import java.util.List;
import java.util.Optional;

public interface PersonajeRepository {
    List<Personaje> todosLosPersonajes();
    Optional<Personaje> buscarPersonajePorId(Long id);
    Personaje guardarPersonaje(Personaje personaje);
    Boolean eliminarPersonaje(Long id);
}
