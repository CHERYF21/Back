
package com.example.Orion_Dreams.servicios;


import com.example.Orion_Dreams.entidades.Usuario;
import com.example.Orion_Dreams.excepciones.MiException;
import com.example.Orion_Dreams.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServicio {
     @Autowired
     UsuarioRepositorio usuarioRepositorio;
     
    //Funtions
      @Transactional
      public void crearUsuario(Long id,String nombre, String password,String email) throws MiException{
          
          validar(id ,nombre,  password, email);
          
          Usuario usuario = new Usuario();
          usuario.setId(id);
          usuario.setNombre(nombre);
          usuario.setPassword(password);
          usuario.setEmail(email);
          
          usuarioRepositorio.save(usuario);
      }
      
      @Transactional
       public Usuario guardarUsuario(Usuario usuario)  throws MiException {
        return usuarioRepositorio.save(usuario);
    }
      
      @Transactional
      public void modificarUsuario(String nombre, String password,String email, Long id) throws MiException{
          
        validar( id ,nombre,  password, email);
          
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        
        if(respuesta.isPresent()){
        Usuario usuario = respuesta.get();
        
        usuario.setNombre(nombre);
        
        usuarioRepositorio.save(usuario);
        }
    }
      
     public List<Usuario> listarUsuarios(){
    
        List<Usuario> usuarios =  new ArrayList();
        
        usuarios = usuarioRepositorio.findAll();
        
        return usuarios;
    }
     
    @Transactional
    private void validar(Long id,String nombre, String password,String email) throws MiException{
        
        if(id == null){
            throw new MiException("El campo no puede estar vacio");
        }
        
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El campo no puede estar nulo o vacio");
        }
        
        if(password.isEmpty() || password == null){
            throw new MiException("El campo no puede estar nulo o vacio");
        }
        
        if(email.isEmpty() || email == null){
            throw new MiException("El campo no puede estar nulo o vacio");
        }
    }
    
   
}
