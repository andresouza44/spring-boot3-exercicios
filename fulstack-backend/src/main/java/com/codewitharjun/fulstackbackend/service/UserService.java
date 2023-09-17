package com.codewitharjun.fulstackbackend.service;

import com.codewitharjun.fulstackbackend.exception.UserNotFoundException;
import com.codewitharjun.fulstackbackend.model.User;
import com.codewitharjun.fulstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User newUser){
        return  repository.save(newUser);
    }

    public List<User> findAll(){
        return repository.findAll();


    }
    public Optional<User> findById (Long id){
        return  repository.findById(id);
    }



}
