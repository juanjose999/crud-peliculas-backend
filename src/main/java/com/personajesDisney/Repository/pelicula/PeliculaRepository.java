package com.personajesDisney.Repository.pelicula;

import com.personajesDisney.entity.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository {
    List<Pelicula> todasLasPelicula();
    Optional<Pelicula> buscarPeliculaPorId(Long id);
    Pelicula guardarPelicula(Pelicula pelicula);
    Boolean eliminarPelicula(Long id);
}
