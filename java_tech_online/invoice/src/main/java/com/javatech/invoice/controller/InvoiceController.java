package com.javatech.invoice.controller;


import com.javatech.invoice.exception.InvoiceNotFoundException;
import com.javatech.invoice.model.Invoice;
import com.javatech.invoice.service.InvoiceServiceImpl;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceServiceImpl service;

    @GetMapping("/")
    public String showHomePage(){
        return "homePage";
    }

    @GetMapping("/register")
    public String showRegistration(){
        return "registerInvoicePage";
    }

    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute Invoice invoice, Model model){
        service.saveInvoice(invoice);
        Long id = service.saveInvoice(invoice).getId();
        String message = "Record with " + id + "is save successfully ";
        model.addAttribute("message", message);
        return "registerInvoicePage";
    }

    @GetMapping("/getAllInvoices")
    public String getAllInvoices(@RequestParam(value="message", required=false)
                                     String message, Model model){
        List<Invoice> invoices = service.getAllInvoices();
        model.addAttribute("list", invoices);
        model.addAttribute("message", message);
        return "allInvoicePage";

    }
    @GetMapping("/edit")
    public String getEditPage(Model model, RedirectAttributes attributes,@RequestParam Long id){
        String page = null;
        try{
            Invoice invoice = service.getInvoiceById(id);
            model.addAttribute("invoice", invoice);
            page = "editInvoicePage";
        } catch (InvoiceNotFoundException e){
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
            page="redirect:getAllInvoices";
        }
        return page;

    }
    @PostMapping("/update")
    public String updateInvoice(@ModelAttribute Invoice invoice, RedirectAttributes attributes) {
        service.updateInvoice(invoice);
        Long id = invoice.getId();
        attributes.addAttribute("message", "Invoice with id: " + id + " is update successfully");
        return "redirect:getAllInvoices";
    }
    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id, RedirectAttributes attributes){
            try {
                service.deleteInvoiceById(id);
                attributes.addAttribute("message", "Invoie with id " + id + "is remoced successfully");
            }
            catch (InvoiceNotFoundException e){
                e.printStackTrace();
                attributes.addAttribute("message", e.getMessage());
            }
        return "redirect:gettAllInvoices";

    }


}
