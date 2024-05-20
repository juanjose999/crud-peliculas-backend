package com.personajesDisney.Repository.personaje;

import com.personajesDisney.Repository.pelicula.PeliculaRepositoryJpa;
import com.personajesDisney.entity.Personaje;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    private final PersonajeRepositoryJpa personajeRepositoryJpa;

    @Override
    public List<Personaje> todosLosPersonajes() {
        return personajeRepositoryJpa.findAll().stream().toList();
    }

    @Override
    public Optional<Personaje> buscarPersonajePorId(Long id) {
        return personajeRepositoryJpa.findById(id);
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeRepositoryJpa.save(personaje);
    }

    @Override
    public Boolean eliminarPersonaje(Long id) {
        Optional<Personaje> findPesonaje = buscarPersonajePorId(id);
        if (findPesonaje.isPresent()){
            personajeRepositoryJpa.deleteById(id);
            return true;
        }else return false;
    }
}
