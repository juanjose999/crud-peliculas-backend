package com.personajesDisney.Controller;

import com.personajesDisney.Repository.imagen.ImageRepositoryJpa;
import com.personajesDisney.Repository.personaje.PersonajeRepository;
import com.personajesDisney.Repository.personaje.PersonajeRepositoryJpa;
import com.personajesDisney.Service.personaje.PersonajeServiceImpl;
import com.personajesDisney.entity.Personaje;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/personaje")
@CrossOrigin("*")
public class PersonajeController {

    private final PersonajeRepository personajeRepository;

    @GetMapping
    public ResponseEntity<List<Personaje>> readPersonaje(){
        List<Personaje> personajeList = personajeRepository.todosLosPersonajes();
        return ResponseEntity.ok(personajeList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Personaje> findPersonajeById(@PathVariable Long id){
        return ResponseEntity.of(personajeRepository.buscarPersonajePorId(id));
    }

    @PostMapping
    public ResponseEntity<Personaje> createPersonaje(@RequestBody Personaje personaje){
        return ResponseEntity.ok(personajeRepository.guardarPersonaje(personaje));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletePersonaje(@PathVariable Long id){
        return ResponseEntity.ok(personajeRepository.eliminarPersonaje(id));
    }

}
