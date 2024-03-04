package com.satriadwi.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satriadwi.employee.entity.EmployeeLevel;

@Repository
public interface EmployeeLevelRepository extends JpaRepository<EmployeeLevel, Integer>{
    
}
