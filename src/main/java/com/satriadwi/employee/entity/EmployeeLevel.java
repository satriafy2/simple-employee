package com.satriadwi.employee.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "employee_level", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLevel extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee_level")
    private Integer id;

    @Column(length = 32)
    private String name;

    @Column(length = 5)
    private Float bonusPercentage;

    @OneToMany(mappedBy = "level")
    private List<Employee> employees;

    public EmployeeLevel(Integer id) {
        this.id = id;
    }
}
