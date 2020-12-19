package com.sample.mongorest.RestMongo.controller;

import com.sample.mongorest.RestMongo.entity.Employee;
import com.sample.mongorest.RestMongo.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;

@RestController("employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee create(Employee employee) {
        return employeeService.create(employee);
    }
}
