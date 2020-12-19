package com.sample.mongorest.RestMongo.persistence;

import com.sample.mongorest.RestMongo.entity.Employee;

public interface EmployeePersistence {
    Employee create(Employee employeeToBeCreated);
}
