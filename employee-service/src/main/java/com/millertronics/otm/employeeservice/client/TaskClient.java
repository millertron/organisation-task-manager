package com.millertronics.otm.employeeservice.client;

import com.millertronics.otm.employeeservice.domain.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "task-service", fallback = TaskClientFallback.class)
public interface TaskClient {

    @GetMapping("/")
    List<Task> getTasksForEmployee(@RequestParam long employeeId);
}
