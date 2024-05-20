package com.personajesDisney.Repository.imagen;

import com.personajesDisney.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImagenRepository {
    List<Image>  todasLasImagenes();
    Optional<Image> buscarImagenPorId(Long id);
    Image guardarImagen(Image image);
    Boolean borrarImagen(Long id);
}
