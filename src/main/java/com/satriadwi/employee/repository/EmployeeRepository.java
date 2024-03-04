package com.satriadwi.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satriadwi.employee.entity.Employee;
import com.satriadwi.employee.entity.EmployeeView;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeView> findByDeletedAtIsNull();
    <T> T findById(Long employeeId, Class<T> type);
}
