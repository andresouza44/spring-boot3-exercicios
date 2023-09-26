package com.net.javaguides.backendemployee.controller;


import com.net.javaguides.backendemployee.model.Employee;
import com.net.javaguides.backendemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity <List<Employee>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }
}
