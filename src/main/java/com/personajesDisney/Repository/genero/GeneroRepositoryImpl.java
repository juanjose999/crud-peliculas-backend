package com.personajesDisney.Repository.genero;

import com.personajesDisney.entity.Genero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class GeneroRepositoryImpl implements GeneroRepository{

    private final GeneroRepositoryJpa generoRepositoryJpa;


    @Override
    public List<Genero> todosLosGenero() {
        return generoRepositoryJpa.findAll();
    }

    @Override
    public Optional<Genero> buscarGenero(Long id) {
        return generoRepositoryJpa.findById(id);
    }

    @Override
    public Genero guardarGenero(Genero genero) {
        return generoRepositoryJpa.save(genero);
    }

    @Override
    public Boolean eliminarGenero(Long id) {
        Optional<Genero> findGenre = Optional.ofNullable(buscarGenero(id).orElseThrow(() -> new RuntimeException("No se encontro el genero")));
        if(findGenre.isPresent()){
            generoRepositoryJpa.deleteById(id);
            return true;
        }else return false;
    }
}
