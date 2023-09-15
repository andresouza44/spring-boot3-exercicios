package com.andre.usuariosApi.service;

import com.andre.usuariosApi.dto.UsuarioDTO;
import com.andre.usuariosApi.model.Usuario;
import com.andre.usuariosApi.repository.UsuarioRepository;
import com.andre.usuariosApi.security.Token;
import com.andre.usuariosApi.security.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private  PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public  Usuario salvarUsuario(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return repository.save(usuario);

    }
    public Usuario updateUsuario(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return repository.save(usuario);
    }

    public Usuario findById(Integer id) {
        Optional<Usuario> opt = repository.findById(id);
        return opt.get();
    }

    public void deleteById (Integer id){
        repository.deleteById(id);

    }

    public Boolean validarSenha (Usuario usuario){
        String senha = repository.findById(usuario.getId()).get().getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        String usuarioNome = findById(usuario.getId()).getName();

        System.out.println(usuarioNome + "  ->> " + usuario.getName());
        if (!usuarioNome.equals(usuario.getName())) {
            valid = false;
        }
        return  valid;

    }

    public Token gerarToken(@Valid  UsuarioDTO usuario) {
         Usuario user = repository.findBynameOrEmail(usuario.getName(), usuario.getEmail());
        if (user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if (valid) {
                return new Token(TokenUtil.createToken(user));
            }

        }
        return null;

    }
}
