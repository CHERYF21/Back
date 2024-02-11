
package com.example.Orion_Dreams.controladores;

import com.example.Orion_Dreams.entidades.Usuario;
import com.example.Orion_Dreams.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UsuarioControlador {

 @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    // Otros métodos existentes...

    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
