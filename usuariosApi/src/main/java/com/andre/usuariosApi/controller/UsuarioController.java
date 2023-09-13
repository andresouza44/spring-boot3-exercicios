package com.andre.usuariosApi.controller;

import com.andre.usuariosApi.model.Usuario;
import com.andre.usuariosApi.repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    IUsuario iUsuario;

    @GetMapping
    public ResponseEntity <List<Usuario> >findAll(){
        List<Usuario> usuarios = iUsuario.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
               // ResponseEntity.Ok.body(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario( @RequestBody Usuario usuario) {
        Usuario obj = iUsuario.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        iUsuario.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deletar (@PathVariable Integer id){
        Optional<Usuario> usuario = iUsuario.findById(id);
        if (usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        iUsuario.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com successo");
    }

}
