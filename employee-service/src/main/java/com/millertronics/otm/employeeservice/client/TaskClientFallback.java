package com.millertronics.otm.employeeservice.client;

import com.millertronics.otm.employeeservice.domain.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskClientFallback implements TaskClient{

    @Override
    public List<Task> getTasksForEmployee(long employeeId) {
        return new ArrayList<>();
    }
}
