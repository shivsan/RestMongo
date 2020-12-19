package com.sample.mongorest.RestMongo.service;

import com.sample.mongorest.RestMongo.entity.Employee;
import com.sample.mongorest.RestMongo.persistence.EmployeePersistence;

public class EmployeeService {
    private EmployeePersistence employeePersistence;

    public EmployeeService(EmployeePersistence employeePersistence) {
        this.employeePersistence = employeePersistence;
    }

    public Employee create(Employee employeeToBeCreated) {
        return employeePersistence.create(employeeToBeCreated);
    }
}
