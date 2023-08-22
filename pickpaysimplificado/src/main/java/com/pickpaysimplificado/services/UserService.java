package com.pickpaysimplificado.services;


import com.pickpaysimplificado.domain.user.User;
import com.pickpaysimplificado.domain.user.UserType;
import com.pickpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public void validateTransaction(User userSender , BigDecimal amount) throws Exception {
        if (userSender.getUserType() == UserType.MERCHANT){
            throw new Exception("Logista não está autorizado a realizar esse tipo de tranasação");
        }

        if (userSender.getBalance().compareTo(amount) <0 ){
            throw new Exception("Saldo insuficiente");


        }
    }

    public User findUserById(Long id) throws Exception {
        return repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public void saveUser(User user){
        repository.save(user);
    }
}
