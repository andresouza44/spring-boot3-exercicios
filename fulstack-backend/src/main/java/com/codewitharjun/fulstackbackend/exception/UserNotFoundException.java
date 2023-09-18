package com.codewitharjun.fulstackbackend.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User Not Found with Id: " + id);
    }

}
