package com.sistema.servico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "servico")
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    @Temporal(TemporalType.DATE)
    private LocalDate dataInicio = LocalDate.now();
    @Temporal(TemporalType.DATE)
    private LocalDate dataTermino;
    private String descricao;
    private Double valorServico;
    private Double valorPago;
    @Temporal(TemporalType.DATE)
    private LocalDate dataPagamento;
    private  Status status; // Pendente / Realizado / Cancelado

   }
