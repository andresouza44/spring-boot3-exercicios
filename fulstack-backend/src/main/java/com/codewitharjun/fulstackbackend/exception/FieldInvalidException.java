package com.codewitharjun.fulstackbackend.exception;

public class FieldInvalidException extends RuntimeException{
    public FieldInvalidException(String message) {
        super("Campo inválido ");
    }
}
