package com.mongorest.RestMongo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongorest.RestMongo.entity.Employee;
import com.mongorest.RestMongo.entity.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerE2ETest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void shouldCreateEmployee() throws Exception {
        Employee employeeToBeCreated = new Employee("firstName", "lastName", Role.Developer);

        MvcResult response = mvc.perform(
                MockMvcRequestBuilders.post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeToBeCreated)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Employee returnedEmployee = objectMapper.readValue(response.getResponse().getContentAsString(), Employee.class);
        var createdEmployeeInDb = mongoTemplate.findById(returnedEmployee.getId(), Employee.class);
        Employee expectedEmployee = new Employee(createdEmployeeInDb.getId(), "firstName", "lastName", Role.Developer);

        assertEquals(expectedEmployee, returnedEmployee);
    }

    @Test
    void shouldGetEmployee() throws Exception {
        Employee employeeToBeCreated = new Employee("firstName", "lastName", Role.Developer);
        var createdEmployeeInDb = mongoTemplate.save(employeeToBeCreated);

        MvcResult response = mvc.perform(
                MockMvcRequestBuilders.get("/employee/" + createdEmployeeInDb.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Employee returnedEmployee = objectMapper.readValue(response.getResponse().getContentAsString(), Employee.class);

        assertEquals(createdEmployeeInDb, returnedEmployee);
    }
}
