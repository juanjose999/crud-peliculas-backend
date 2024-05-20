package com.personajesDisney.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personaje;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id_img")
    private Image img_personaje;

    private String name_personaje;
    private Integer edad;
    private Integer peso;
    private String history;

    @ManyToMany(mappedBy = "personales_asociados")
    @JsonIgnore
    private List<Pelicula> peliculas = new ArrayList<>();

    public void addPelicula(Pelicula pelicula){
        this.peliculas.add(pelicula);
    }
}
