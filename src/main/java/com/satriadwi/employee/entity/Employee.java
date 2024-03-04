package com.satriadwi.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "employee", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee")
    private Long id;

    @Column(length = 64)
    private String name;
    private Double salary;
    private LocalDateTime deletedAt = null;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private EmployeeLevel level;
}
