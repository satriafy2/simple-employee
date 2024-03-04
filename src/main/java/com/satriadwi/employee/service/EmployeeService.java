package com.satriadwi.employee.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.satriadwi.employee.dto.EmployeeDto;
import com.satriadwi.employee.dto.EmployeeUpdateDto;
import com.satriadwi.employee.entity.EmployeeView;

public interface EmployeeService {
    EmployeeView saveEmployee(EmployeeDto employeeDto);
    List<EmployeeView> fetchEmployees();
    EmployeeView updateEmployee(EmployeeUpdateDto employeeUpdateDto, Long employeeId);
    HttpStatus deleteEmployee(Long employeeId);
}
