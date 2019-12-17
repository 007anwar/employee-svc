package com.example.employeesvc;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class TestService {
    @Mock
    ModelMapper mapeer;
    @Mock
    EmployeeRepository repo;
    @Mock
    Employee employee;
    @Mock
    Iterable<Employee> allemp;
    @InjectMocks
    EmployeeService service;
    @InjectMocks
    EmployeeDto dto;//null init
    @InjectMocks
    Employee emp;//null init
    @Test
    public void testCreateEmployeeService()
    {
        Mockito.when(mapeer.map(dto, Employee.class)).thenReturn(emp);
        employee = mapeer.map(dto, Employee.class);
        Mockito.when(repo.save(employee)).thenReturn(employee);
        Employee result = service.createEmployee(dto);
        Assert.assertEquals(employee,result);
    }

    @Test
    public void testGetEmployee()
    {
        Optional<Employee> e=Optional.of(emp);
        Employee employee1 = e.get();
        Mockito.when(repo.findById(1l)).thenReturn(e);
        Employee employee = service.getEmployee("1");
        Assert.assertEquals(employee1,employee);
    }

    @Test
    public void testGetAllEmployee()
    {
        Mockito.when(repo.findAll()).thenReturn(allemp);
        Iterable<Employee> all = repo.findAll();
        Iterable<Employee> actualallemp = service.getAll();
        Assert.assertEquals(actualallemp,all);

    }

    @Test
    public void testDeleteEmployee()
    {
        Optional<Employee> e=Optional.of(emp);
        Mockito.when(repo.findById(1l)).thenReturn(e);
        int delete = service.delete(1l);
        Assert.assertEquals(1,delete);
    }
    @Test
    public void testUpdateEmployee()
    {
        dto.setId(1l);
        emp.setId(1l);
        Optional<Employee> e=Optional.of(emp);
        Employee employee = e.get();
        Mockito.when(repo.findById(1l)).thenReturn(e);
        Mockito.when(repo.save(employee)).thenReturn(employee);
        int i = service.updateEmployee(dto);
        Assert.assertEquals(1,i);
    }

}
