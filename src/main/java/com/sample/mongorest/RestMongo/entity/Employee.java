package com.sample.mongorest.RestMongo.entity;

public class Employee {
    public Employee(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    private String firstName;
    private String lastName;
    private Role role;
}
