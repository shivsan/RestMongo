package com.sample.mongorest.RestMongo.service;

import com.sample.mongorest.RestMongo.entity.Employee;
import com.sample.mongorest.RestMongo.persistence.EmployeePersistence;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeePersistence employeePersistence;

    public EmployeeService(EmployeePersistence employeePersistence) {
        this.employeePersistence = employeePersistence;
    }

    public Employee create(Employee employeeToBeCreated) {
        return employeePersistence.save(employeeToBeCreated);
    }
}
