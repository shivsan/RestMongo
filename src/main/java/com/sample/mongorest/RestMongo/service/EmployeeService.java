package com.sample.mongorest.RestMongo.service;

import com.sample.mongorest.RestMongo.entity.Employee;
import com.sample.mongorest.RestMongo.persistence.EmployeePersistence;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeePersistence employeePersistence;

    public EmployeeService(EmployeePersistence employeePersistence) {
        this.employeePersistence = employeePersistence;
    }

    public Employee create(Employee employeeToBeCreated) {
        return employeePersistence.save(employeeToBeCreated);
    }

    public Optional<Employee> get(String employeeId) {
        return employeePersistence.findById(employeeId);
    }
}
