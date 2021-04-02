package com.example.employeesvc.api;


import com.example.employeesvc.dto.EmployeeDto;
import com.example.employeesvc.entity.Employee;
import com.example.employeesvc.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class Employeeapi {
    Logger logger= Logger.getLogger(Employeeapi.class.getName());
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Creates new user",notes = "Takes Json as input validates it and saves it to database")
    @PostMapping
    public ResponseEntity<Employee> create(
            @ApiParam("Takes Json as input validates it and saves it to database") @Validated @RequestBody final EmployeeDto employeeDto) {
        Employee createEmployee = employeeService.createEmployee(employeeDto);
        if (createEmployee != null) {
            return new ResponseEntity<>(createEmployee,HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("Return employee matching the passed id")
    @GetMapping(path = "{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @ApiParam("id of the employee to be searched") @PathVariable final String id) {

        Employee employee = employeeService.getEmployee(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation("Return all employee")
    @GetMapping(path="/all/{pageNo}")
    public ResponseEntity<Iterable<Employee>> getAllEmployee(@PathVariable final String pageNo) {
        Iterable<Employee> allEmployee = employeeService.getAll(pageNo);
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @ApiOperation("update user by id")
    @PutMapping
    public ResponseEntity<String> update(@ApiParam("Pass employee object") @RequestBody final EmployeeDto employeeDto) throws InterruptedException {
        if (employeeDto.getId() == null) {
            return new ResponseEntity<>("Please specify id", HttpStatus.BAD_REQUEST);
        }
        int update = employeeService.updateEmployee(employeeDto);
        if (update == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Can't find employee with given id.", HttpStatus.NOT_FOUND);
        }

    }

    @ApiOperation("Deletes user by id")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> delete(@ApiParam("Pass long id") @PathVariable Long id) {
        int delete = employeeService.delete(id);
        if (delete == 1) {
            return new ResponseEntity<>("Employee Deleted",HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

