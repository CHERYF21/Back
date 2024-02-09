
package com.example.Orion_Dreams.repositorios;

import com.example.Orion_Dreams.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio  extends JpaRepository<Usuario, String>{
    @Query("SELECT u FROM Usuario u")
    public List<Usuario> verUsuario();
}

