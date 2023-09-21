package com.sistema.servico.model;

public enum Status {
    PENDENTE(0, "PENDENTE"),
    REALIZADO(1,"REALIZADO"),
    CANCELADO(2,"CANCELADO"),
    ;

    Status(int i, String status) {
    }
}
