package com.sample.mongorest.RestMongo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Role role;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    public Employee(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Employee(String id, String firstName, String lastName, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    private Employee() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == (employee.id) &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                role == employee.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, role);
    }
}
