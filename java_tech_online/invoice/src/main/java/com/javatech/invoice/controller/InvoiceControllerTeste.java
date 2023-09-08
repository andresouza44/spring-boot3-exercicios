package com.javatech.invoice.controller;


import com.javatech.invoice.model.Invoice;
import com.javatech.invoice.service.InvoiceServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice/teste")
public class InvoiceControllerTeste {

    @Autowired
    InvoiceServiceImpl invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>>getInvoices(){
        List <Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok().body(invoices);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getInvoiceById(@PathVariable Long id) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok().body(invoice);
    }

    @PostMapping
    public ResponseEntity createInvoice(@RequestBody Invoice invoice){
       invoice = invoiceService.saveInvoice(invoice);
        return  ResponseEntity.ok().body(invoice);

    }

    @PutMapping(value="/{id}")
    public ResponseEntity updateInvoice (@RequestBody Invoice invoice, @PathVariable Long id){
        invoiceService.updateInvoice(invoice);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        invoiceService.deleteInvoiceById(id);
        return ResponseEntity.ok().build();
    }


}
