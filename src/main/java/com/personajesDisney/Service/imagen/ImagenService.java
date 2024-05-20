package com.personajesDisney.Service.imagen;

import com.personajesDisney.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImagenService {
    List<Image> todasLasImagenes();
    Optional<Image> buscarImagenPorId(Long id);
    Image guardarImagen(Image image);
    Boolean borrarImagen(Long id);
}
