package com.satriadwi.employee.entity;

public interface EmployeeView {
    Long getId();
    String getName();
    Double getSalary();
    EmployeeLevelView getLevel();

    default Double getSalaryBonus() {
        Double salary = getSalary();
        Float percentage = getLevel().getBonusPercentage();
        return salary * (percentage / 100);
    }

    default Double getSalaryTotal() {
        return getSalary() + getSalaryBonus();
    }
}
