package com.personajesDisney.Controller;

import com.personajesDisney.Repository.genero.GeneroRepositoryJpa;
import com.personajesDisney.Service.genero.GeneroService;
import com.personajesDisney.entity.Genero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/genero")
@CrossOrigin("*")
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<?>> getAllGenres(){
        List<Genero> generoList = generoService.todosLosGenero();
        return ResponseEntity.ok(generoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Genero> findGenreById(@PathVariable Long id){
        return ResponseEntity.of(generoService.buscarGenero(id));
    }

    @PostMapping
    public ResponseEntity<Genero> saveGenero(@RequestBody Genero genero){
        return ResponseEntity.ok(generoService.guardarGenero(genero));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteGenre(@PathVariable Long id){
        return ResponseEntity.ok(generoService.eliminarGenero(id));
    }

}
