package com.personajesDisney.Service.personaje;

import com.personajesDisney.Repository.personaje.PersonajeRepository;
import com.personajesDisney.Repository.personaje.PersonajeRepositoryJpa;
import com.personajesDisney.entity.Personaje;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements PersonajeService{

    private final PersonajeRepository personajeRepository;


    @Override
    public List<Personaje> todosLosPersonajes() {
        return personajeRepository.todosLosPersonajes();
    }

    @Override
    public Optional<Personaje> buscarPersonajePorId(Long id) {
        return personajeRepository.buscarPersonajePorId(id);
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeRepository.guardarPersonaje(personaje);
    }

    @Override
    public Boolean eliminarPersonaje(Long id) {
        return personajeRepository.eliminarPersonaje(id);
    }
}
