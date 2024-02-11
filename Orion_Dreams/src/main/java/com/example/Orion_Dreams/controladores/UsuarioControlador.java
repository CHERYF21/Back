
package com.example.Orion_Dreams.controladores;

import com.example.Orion_Dreams.entidades.Usuario;
import com.example.Orion_Dreams.excepciones.MiException;
import com.example.Orion_Dreams.repositorios.UsuarioRepositorio;
import com.example.Orion_Dreams.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioControlador {

 @Autowired
   private UsuarioServicio usuarioServicio;

    @PostMapping("/usuarios")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioServicio.guardarUsuario(usuario.getNombre(), usuario.getEmail(), usuario.getPassword());
            return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);
        } catch (MiException ex ) {
            return new ResponseEntity<>("Error al crear usuario: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
