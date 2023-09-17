package com.codewitharjun.fulstackbackend.controller;

import com.codewitharjun.fulstackbackend.exception.UserNotFoundException;
import com.codewitharjun.fulstackbackend.model.User;
import com.codewitharjun.fulstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity <List<User>> fildAll (){
        List<User> users = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);

    }
    @GetMapping(value ="/{id}")
    public User findById(@PathVariable Long id){
        return service.findById(id);

    }


    @PostMapping
    public ResponseEntity save(@RequestBody User user){
        User newUser = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping(value="/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return service.updateUser(user,id);

    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().body("User with id " + id + " deleted successfully");


    }

}
