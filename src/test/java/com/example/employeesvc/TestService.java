//package com.example.EMPLOYEESVC;
//
//import com.example.EMPLOYEESVC.dto.EmployeeDto;
//import com.example.EMPLOYEESVC.entity.Employee;
//import com.example.EMPLOYEESVC.repo.EmployeeRepository;
//import com.example.EMPLOYEESVC.service.EmployeeService;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Optional;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class TestService {
//    @Mock
//    ModelMapper mapeer;
//    @Mock
//    EmployeeRepository repo;
//    @Mock
//    Employee employee;
//    @InjectMocks
//    EmployeeDto dto;
//    @InjectMocks
//    Employee emp;
//    @Mock
//    Iterable<Employee> allemp;
//    @InjectMocks
//    EmployeeService service;
//
//    @Test
//    public void testCreateEmployeeService()
//    {
//        Mockito.when(mapeer.map(dto, Employee.class)).thenReturn(emp);
//        employee = mapeer.map(dto, Employee.class);
//        Mockito.when(repo.save(employee)).thenReturn(employee);
//        Employee result = service.createEmployee(dto);
//        Assert.assertEquals(employee,result);
//        Mockito.verify(repo).save(employee);
//    }
//
//    @Test
//    public void testGetEmployee()
//    {
//        Optional<Employee> e=Optional.of(emp);
//        Employee employee1 = e.get();
//        Mockito.when(repo.findById(1l)).thenReturn(e);
//        Employee employee = service.getEmployee("1");
//        Assert.assertEquals(employee1,employee);
//        Mockito.verify(repo).findById(1l);
//    }
//
//    @Test
//    public void testDeleteEmployee()
//    {
//        Optional<Employee> e=Optional.of(emp);
//        Mockito.when(repo.findById(1l)).thenReturn(e);
//        int delete = service.delete(1l);
//        Assert.assertEquals(1,delete);
//        Mockito.verify(repo).findById(1l);
//    }
//
//    @Test
//    public void testGetAllEmployee()
//    {
//        Mockito.when(repo.findAll()).thenReturn(allemp);
//        Iterable<Employee> all = repo.findAll();
//        Iterable<Employee> actualallemp = service.getAll();
//        Assert.assertEquals(actualallemp,all);
//        Mockito.verify(repo,Mockito.times(2)).findAll();
//    }
//    @Test
//    public void testUpdateEmployee()
//    {
//        dto.setId(1l);
//        emp.setId(1l);
//        Optional<Employee> e=Optional.of(emp);
//        Employee employee = e.get();
//        Mockito.when(repo.findById(1l)).thenReturn(e);
//        Mockito.when(repo.save(employee)).thenReturn(employee);
//        int i = service.updateEmployee(dto);
//        Assert.assertEquals(1,i);
//    }
//
//}
