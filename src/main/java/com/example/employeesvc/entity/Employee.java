package com.example.employeesvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "POJO CLASS FOR EMPLOYEE")
@Entity
@DynamicUpdate
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "employeename")
    private String name;
    private String email;
    private String designation;

}