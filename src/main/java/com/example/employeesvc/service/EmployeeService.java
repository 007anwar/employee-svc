package com.example.employeesvc.service;


import java.util.Optional;

import com.example.employeesvc.dto.EmployeeDto;
import com.example.employeesvc.entity.Employee;
import com.example.employeesvc.repo.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;


@Service
@EnableTransactionManagement
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
public final EmployeeRepository employeeRepository;
public EmployeeService(EmployeeRepository employeeRepository )
{this.employeeRepository=employeeRepository;}

    @Autowired
    private ModelMapper modelMapper;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee emp = employeeRepository.save(employee);
        logger.info("Employee saved");
        return emp;
    }
    public Employee getEmployee(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(Long.valueOf(id));
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return employee;
        } else {
            return null;
        }
    }
    @Transactional
    public int updateEmployee(EmployeeDto employeeDto) throws InterruptedException {
      Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getId());

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
          employeeRepository.save(EmployeeFromDb);

          System.out.println("Employee updated but not commited");
          Thread.sleep(30000,1);
          System.out.println("Employee Commeted");
          return 1;
      } else {
          return 0;

      }
  }

    public int delete(Long id) {
        Optional<Employee> findById = employeeRepository.findById(id);
        if (findById.isPresent()) {
            Employee emp = findById.get();
            employeeRepository.delete(emp);
            logger.info("Employee deleted");
            return 1;
        } else {
            return 0;
        }
    }
    public Iterable<Employee> getAll(String pageno) {
        Page<Employee> all = employeeRepository.findAll(PageRequest.of(Integer.parseInt(pageno), 10));
        return all.getContent();
    }

}