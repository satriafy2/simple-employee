package com.satriadwi.employee.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satriadwi.employee.dto.EmployeeDto;
import com.satriadwi.employee.dto.EmployeeUpdateDto;
import com.satriadwi.employee.entity.Employee;
import com.satriadwi.employee.entity.EmployeeLevel;
import com.satriadwi.employee.entity.EmployeeView;
import com.satriadwi.employee.repository.EmployeeLevelRepository;
import com.satriadwi.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeLevelRepository employeeLevelRepository;

    @Override
    public EmployeeView saveEmployee(EmployeeDto employeeDto) {
        EmployeeLevel employeeLevel = employeeLevelRepository
            .findById(employeeDto.getLevel())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee level not found."));
        
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        employee.setLevel(employeeLevel);
        employeeRepository.save(employee);

        return employeeRepository.findById(employee.getId(), EmployeeView.class);
    }

    @Override
    public List<EmployeeView> fetchEmployees() {
        return employeeRepository.findByDeletedAtIsNull();
    }

    @Override
    public EmployeeView updateEmployee(EmployeeUpdateDto employeeUpdateDto, Long employeeId) {
        Employee employee = employeeRepository
            .findById(employeeId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found."));

        if (employeeUpdateDto.getLevel() != null) {
            EmployeeLevel employeeLevel = employeeLevelRepository
                .findById(employeeUpdateDto.getLevel())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee level not found."));
            
            employee.setLevel(employeeLevel);
        }

        if (employeeUpdateDto.getName() != null) employee.setName(employeeUpdateDto.getName());
        if (employeeUpdateDto.getSalary() != null) employee.setSalary(employeeUpdateDto.getSalary());
        employeeRepository.save(employee);

        return employeeRepository.findById(employee.getId(), EmployeeView.class);
    }

    @Override
    public HttpStatus deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        if (employee == null) return HttpStatus.NOT_FOUND;

        employee.setDeletedAt(LocalDateTime.now());
        employeeRepository.save(employee);
        return HttpStatus.OK;
    }
}
