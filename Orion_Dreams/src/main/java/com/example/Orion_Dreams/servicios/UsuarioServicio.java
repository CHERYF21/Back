
package com.example.Orion_Dreams.servicios;


import com.example.Orion_Dreams.entidades.Usuario;
import com.example.Orion_Dreams.excepciones.MiException;
import com.example.Orion_Dreams.repositorios.UsuarioRepositorio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServicio {
     @Autowired
     UsuarioRepositorio usuarioRepositorio;
     
    //Funtions
      @Transactional
      public void crearUsuario(String nombre, String password,String email) throws MiException{
          
          validar( nombre,  password, email);
          
          Usuario usuario = new Usuario();
          usuario.setNombre(nombre);
          usuario.setPassword(password);
          usuario.setEmail(email);
          
          usuarioRepositorio.save(usuario);
      }
      
       public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }
      
    private void validar(String nombre, String password,String email) throws MiException{
        
        if(nombre == null || nombre.isEmpty()){
            throw new MiException("El campo no puede estar nulo o vacio");
        }
        
        if(password == null || password.isEmpty()){
            throw new MiException("El campo no puede estar nulo o vacio");
        }
        
        if(email == null || email.isEmpty()){
            throw new MiException("El campo no puede estar nulo o vacio");
        }
    }

    public void guardarUsuario(Usuario usuario) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
   
}
