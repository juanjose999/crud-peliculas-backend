package com.personajesDisney.Controller;

import com.personajesDisney.Service.user.UsuarioService;
import com.personajesDisney.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody Usuario usuario) {
        Usuario savedUser = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(savedUser);
    }
}