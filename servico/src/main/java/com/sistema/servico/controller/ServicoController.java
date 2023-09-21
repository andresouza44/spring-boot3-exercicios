package com.sistema.servico.controller;


import com.sistema.servico.model.Servico;
import com.sistema.servico.model.Status;
import com.sistema.servico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;

@RestController
@RequestMapping(value="/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity <List<Servico>> findAll(){
        List <Servico> servicos = service.findAll();
        return ResponseEntity.ok().body(servicos);
    }

    @GetMapping(value = "/{status}")
    public ResponseEntity  <List<Servico>> findByStatus(@PathVariable Status status){
        List <Servico> servicos = service.finfByStatus(status);
        return  ResponseEntity.ok().body(servicos);
    }

    @PutMapping (value="/{id}")
    public ResponseEntity <?> updatdServico(@RequestBody Servico servico, @PathVariable Long id){
        Optional<Servico> obj = service.findById(id);
        if (obj.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servico with id "+ id + "not found");

        }
        else {
            Servico servicoCriado = service.save(servico);
            return  ResponseEntity.status(HttpStatus.CREATED).body(servicoCriado);

        }

    }

    @PostMapping
    public  ResponseEntity <Servico> creatServico(@RequestBody Servico servico){
        service.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteServico(@PathVariable Long id){
        Optional<Servico> obj = service.findById(id);
        if (obj.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Servico with id "+ id + " not found");
        }else{
            service.delete(id);
            return ResponseEntity.noContent().build();
        }

    }
}
