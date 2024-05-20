package com.personajesDisney.Service.pelicula;

import com.personajesDisney.Controller.GeneroController;
import com.personajesDisney.Controller.ImagenController;
import com.personajesDisney.Controller.PersonajeController;
import com.personajesDisney.Repository.pelicula.PeliculaRepository;
import com.personajesDisney.Repository.pelicula.PeliculaRepositoryJpa;
import com.personajesDisney.entity.Genero;
import com.personajesDisney.entity.Image;
import com.personajesDisney.entity.Pelicula;
import com.personajesDisney.entity.Personaje;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeliculaServiceImpl implements PeliculaService{

    private final PeliculaRepository peliculaRepository;
    private final PersonajeController personajeController;
    private final GeneroController generoController;
    private final ImagenController imagenController;

    @Override
    public List<Pelicula> todasLasPelicula() {
        return peliculaRepository.todasLasPelicula();
    }

    @Override
    public Optional<Pelicula> buscarPeliculaPorId(Long id) {
        return peliculaRepository.buscarPeliculaPorId(id);
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.guardarPelicula(pelicula);
    }

    public Pelicula crearPeliculaWithPersonajeAndGenero(String titulo, LocalDate fechaCreacion, int calificacion, MultipartFile imagenPelicula,
                                                        String namePersonaje, int edad, int peso, String historia, MultipartFile imgPersonaje,
                                                        String generoNombre, MultipartFile imageGenero) throws IOException {
        // Crear la imagen de la película
        Image imagenPeliculaEntity = new Image();
        imagenPeliculaEntity.setData(limitarTamanoArchivo(imagenPelicula.getBytes()));
        imagenPeliculaEntity.setName(imagenPelicula.getOriginalFilename());
        imagenPeliculaEntity.setType(imagenPelicula.getContentType());
        imagenPeliculaEntity = imagenController.guardarImagen(imagenPeliculaEntity).getBody();

        //crear imagen personaje
        Image imagenPersonajeEntity = new Image();
        imagenPersonajeEntity.setData(limitarTamanoArchivo(imgPersonaje.getBytes()));
        imagenPersonajeEntity.setName(imgPersonaje.getOriginalFilename());
        imagenPeliculaEntity.setType(imagenPelicula.getContentType());
        imagenPeliculaEntity = imagenController.guardarImagen(imagenPersonajeEntity).getBody();

        // Crear imagen personaje y guardar el personaje
        Personaje personaje = new Personaje();
        personaje.setName_personaje(namePersonaje);
        personaje.setEdad(edad);
        personaje.setPeso(peso);
        personaje.setHistory(historia);
        personaje.setImg_personaje(imagenPersonajeEntity);
        personaje = personajeController.createPersonaje(personaje).getBody();

        // Crear y guardar el género
        Genero genero = new Genero();
        genero.setGenero(generoNombre);

        if (imageGenero != null && !imageGenero.isEmpty()) {
            Image imageGeneroEntity = new Image();
            imageGeneroEntity.setData(limitarTamanoArchivo(imageGenero.getBytes()));
            imageGeneroEntity.setName(imageGenero.getOriginalFilename());
            imageGeneroEntity.setType(imageGenero.getContentType());
            imageGeneroEntity = imagenController.guardarImagen(imageGeneroEntity).getBody();
            genero.setImage(imageGeneroEntity);
        }

        genero = generoController.saveGenero(genero).getBody();

        // Crear la película
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(titulo);
        pelicula.setFecha_creacion(String.valueOf(fechaCreacion));
        pelicula.setCalificacion(calificacion);
        pelicula.setImage_pelicula(imagenPeliculaEntity);
        pelicula.addPersonaje(personaje);
        pelicula.setGenero(genero);

        // Guardar la película
        return  pelicula = peliculaRepository.guardarPelicula(pelicula);

        // Asociar el personaje a la película
    }
    private byte[] limitarTamanoArchivo(byte[] datosArchivo) {
        // Define un tamaño máximo permitido para los archivos (por ejemplo, 1 MB)
        int TAMANO_MAXIMO = 1024 * 1024; // 1 MB en bytes

        if (datosArchivo.length > TAMANO_MAXIMO) {
            // Si el tamaño del archivo excede el máximo permitido, trunca los datos
            byte[] datosLimitados = new byte[TAMANO_MAXIMO];
            System.arraycopy(datosArchivo, 0, datosLimitados, 0, TAMANO_MAXIMO);
            return datosLimitados;
        } else {
            // Si el tamaño del archivo está dentro del límite, devuelve los datos sin cambios
            return datosArchivo;
        }

    }

    @Override
    public Boolean eliminarPelicula(Long id) {
        return peliculaRepository.eliminarPelicula(id);
    }
}
