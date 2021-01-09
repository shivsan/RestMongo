package com.mongorest.RestMongo.controller;

import com.mongorest.RestMongo.entity.Employee;
import com.mongorest.RestMongo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> get(@PathVariable("id") String employeeId) {
        return ResponseEntity.of(employeeService.get(employeeId));
    }
}
