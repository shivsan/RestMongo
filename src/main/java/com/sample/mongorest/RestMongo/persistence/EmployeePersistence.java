package com.sample.mongorest.RestMongo.persistence;

import com.sample.mongorest.RestMongo.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePersistence extends CrudRepository<Employee, String> {
}
