package com.personajesDisney.entity.dto;

import com.personajesDisney.entity.Pelicula;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PersonajeDto {
    private String name_personaje;
    private Integer edad;
    private Integer peso;
    private String history;
    private MultipartFile img_personaje;
    private List<Pelicula> peliculas = new ArrayList<>();
}
