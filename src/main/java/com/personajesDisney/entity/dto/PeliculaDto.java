package com.personajesDisney.entity.dto;

import com.personajesDisney.entity.Genero;
import com.personajesDisney.entity.Image;
import com.personajesDisney.entity.Personaje;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Getter
@Setter
public class PeliculaDto {
    private String titulo;
    private String fecha_creacion;
    private int calificacion;
    private ImageDto imagen_pelicula;
    private PersonajeDto personajeDto;
    private GeneroDto generoDto;
}
