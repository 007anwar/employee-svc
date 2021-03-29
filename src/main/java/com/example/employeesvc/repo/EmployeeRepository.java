package com.example.employeesvc.repo;

import com.example.employeesvc.entity.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
}