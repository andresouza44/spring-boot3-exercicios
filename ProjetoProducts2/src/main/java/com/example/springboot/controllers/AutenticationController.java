package com.example.springboot.controllers;

import com.example.springboot.dtos.AuthenticationDTO;
import com.example.springboot.dtos.RegisterDTO;
import com.example.springboot.models.user.User;
import com.example.springboot.repositories.UserRepositiry;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AutenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepositiry repository;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
       var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
       var auth = this.authenticationManager.authenticate(usernamePassword);

       return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        return ResponseEntity.ok().build();
    }

}
