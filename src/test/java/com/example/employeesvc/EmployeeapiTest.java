package com.example.employeesvc;


import com.example.employeesvc.api.Employeeapi;
import com.example.employeesvc.dto.EmployeeDto;
import com.example.employeesvc.entity.Employee;
import com.example.employeesvc.repo.EmployeeRepository;
import com.example.employeesvc.service.EmployeeService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeapiTest {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeapiTest.class);




    //Mocking for not null objects
@InjectMocks
EmployeeService service;
    @InjectMocks
    EmployeeDto dto;
    @Mock
    ModelMapper modelMapper;
    @Mock
    EmployeeRepository employeeRepo;
    @Mock
    Employee emp;
    @Autowired
    Employeeapi api;
    @Mock
    Iterable<Employee> e;
    @InjectMocks
    Employee NullEmployee;





    @Test
    public void testCreateEmployee() {
        NullEmployee.setId(1l);
    Mockito.when(service.createEmployee(dto)).thenReturn(emp);
    ResponseEntity<?> responseEntity = api.create(dto);
    ResponseEntity<?> responseEntity1 = new ResponseEntity<>(NullEmployee,HttpStatus.CREATED);
    Assert.assertEquals(responseEntity, responseEntity1);
}





@Test
public void testUpdateEmployee()
{

    Mockito.when(service.updateEmployee(dto)).thenReturn(1);
    ResponseEntity<String> update = api.update(dto);
    ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.OK);
    Assert.assertEquals(update,objectResponseEntity);
}


    @Test
    public void testGetAllEmployee()
    {
        Mockito.when(service.getAll()).thenReturn(e);
        ResponseEntity<Iterable<Employee>> allEmployee = api.getAllEmployee();
        ResponseEntity<Iterable<Employee>> iterableResponseEntity = new ResponseEntity<>(e, HttpStatus.OK);
        Assert.assertEquals(iterableResponseEntity,allEmployee);

    }


@Test
public void testGetEmployeeById()
{
    emp.setName("anwar");
    emp.setDesignation("Software Engineer");
    emp.setEmail("a@b.com");
    emp.setId(1l);
    Mockito.when(service.getEmployee("1")).thenReturn(emp);
    ResponseEntity<Employee> employeeById = api.getEmployeeById("1");
    Assert.assertEquals(emp,employeeById);
}



}






