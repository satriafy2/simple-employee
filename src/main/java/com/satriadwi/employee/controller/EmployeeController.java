package com.satriadwi.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satriadwi.employee.dto.EmployeeDto;
import com.satriadwi.employee.dto.EmployeeUpdateDto;
import com.satriadwi.employee.entity.EmployeeView;
import com.satriadwi.employee.service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<?> getEmployees() {
        List<EmployeeView> employees = employeeService.fetchEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeView createdEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PatchMapping("/employee/{employeeId}")
    public ResponseEntity<?> patchEmployee(
        @PathVariable("employeeId") Long employeeId,
        @Valid @RequestBody EmployeeUpdateDto employeeUpdateDto
    ) {
        EmployeeView updatedEmployee = employeeService.updateEmployee(employeeUpdateDto, employeeId);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        HttpStatus deletedStatus = employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(null, deletedStatus);
    }
}
