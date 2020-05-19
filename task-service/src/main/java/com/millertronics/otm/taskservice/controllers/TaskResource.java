package com.millertronics.otm.taskservice.controllers;

import com.millertronics.otm.taskservice.domain.Task;
import com.millertronics.otm.taskservice.domain.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
public class TaskResource {

    private final TaskRepository taskRepository;

    @GetMapping
    public List<Task> listAll(@RequestParam(required = false) Long employeeId) {
        if (employeeId != null) {
            return taskRepository.findByEmployeeId(employeeId);
        }
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable long id) {
        return taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
