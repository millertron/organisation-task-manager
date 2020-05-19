package com.millertronics.otm.employeeservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.millertronics.otm.employeeservice.domain.Employee;
import com.millertronics.otm.employeeservice.domain.EmployeeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeResource {
    
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id) {
        return employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
