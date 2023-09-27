package com.net.javaguides.backendemployee.service;

import com.net.javaguides.backendemployee.exception.ResourceNotFoundException;
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

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public Employee findById(Long id){
//        Optional<Employee> employee = repository.findById(id);
//              if (employee.isPresent()){
//                  return employee.get();
//              }
//              else{throw new ResourceNotFoundException("Employee not exist with id: " + id));
//
        return  repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

    }
    public void deleteByid(Long id){
        Employee employee= this.findById(id);
        repository.delete(employee);
    }

    public Employee updateEmployee (Employee updateEmployee, Long id){
        Employee oldEmployee = this.findById(id);
        oldEmployee.setFirstName(updateEmployee.getFirstName());
        oldEmployee.setLastName(updateEmployee.getLastName());
        oldEmployee.setEmailId(updateEmployee.getEmailId());
        this.saveEmployee(oldEmployee);

        return  oldEmployee;
    }
}
