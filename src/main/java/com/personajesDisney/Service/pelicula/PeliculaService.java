package com.personajesDisney.Service.pelicula;

import com.personajesDisney.entity.Pelicula;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> todasLasPelicula();
    Optional<Pelicula> buscarPeliculaPorId(Long id);
    Pelicula guardarPelicula(Pelicula pelicula);

    Pelicula crearPeliculaWithPersonajeAndGenero(String titulo, LocalDate fechaCreacion, int calificacion, MultipartFile imagenPelicula,
                                                 String namePersonaje, int edad, int peso, String historia, MultipartFile imgPersonaje,
                                                 String generoNombre, MultipartFile imageGenero) throws IOException;

    Boolean eliminarPelicula(Long id);
}
