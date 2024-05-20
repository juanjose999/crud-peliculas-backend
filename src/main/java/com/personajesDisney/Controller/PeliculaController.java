package com.personajesDisney.Controller;

import com.personajesDisney.Service.pelicula.PeliculaService;
import com.personajesDisney.entity.Pelicula;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pelicula")
@CrossOrigin("*")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllMovie(){
        List<Pelicula> allMovies = peliculaService.todasLasPelicula();
        return ResponseEntity.ok(allMovies);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pelicula> findMovieById(@PathVariable Long id){
        return ResponseEntity.of(peliculaService.buscarPeliculaPorId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePelicula(
            @RequestParam("titulo") String titulo,
            @RequestParam("fecha_creacion") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCreacion,
            @RequestParam("calificacion") int calificacion,
            @RequestParam("imagen_pelicula") MultipartFile imagenPelicula,
            @RequestParam("name_personaje") String namePersonaje,
            @RequestParam("edad") int edad,
            @RequestParam("peso") int peso,
            @RequestParam("history") String history,
            @RequestParam("img_personaje") MultipartFile imgPersonaje,
            @RequestParam("genero") String genero,
            @RequestParam(value = "image_genero", required = false) MultipartFile imageGenero) {

        try{
            Pelicula pelicula = peliculaService.crearPeliculaWithPersonajeAndGenero(titulo, fechaCreacion, calificacion, imagenPelicula,
                    namePersonaje, edad, peso, history, imgPersonaje,
                    genero, imageGenero);
            return ResponseEntity.ok(pelicula);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable Long id){
        return ResponseEntity.ok(peliculaService.eliminarPelicula(id));
    }

}
