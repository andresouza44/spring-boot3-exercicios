package com.javatech.invoice.service;

import com.javatech.invoice.exception.InvoiceNotFoundException;
import com.javatech.invoice.model.Invoice;
import com.javatech.invoice.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    @Autowired
    InvoiceRepository repo;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return repo.save(invoice);

    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repo.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> opt = repo.findById(id);
        if (opt.isPresent()){
            return opt.get();
        }
        else{
            throw new InvoiceNotFoundException("Invoice with id: " + id + " Not found");

        }
    }

    @Override
    public void deleteInvoiceById(Long id) {
        repo.delete(getInvoiceById(id));

    }

    @Override
    public void updateInvoice(Invoice invoice) {
        repo.save(invoice);

    }
}
