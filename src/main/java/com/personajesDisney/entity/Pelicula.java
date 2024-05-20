package com.personajesDisney.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id_img")
    private Image image_pelicula;
    private String titulo;
    private String fecha_creacion;
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToMany
    @JoinTable(
            name= "pelicula_personaje",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="personaje_id")
    )
    private List<Personaje> personales_asociados = new ArrayList<>();
    public void addPersonaje(Personaje personaje){
        this.personales_asociados.add(personaje);
        personaje.getPeliculas().add(this);
    }
}

