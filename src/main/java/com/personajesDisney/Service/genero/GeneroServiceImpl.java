package com.personajesDisney.Service.genero;

import com.personajesDisney.Repository.genero.GeneroRepository;
import com.personajesDisney.entity.Genero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GeneroServiceImpl implements GeneroService{

    private final GeneroRepository generoRepository;


    @Override
    public List<Genero> todosLosGenero() {
        return generoRepository.todosLosGenero();
    }

    @Override
    public Optional<Genero> buscarGenero(Long id) {
        return generoRepository.buscarGenero(id);
    }

    @Override
    public Genero guardarGenero(Genero genero) {
        return generoRepository.guardarGenero(genero);
    }

    @Override
    public Boolean eliminarGenero(Long id) {
        return generoRepository.eliminarGenero(id);
    }
}
