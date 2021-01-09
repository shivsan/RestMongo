package com.mongorest.RestMongo.persistence;

import com.mongorest.RestMongo.entity.Employee;
import com.mongorest.RestMongo.entity.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class EmployeePersistenceIntegrationTest {
    @Autowired
    private EmployeePersistence employeePersistence;

    @Test
    void createEmployeeInDb() {
        var firstName = "Shivku";
        var lastName = "San";
        var role = Role.Developer;
        var createdEmployee = new Employee(firstName, lastName, role);

        var savedEmployee = employeePersistence.save(createdEmployee);

        assertThat(savedEmployee).usingRecursiveComparison().ignoringFields("id").isEqualTo(createdEmployee);
//        assertThat(savedEmployee.getId()).isNotNull().isNotBlank().isNotEmpty();
    }
}
