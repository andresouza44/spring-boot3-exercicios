package com.andre.usuariosApi.service;

import com.andre.usuariosApi.model.Usuario;
import com.andre.usuariosApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public UsuarioService() {
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public  Usuario saveUsuario (Usuario usuario){
        return repository.save(usuario);

    }
    public Usuario updateUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario findById(Integer id) {
        Optional<Usuario> opt = repository.findById(id);
        return opt.get();
    }

    public void deleteById (Integer id){
        repository.deleteById(id);

    }
}
