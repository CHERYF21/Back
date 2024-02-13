
package com.example.Orion_Dreams.controladores;

import com.example.Orion_Dreams.entidades.Usuario;
import com.example.Orion_Dreams.excepciones.MiException;
import com.example.Orion_Dreams.repositorios.UsuarioRepositorio;
import com.example.Orion_Dreams.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UsuarioControlador {

 @Autowired
   private UsuarioServicio usuarioServicio;

 
    @PostMapping("/create")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioServicio.crearUsuario(usuario.getNombre(),  usuario.getPassword() ,usuario.getEmail());
            return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);
        } catch (MiException ex ) {
            return new ResponseEntity<>("Error al crear usuario: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
    
    
    @GetMapping("/usuarios")
    public List<Usuario> traerUsuarios(){
        var usuarios = usuarioServicio.listarUsuarios();
        return usuarios;
    }
}
