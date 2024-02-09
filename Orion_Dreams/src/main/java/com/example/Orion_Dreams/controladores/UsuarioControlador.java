
package com.example.Orion_Dreams.controladores;

import com.example.Orion_Dreams.entidades.Usuario;
import com.example.Orion_Dreams.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepositorio.findAll();
    }
}
