package com.sample.mongorest.RestMongo.controller;

import com.sample.mongorest.RestMongo.entity.Employee;
import com.sample.mongorest.RestMongo.entity.Role;
import com.sample.mongorest.RestMongo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void shouldCreateEmployee() {
        var firstName = "Shivku";
        var lastName = "San";
        var role = Role.Developer;
        Employee employeeToBeCreated = new Employee(firstName, lastName, role);
        Employee createdEmployee = new Employee(firstName, lastName, role);
        when(this.employeeService.create(employeeToBeCreated)).thenReturn(createdEmployee);

        Employee returnedEmployee = employeeController.create(employeeToBeCreated);

        assertEquals(createdEmployee, returnedEmployee);
    }
}
