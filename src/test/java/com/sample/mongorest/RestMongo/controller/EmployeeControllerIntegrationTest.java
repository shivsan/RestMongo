package com.sample.mongorest.RestMongo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.mongorest.RestMongo.entity.Employee;
import com.sample.mongorest.RestMongo.entity.Role;
import com.sample.mongorest.RestMongo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeController.class)
@ContextConfiguration
class EmployeeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateEmployee() throws Exception {
        Employee employeeToBeCreated = new Employee("firstName", "lastName", Role.Developer);
        Employee createdEmployee = new Employee("id", "", "", Role.Developer);
        when(employeeService.create(employeeToBeCreated)).thenReturn(createdEmployee);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeToBeCreated)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(createdEmployee)));
    }

    @Test
    void shouldGetEmployee() throws Exception {
        String employeeId = "id";
        var employeeToBeReturned = new Employee(employeeId, "firstName", "lastName", Role.Developer);
        when(employeeService.get(employeeId)).thenReturn(Optional.of(employeeToBeReturned));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/" + employeeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(employeeToBeReturned)));
    }

    @Test
    void shouldGetNotFoundForUnknownId() throws Exception {
        String employeeId = "id";
        var employeeToBeReturned = new Employee(employeeId, "firstName", "lastName", Role.Developer);
        when(employeeService.get(employeeId)).thenReturn(Optional.of(employeeToBeReturned));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/" + employeeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(employeeToBeReturned)));
    }
}
