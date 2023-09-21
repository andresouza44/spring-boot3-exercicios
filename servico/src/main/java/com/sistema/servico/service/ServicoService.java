package com.sistema.servico.service;

import com.sistema.servico.model.Servico;
import com.sistema.servico.model.Status;
import com.sistema.servico.repository.ServicoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public List<Servico> findAll(){
        return repository.findAll();
    }

    public Optional<Servico> findById(Long id){
        return repository.findById(id);
    }


    public List<Servico> finfByStatus( Status status){
        return  repository.findAll().stream()
                .filter(e -> e.getStatus().equals(status))
                .toList();
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
        if (servico.getValorPago() < servico.getValorServico() ){
            servico.setStatus(Status.PENDENTE);
        } else{
            servico.setStatus(Status.REALIZADO);
        }

        if(servico.getValorPago() !=0){
            servico.setDataPagamento(LocalDate.now());
        }
        return repository.save(servico);

    }

    public Servico update(Servico servicoUpdate){
        if (servicoUpdate.getValorPago().equals(servicoUpdate.getValorServico())){
            servicoUpdate.setStatus(Status.REALIZADO);
        }

        Servico servico = findById(servicoUpdate.getId()).get();
        if(!servicoUpdate.getValorPago().equals(servico.getValorPago())) {
            servico.setDataPagamento(LocalDate.now());
        }

        return  repository.save(servicoUpdate);

    }

    public void delete (Long id){
        repository.deleteById(id);

    }

}
