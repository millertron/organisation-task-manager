package com.millertronics.otm.employeeservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.millertronics.otm.employeeservice.client.TaskClient;
import com.millertronics.otm.employeeservice.domain.Employee;
import com.millertronics.otm.employeeservice.domain.EmployeeRepository;

import com.millertronics.otm.employeeservice.domain.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeResource {
    
    private final EmployeeRepository employeeRepository;
    private final TaskClient taskClient;

    @GetMapping
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id) {
        return employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @GetMapping("/{id}/tasks")
    public List<Task> listTaskForUser(@PathVariable long id) {
        return taskClient.getTasksForEmployee(employeeRepository.findById(id)
                .map(Employee::getId)
                .orElseThrow(NoSuchElementException::new));
    }
}
