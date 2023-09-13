package com.andre.usuariosApi.repository;

import com.andre.usuariosApi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface IUsuario extends JpaRepository<Usuario, Integer> {
}
