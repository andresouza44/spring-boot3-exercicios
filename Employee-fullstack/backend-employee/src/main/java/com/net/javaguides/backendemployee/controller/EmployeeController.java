package com.net.javaguides.backendemployee.controller;


import com.net.javaguides.backendemployee.model.Employee;
import com.net.javaguides.backendemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
// @CrossOrigin("*") libera tudo
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity <List<Employee>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity <Employee> findById(@PathVariable  Long id){
        Employee employee = service.findById(id);
        return ResponseEntity.ok(employee);

    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        Employee obj = service.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        service.deleteByid(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employeeUpdate,@PathVariable Long id){
        Employee newEmployee = service.updateEmployee(employeeUpdate, id);
        return ResponseEntity.ok(newEmployee);
    }


}


