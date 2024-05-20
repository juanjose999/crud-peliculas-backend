package com.personajesDisney.Repository.personaje;

import com.personajesDisney.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepositoryJpa extends JpaRepository<Personaje, Long> {
}
