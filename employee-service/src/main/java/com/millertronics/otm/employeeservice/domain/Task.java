package com.millertronics.otm.employeeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private final Long id;
    private final String name;
    private final String description;
}
