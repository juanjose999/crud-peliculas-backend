package com.personajesDisney.Repository.imagen;

import com.personajesDisney.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ImagenRepositoryImpl implements ImagenRepository{

    private final ImageRepositoryJpa imageRepositoryJpa;

    @Override
    public List<Image> todasLasImagenes() {
        return imageRepositoryJpa.findAll();
    }

    @Override
    public Optional<Image> buscarImagenPorId(Long id) {
        return imageRepositoryJpa.findById(id);
    }

    @Override
    public Image guardarImagen(Image image) {
        return imageRepositoryJpa.save(image);
    }

    @Override
    public Boolean borrarImagen(Long id) {
        Optional<Image> findImage = buscarImagenPorId(id);
        if(findImage.isPresent()){
            imageRepositoryJpa.delete(findImage.get());
            return true;
        }else return false;
    }
}
