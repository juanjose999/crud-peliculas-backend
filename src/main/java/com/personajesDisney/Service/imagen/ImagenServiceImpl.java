package com.personajesDisney.Service.imagen;

import com.personajesDisney.Repository.imagen.ImagenRepository;
import com.personajesDisney.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImagenServiceImpl implements ImagenService {

    private final ImagenRepository imagenRepository;

    @Override
    public List<Image> todasLasImagenes() {
        return imagenRepository.todasLasImagenes();
    }

    @Override
    public Optional<Image> buscarImagenPorId(Long id) {
        return imagenRepository.buscarImagenPorId(id);
    }

    @Override
    public Image guardarImagen(Image image) {
        return imagenRepository.guardarImagen(image);
    }

    @Override
    public Boolean borrarImagen(Long id) {
        return imagenRepository.borrarImagen(id);
    }
}
