
package servicios;

import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
     @Autowired
     UsuarioRepositorio usuarioRepositorio;
     
    //Funtions
      @Transactional
      public void crearUsuario(String nombre){
          Usuario usuario = new Usuario();
          usuario.setNombre(nombre);
          
          usuarioRepositorio.save(usuario);
      }
      
      public void modificarUsuario(String nombre, String id){
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        
        if(respuesta.isPresent()){
        Usuario usuario = respuesta.get();
        
        usuario.setNombre(nombre);
        
        usuarioRepositorio.save(usuario);
        }
    }
      
     public void elinarUsuario(String nombre, String id){
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        
        if(respuesta.isPresent()){
        Usuario usuario = respuesta.get();
        
        usuario.setNombre(nombre);
        
        usuarioRepositorio.delete(usuario);
        }
    }
      
     public List<Usuario> listarUsuarios(){
    
        List<Usuario> usuarios =  new ArrayList();
        
        usuarios = usuarioRepositorio.findAll();
        
        return usuarios;
    }
}
