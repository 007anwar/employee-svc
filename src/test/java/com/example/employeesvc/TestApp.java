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
public class TestApp {
    private static final Logger logger = LoggerFactory.getLogger(TestApp.class);



//
//
//    //Mocking for not null objects
//@Mock
//EmployeeService service;
//    @InjectMocks
//    EmployeeDto dto;
//    @Mock
//    ModelMapper modelMapper;
//    @Mock
//    EmployeeRepository employeeRepo;
//    @Mock
//    Employee emp;
//    @Autowired
//    Employeeapi api;
//    @Mock
//    Iterable<Employee> e;
//
//
//
//
//
//    @Test
//    public void testCreateEmployee() {
//    Mockito.when(service.createEmployee(dto)).thenReturn(emp);
//    ResponseEntity<?> responseEntity = api.create(dto);
//    ResponseEntity<?> responseEntity1 = new ResponseEntity<>(HttpStatus.CREATED);
//    Assert.assertEquals(responseEntity, responseEntity1);
//}
//
//
//
//@Test
//        public void testUpdateEmployee() {
//    int x=1;
//    Mockito.when(service.updateEmployee(dto)).thenReturn(x);
//    ResponseEntity<?> update = api.update(dto);
//    ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.OK);
//    Assert.assertEquals(objectResponseEntity,update);
//}
//
//
//
//@Test
//    public void testgetAllEmployee()
//{
//   // Mockito.when(service.getAll()).thenReturn(e);
//    ResponseEntity<?> allEmployee = api.getAllEmployee();
//    ResponseEntity<Iterable<Employee>> iterableResponseEntity = new ResponseEntity<>(e,HttpStatus.OK);
//    Assert.assertEquals(iterableResponseEntity,allEmployee);
//
//
//}
//
////@Test
////        public void testGetAllEmployees()
////{
////    ResponseEntity<Iterable<Employee>> iterableResponseEntity = new ResponseEntity<>(e, HttpStatus.OK);
////    Mockito.when(service.getAll()).thenReturn(e);
////    ResponseEntity<?> allEmployee = api.getAllEmployee();
////    Assert.assertEquals(iterableResponseEntity,allEmployee);
////}
    @Test
    public void hello()
    {
        System.out.println("Hello");
    }

}






