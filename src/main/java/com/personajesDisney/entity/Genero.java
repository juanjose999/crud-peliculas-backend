package com.personajesDisney.entity;

import com.personajesDisney.entity.Image;
import com.personajesDisney.entity.Pelicula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genero;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="image_id", referencedColumnName = "id_img")
    private Image image;
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas = new ArrayList<>();
    public void addPelicula(Pelicula pelicula){
        this.peliculas.add(pelicula);
        pelicula.setGenero(this);
    }
}
