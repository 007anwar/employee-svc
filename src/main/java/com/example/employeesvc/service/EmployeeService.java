package com.example.employeesvc.service;


import java.util.Optional;

import com.example.employeesvc.dto.EmployeeDto;
import com.example.employeesvc.entity.Employee;
import com.example.employeesvc.repo.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee emp = employeeRepo.save(employee);
        logger.info("Employee saved");
        return emp;
    }

    public Employee getEmployee(String id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(Long.valueOf(id));
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return employee;
        } else {
            return null;
        }
    }

    public int updateEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employeeDto.getId());
        if (optionalEmployee.isPresent()) {
            Employee EmployeeFromDb = optionalEmployee.get();
            String email = employeeDto.getEmail();
            String designation = employeeDto.getDesignation();
            String name = employeeDto.getName();
            if (name != null) {
                EmployeeFromDb.setName(name);
            }
            if (designation != null) {
                EmployeeFromDb.setDesignation(designation);
            }
            if (email != null) {
                EmployeeFromDb.setEmail(email);
            }



            employeeRepo.save(EmployeeFromDb);
            return 1;
        } else {
            return 0;

        }
    }

    public int delete(Long id) {
        Optional<Employee> findById = employeeRepo.findById(id);
        if (findById.isPresent()) {
            Employee emp = findById.get();
            employeeRepo.delete(emp);
            logger.info("Employee deleted");
            return 1;
        } else {
            return 0;
        }
    }
    public Iterable<Employee> getAll() {
        Iterable<Employee> allEmployee = employeeRepo.findAll();
        return allEmployee;
    }

}