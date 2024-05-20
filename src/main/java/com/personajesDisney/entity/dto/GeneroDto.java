package com.personajesDisney.entity.dto;

import com.personajesDisney.entity.Image;
import com.personajesDisney.entity.Pelicula;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class GeneroDto {
    private String genero;
    private ImageDto image;
}
