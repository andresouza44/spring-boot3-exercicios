package com.codewitharjun.fulstackbackend.service;

import com.codewitharjun.fulstackbackend.exception.FieldInvalidException;
import com.codewitharjun.fulstackbackend.exception.UserNotFoundException;
import com.codewitharjun.fulstackbackend.model.User;
import com.codewitharjun.fulstackbackend.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.FileLockInterruptionException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User newUser) {

            return repository.save(newUser);
    }


    public List<User> findAll(){
        return repository.findAll();


    }
    public User findById (Long id){
        return  repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User updateUser (User user , Long id){
       User userUpdate = this.findById(id);
       userUpdate.setName(user.getName());
       userUpdate.setUsername(user.getUsername());
       userUpdate.setEmail(user.getEmail());
       repository.save(userUpdate);

        return  userUpdate;

    }

    public void delete(Long id){
        User user = findById(id);
        repository.delete(user);

    }


}
