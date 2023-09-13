package com.andre.usuariosApi.controller;

import com.andre.usuariosApi.model.Usuario;
import com.andre.usuariosApi.repository.UsuarioRepository;
import com.andre.usuariosApi.service.UsuarioService;
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
    UsuarioRepository iUsuario;

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity <List<Usuario> >findAll(){
        List<Usuario> usuarios = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
               // ResponseEntity.Ok.body(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario( @RequestBody Usuario usuario) {
        Usuario obj = service.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        service.updateUsuario(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deletar (@PathVariable Integer id){
        Optional<Usuario> usuario = Optional.ofNullable(service.findById(id));
        if (usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com successo");
    }

}
