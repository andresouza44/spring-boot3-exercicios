package com.andre.usuariosApi.repository;

import com.andre.usuariosApi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findBynameOrEmail(String name, String email);
}
