package com.example.employeesvc.repo;

import com.example.employeesvc.entity.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee,Long> {


}