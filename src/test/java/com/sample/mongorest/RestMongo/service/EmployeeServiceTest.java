package com.sample.mongorest.RestMongo.service;

import com.sample.mongorest.RestMongo.entity.Employee;
import com.sample.mongorest.RestMongo.entity.Role;
import com.sample.mongorest.RestMongo.persistence.EmployeePersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeePersistence employeePersistence;

    @Test
    void shouldCreateEmployee() {
        var id = "1";
        var firstName = "Shivku";
        var lastName = "San";
        var role = Role.Developer;
        Employee employeeToBeCreated = new Employee(firstName, lastName, role);
        Employee createdEmployee = new Employee(id, firstName, lastName, role);
        when(this.employeePersistence.save(employeeToBeCreated)).thenReturn(createdEmployee);

        Employee returnedEmployee = employeeService.create(employeeToBeCreated);

        assertEquals(createdEmployee, returnedEmployee);
    }

    @Test
    void shouldGetEmployee() {
        var id = "1";
        var firstName = "Shivku";
        var lastName = "San";
        var role = Role.Developer;
        Employee employeeToBeReturned = new Employee(id, firstName, lastName, role);
        when(this.employeePersistence.findById(id)).thenReturn(Optional.of(employeeToBeReturned));

        Optional<Employee> returnedEmployee = employeeService.get(id);

        assertEquals(employeeToBeReturned, returnedEmployee.get());
    }
}
