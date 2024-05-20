package com.personajesDisney.Controller;

import com.personajesDisney.Service.imagen.ImagenService;
import com.personajesDisney.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/imagen")
@RequiredArgsConstructor
public class ImagenController {

    private final ImagenService imagenService;

    @GetMapping
    public ResponseEntity<List<Image>> todasLasImagenes(){
        return ResponseEntity.ok(imagenService.todasLasImagenes().stream().toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<Image> buscarImagenPorId(Long id){
        return ResponseEntity.of(imagenService.buscarImagenPorId(id));
    }

    @PostMapping
    public ResponseEntity<Image> guardarImagen(Image image){
        return ResponseEntity.ok(imagenService.guardarImagen(image));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarImagen(Long id){
        return ResponseEntity.ok(imagenService.borrarImagen(id));
    }

}
