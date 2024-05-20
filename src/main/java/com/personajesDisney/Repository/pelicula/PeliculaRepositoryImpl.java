package com.personajesDisney.Repository.pelicula;

import com.personajesDisney.entity.Pelicula;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PeliculaRepositoryImpl implements PeliculaRepository{

    private final PeliculaRepositoryJpa peliculaRepositoryJpa;
    @Override
    public List<Pelicula> todasLasPelicula() {
        return peliculaRepositoryJpa.findAll();
    }

    @Override
    public Optional<Pelicula> buscarPeliculaPorId(Long id) {
        return peliculaRepositoryJpa.findById(id);
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepositoryJpa.save(pelicula);
    }

    @Override
    public Boolean eliminarPelicula(Long id) {
        Optional<Pelicula> findMovie =  buscarPeliculaPorId(id);
        if(findMovie.isPresent()){
            peliculaRepositoryJpa.delete(findMovie.get());
            return true;
        }else return false;
    }
}
