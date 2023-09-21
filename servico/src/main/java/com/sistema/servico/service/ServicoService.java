package com.sistema.servico.service;

import com.sistema.servico.model.Servico;
import com.sistema.servico.model.Status;
import com.sistema.servico.repository.ServicoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public List<Servico> findAll(){
        return repository.findAll();
    }

    public Servico findById(Long id){
        return repository.findById(id).get();
    }

    public List<Servico> findByStatusPendente(){
        return repository.findAll().stream()
                .filter(e -> e.getStatus().equals(Status.PENDENTE))
                .toList();
    }

    public List<Servico> findByStatusCancelado(){
        return repository.findAll().stream()
                .filter(e -> e.getStatus().equals(Status.CANCELADO))
                .toList();
    }

    public Servico save(Servico servico){
        if (servico.getValorPago() < servico.getValorServico() || servico.getDataPagamento() == null){
            servico.setStatus(Status.PENDENTE);
        } else{
            servico.setStatus(Status.REALIZADO);
        }
        return repository.save(servico);

    }

    public Servico update(Servico servico){
        if (servico.getValorPago().equals(servico.getValorServico()) && servico.getDataPagamento() != null){
            servico.setStatus(Status.REALIZADO);
        }

        return  repository.save(servico);

    }

    public void delete (Long id){
        repository.delete(findById(id));

    }

}
