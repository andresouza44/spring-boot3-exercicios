package com.pickpaysimplificado.domain.controller;


import com.pickpaysimplificado.domain.transaction.Transaction;
import com.pickpaysimplificado.dtos.TransactionDTO;
import com.pickpaysimplificado.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;


    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = service.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);

    }
}
