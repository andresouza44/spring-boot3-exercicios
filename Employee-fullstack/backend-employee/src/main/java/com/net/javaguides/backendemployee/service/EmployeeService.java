package com.net.javaguides.backendemployee.service;

import com.net.javaguides.backendemployee.model.Employee;
import com.net.javaguides.backendemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll(){
        return repository.findAll();

    }

}
