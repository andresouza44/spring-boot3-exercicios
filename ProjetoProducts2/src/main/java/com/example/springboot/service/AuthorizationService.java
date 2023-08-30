package com.example.springboot.service;

import com.example.springboot.repositories.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    UserRepositiry repositiry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositiry.findByLogin(username);
    }
}
