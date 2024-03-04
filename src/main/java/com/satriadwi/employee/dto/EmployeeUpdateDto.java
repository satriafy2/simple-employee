package com.satriadwi.employee.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class EmployeeUpdateDto {

    @Size(min = 2, max = 64, message = "Employee name should between 2-64 characters")
    private String name;

    @Range(min = 1, message = "Zero or negative values are not allowed")
    private Double salary;

    private Integer level;
}

