package com.sistema.servico.service;

import com.sistema.servico.exception.ServicoNotFoundException;
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

//    public Servico  findById(Long id){
//        Optional<Servico> servico = repository.findById(id);
//        if (servico.isPresent()){
//            return  servico.get();
//        }
//        else {
//            throw  new ServicoNotFoundException(id);
//        }
//    }

    public List<Servico> findByStatus(Status status){
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

    public Servico update(Servico servicoUpdate, Long id){
        Servico servico = findById(id).get();
        servico.setDataPagamento(servicoUpdate.getDataPagamento());
        servico.setValorServico(servicoUpdate.getValorServico());
        servico.setDescricao(servicoUpdate.getDescricao());
        servico.setDataInicio(servicoUpdate.getDataInicio());
        servico.setDataTermino(servicoUpdate.getDataTermino());
        servico.setNomeCliente(servicoUpdate.getNomeCliente());
        servico.setValorPago(servicoUpdate.getValorPago());

        if (servicoUpdate.getStatus()!= null){
            servico.setStatus(servicoUpdate.getStatus());
        }
        if (!servico.getStatus().equals(Status.CANCELADO)){
            if(servico.getValorPago() < servico.getValorServico()){
                servico.setStatus(Status.PENDENTE);
            } else{
                servico.setStatus(Status.REALIZADO);
            }
        }
        if(!servicoUpdate.getValorPago().equals(servico.getValorPago())) {
            servicoUpdate.setDataPagamento(LocalDate.now());
        }
        return  repository.save(servico);
    }

    public void cancelarServico (Long id){
        Servico servico = findById(id).get();
        servico.setStatus(Status.CANCELADO);
        repository.save(servico);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }
}
