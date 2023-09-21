package com.sistema.servico.exception;

public class ServicoNotFoundException extends RuntimeException{
    public ServicoNotFoundException(Long id) {
        super("Servoco not founf with id " + id);
    }
}
