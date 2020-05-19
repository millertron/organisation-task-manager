package com.millertronics.otm.taskservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findByEmployeeId(long employeeId);
}
