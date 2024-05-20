package com.personajesDisney.Repository.pelicula;

import com.personajesDisney.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepositoryJpa extends JpaRepository<Pelicula, Long> {
}
