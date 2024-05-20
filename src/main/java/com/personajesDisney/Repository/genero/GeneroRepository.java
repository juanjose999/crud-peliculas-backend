package com.personajesDisney.Repository.genero;

import com.personajesDisney.entity.Genero;

import java.util.List;
import java.util.Optional;

public interface GeneroRepository {
    List<Genero> todosLosGenero();
    Optional<Genero> buscarGenero(Long id);
    Genero guardarGenero(Genero genero);
    Boolean eliminarGenero(Long id);
}
