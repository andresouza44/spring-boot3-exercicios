package com.andre.usuariosApi.repository;

import com.andre.usuariosApi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByNameOrEmail( String name, String email);
    Usuario findByName(String name);
}
